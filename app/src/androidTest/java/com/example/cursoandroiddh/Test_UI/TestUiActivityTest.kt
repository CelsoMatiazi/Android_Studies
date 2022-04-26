package com.example.cursoandroiddh.Test_UI

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.cursoandroiddh.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TestUiActivityTest{

    @get:Rule
    val rule = activityScenarioRule<TestUiActivity>()

    @Test
    fun getText(){
        onView(withId(R.id.test_ui_txt))
            .perform(typeText("Teste DH"), closeSoftKeyboard())
        onView(withId(R.id.test_ui_btn))
            .perform(click())
    }

}