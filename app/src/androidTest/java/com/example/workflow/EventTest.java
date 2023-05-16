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



public class EventTest {
    @Rule
    public ActivityScenarioRule<MainActivity> profile = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testEventCreation() {
        onView(withId(R.id.weeklyButton)).perform(click());
        onView(withId(R.id.eventButton)).perform(click());
        onView(withId(R.id.eventNameET)).perform(typeText("Homework"),closeSoftKeyboard());
        onView(withId(R.id.eventTimeTV)).perform(click());





    }




}