package com.example.workflow;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasTextColor;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

//Test userstories for #6
public class testNightMode {
    @Rule
    public ActivityScenarioRule<ProfileViewActivity> profile = new ActivityScenarioRule<ProfileViewActivity>(ProfileViewActivity.class);

    @Test
    public void testEventCreation() {
        onView(withId(R.id.btnDarkMode)).perform(click());
        onView(withId(R.id.btnDarkMode)).perform(click());
        //Just one detail to ensure night mode change
        onView(withId(R.id.text_firstname)).check(matches(hasTextColor(R.color.white)));


    }
}
