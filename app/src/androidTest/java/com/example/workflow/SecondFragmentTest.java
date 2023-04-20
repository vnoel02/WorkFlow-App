package com.example.workflow;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SecondFragmentTest {


    public FragmentScenario<SecondFragment> fragmentScenario;

    @Before
    public void setup() {
        fragmentScenario = FragmentScenario.launchInContainer(SecondFragment.class);
        fragmentScenario.moveToState(Lifecycle.State.STARTED);
    }

    @Test
    public void testUserDataInput() {

        onView(withId(R.id.first_name)).perform(clearText(), typeText("Victor"));
        onView(withId(R.id.last_name)).perform(clearText(), typeText("Noel"));
        //onView(withId(R.id.user_name)).perform(clearText(), typeText("vnoel02"));

        onView(withId(R.id.first_name)).check(matches(withText("Victor")));
        onView(withId(R.id.last_name)).check(matches(withText("Noel")));
        //onView(withId(R.id.user_name)).check(matches(withText("vnoel02")));
    }

    @Test
    public void testButtonClick() {
        // Click on the "Create Profile Button"
        onView(withId(R.id.create_profile)).perform(click());

        //If the activity is shown
        onView(withId(R.id.activity_calendar)).check(matches(isDisplayed()));

    }

    @Test
    public void testSharedPref() {
        
    }



}