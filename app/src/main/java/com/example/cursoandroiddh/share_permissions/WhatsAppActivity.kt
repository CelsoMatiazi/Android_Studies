package com.example.cursoandroiddh.share_permissions

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.cursoandroiddh.R

class WhatsAppActivity : AppCompatActivity(R.layout.activity_whats_app) {

    private lateinit var shareBtn : ImageView
    private lateinit var userName : EditText
    private lateinit var imageBtn : CardView
    private lateinit var userImage : ImageView
    private lateinit var editName : ImageView


    private val permissionResultCallback = registerForActivityResult(
        ActivityResultContracts.RequestPermission()){
        if(it){
            userImage.context?.let { context ->
                Toast.makeText(this, "Premission Granted", Toast.LENGTH_SHORT).show()
                dialogPhoto(context)
            }
        }else{
            Toast.makeText(this, "Premission Denied", Toast.LENGTH_SHORT).show()
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.dark_green2)

        shareBtn = findViewById(R.id.whatsapp_share_btn)
        userName = findViewById(R.id.whatsapp_name)
        imageBtn = findViewById(R.id.background_cam_img)
        userImage = findViewById(R.id.whatsapp_userImage)
        editName = findViewById(R.id.whatsapp_editName_btn)


        userName.isFocusable = false
        var changeName = true


        editName.setOnClickListener {
            changeName(changeName)
            changeName = !changeName
        }
        shareBtn.setOnClickListener { shareName() }

        imageBtn.setOnClickListener { dialogPhoto(it.context) }


    }

    private fun printScreen(view: View): Bitmap? {
        var screen: Bitmap? = null
        try{
            screen = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(screen)
            view.draw(canvas)
        } catch (e: Exception){
            Log.e("IMAGE_ERROR", e.message.toString())
        }

        return screen
    }



    private fun changeName(status: Boolean){
        if(status){
            userName.isFocusableInTouchMode = true
            userName.isEnabled
            userName.requestFocus()
            editName.setImageResource(R.drawable.ic_baseline_check_24)
            openKey()
        }else{
            userName.isFocusable = false
            editName.setImageResource(R.drawable.ic_baseline_edit_24)
            closeKey()
        }
    }


    private fun shareName(){
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT, userName.text.toString())
            type = "text/plain"
        }
        startActivity(Intent.createChooser(sendIntent, "Compartilhando Contato"))
    }


    private fun dialogPhoto(context: Context) {
        val items = arrayOf("Tirar foto", "Carregar foto", "Remover foto" ,"Compartilhar foto")
        AlertDialog
            .Builder(context)
            .setTitle("O que você deseja fazer?")
            .setItems(items) { dialog, index ->
                when (index) {
                    0 -> getPermissions()
                    1 -> getUserPhoto()
                    2 -> userImage.setImageResource(R.drawable.ic_baseline_supervised_user_circle_24)
                    3 ->{
                        printScreen(userImage)?.let {
                            SaveFile(this, it).saveAndShare()
                        }
                    }
                }
                dialog.dismiss()
            }.show()
    }

    private fun getUserPhoto(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        getResultGallery.launch(intent)
    }

    private val getResultGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            userImage.setImageURI(it.data?.data)
        }
    }

    private fun getPermissions(){
        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        if(permission == PackageManager.PERMISSION_GRANTED){
            val intent = Intent().apply {
                action = MediaStore.ACTION_IMAGE_CAPTURE
            }
            getResultCamera.launch(intent)
        }else{
            permissionResultCallback.launch(Manifest.permission.CAMERA)
        }
    }

    private val getResultCamera = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            val data = it.data
            data?.extras?.get("data")?.let{ image ->
                userImage?.setImageBitmap(image as Bitmap)
            }
        }
    }


    private fun openKey(){
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.toggleSoftInputFromWindow(
                editName.applicationWindowToken,
                InputMethodManager.SHOW_FORCED, 0
            )

    }

    private fun closeKey(){
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            editName.windowToken, 0

        )
    }
}