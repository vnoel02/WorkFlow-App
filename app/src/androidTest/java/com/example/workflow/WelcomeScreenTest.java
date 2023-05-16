package com.example.workflow;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.activity.result.ActivityResult;
import androidx.test.ext.junit.rules.ActivityScenarioRule;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

//Test User stories #8, 10
public class WelcomeScreenTest {
    @Rule
    public ActivityScenarioRule<WelcomeScreen> welcome = new ActivityScenarioRule<>(WelcomeScreen.class);



    // Testing normal app operation
    @Test
    public void navFromWelcomeScreen() {
        onView(withId(R.id.create_profile_button)).perform(click());
        onView(withId(R.id.create_profile)).perform(click());
        onView(withId(R.id.first_name)).perform(typeText("Victor"),closeSoftKeyboard());
        onView(withId(R.id.last_name)).perform(typeText("Noel"),closeSoftKeyboard());
        onView(withId(R.id.user_name)).perform(typeText("vnoel02"),closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("vnoel890@gmail.com"),closeSoftKeyboard());

        onView(withId(R.id.create_profile)).perform(click());
        onView(withId(R.id.miniProfileButton)).perform(click());

    }


    //Testing Delete Button
    @Test
    public void navToDelete() {
        onView(withId(R.id.create_profile_button)).perform(click());
        onView(withId(R.id.create_profile)).perform(click());
        onView(withId(R.id.first_name)).perform(typeText("Victor"),closeSoftKeyboard());
        onView(withId(R.id.last_name)).perform(typeText("Noel"),closeSoftKeyboard());
        onView(withId(R.id.user_name)).perform(typeText("vnoel02"),closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("vnoel890@gmail.com"),closeSoftKeyboard());

        onView(withId(R.id.create_profile)).perform(click());
        onView(withId(R.id.miniProfileButton)).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());

        onView(withId(R.id.textview_first)).check(matches(isDisplayed()));
    }
}