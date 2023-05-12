package com.example.workflow;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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


public class WelcomeScreenTest {
    @Rule
    public ActivityScenarioRule<WelcomeScreen> welcome = new ActivityScenarioRule<>(WelcomeScreen.class);

    //@Rule public ActivityScenarioRule<CreateProfile> profile = new ActivityScenarioRule<CreateProfile>(CreateProfile.class);


    @Test
    public void navFromWelcomeScreen() {
        onView(withId(R.id.create_profile_button)).perform(click());


//        welcome.getScenario().onActivity(activity -> {
//            Intent intent = new Intent(activity, ProfileViewActivity.class);
//            activity.startActivity(intent);
//        });


        onView(withId(R.id.create_profile_layout)).check(matches(isDisplayed()));





    }

}