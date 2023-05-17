package com.example.workflow;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

//Test for userstory #2 and its scenarios
public class EventEditTest {
    @Rule
    public ActivityScenarioRule<MainActivity> profile = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testEventCreation() {
        onView(withId(R.id.weeklyButton)).perform(click());
        onView(withId(R.id.eventButton)).perform(click());
        onView(withId(R.id.eventNameET)).perform(typeText("Exercise 2"),closeSoftKeyboard());
        onView(withId(R.id.eventTimeTV)).perform(click());
        onView(withText("OK")).perform(click());
        onView(withId(R.id.saveButton)).perform(click());
        onView(withText("Exercise 2 12:00:00 AM")).perform(click());

    }

}
