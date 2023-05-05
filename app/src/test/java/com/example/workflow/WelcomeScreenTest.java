package com.example.workflow;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;
import android.app.Activity;

import android.content.Intent;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


public class WelcomeScreenTest {


   @Rule
   ActivityScenario<WelcomeScreen> welcomeScreen;
    @Test
    public void testIntent() {

       //WelcomeScreen welcomeScreen = new WelcomeScreen();

        //
        welcomeScreen.onActivity(activity -> {
            onView(withId(R.id.create_profile_button)).perform(click());
        });

        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), CreateProfile.class);

        ActivityScenario<CreateProfile> createProfile = ActivityScenario.launch(intent);
        createProfile.onActivity(activity -> {
            onView(withId(R.layout.activity_create_profile)).check(matches(isDisplayed()));
        });




    }
}