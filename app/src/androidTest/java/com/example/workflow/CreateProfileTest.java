package com.example.workflow;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



public class CreateProfileTest {
    @Rule
    public ActivityScenarioRule<CreateProfile> profile = new ActivityScenarioRule<CreateProfile>(CreateProfile.class);

    @Test
    public void testInput() {
        onView(withId(R.id.first_name)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.create_profile_button)).perform(click());

        onView(withId(R.id.text_firstname)).check(matches(withText("First Name")));
    }

}