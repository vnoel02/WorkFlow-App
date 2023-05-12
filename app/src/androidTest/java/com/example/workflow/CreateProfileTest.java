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
    public void testFirstName() {
        onView(withId(R.id.first_name)).perform(typeText("Victor"),closeSoftKeyboard());
        onView(withId(R.id.create_profile)).perform(click());

        onView(withId(R.id.text_firstname)).check(matches(withText("Victor")));
    }
    @Test
    public void testLastName() {
        onView(withId(R.id.last_name)).perform(typeText("Noel"),closeSoftKeyboard());
        onView(withId(R.id.create_profile)).perform(click());

        onView(withId(R.id.text_firstname)).check(matches(withText("Noel")));
    }
    @Test
    public void testUserName() {
        onView(withId(R.id.user_name)).perform(typeText("vnoel02"),closeSoftKeyboard());
        onView(withId(R.id.create_profile)).perform(click());

        onView(withId(R.id.text_firstname)).check(matches(withText("vnoel02")));
    }
    @Test
    public void testEmail() {
        onView(withId(R.id.email)).perform(typeText("vnoel890@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.create_profile)).perform(click());

        onView(withId(R.id.text_firstname)).check(matches(withText("vnoel890@gmail.com")));
    }



}