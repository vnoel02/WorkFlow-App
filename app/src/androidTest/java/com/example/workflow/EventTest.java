package com.example.workflow;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;



//Test for User Stories # 1
public class EventTest {
    @Rule
    public ActivityScenarioRule<MainActivity> profile = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testEventCreation() {
        onView(withId(R.id.weeklyButton)).perform(click());
        onView(withId(R.id.eventButton)).perform(click());
        onView(withId(R.id.eventNameET)).perform(typeText("Homework"),closeSoftKeyboard());
        onView(withId(R.id.eventTimeTV)).perform(click());
        onView(withText("OK")).perform(click());
        onView(withId(R.id.saveButton)).perform(click());
    }
}