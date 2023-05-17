package com.example.workflow;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;



//test User stories#9,7
public class CreateProfileTest {
    @Rule
    public ActivityScenarioRule<CreateProfile> profile = new ActivityScenarioRule<>(CreateProfile.class);

    @Test
    public void testProfileCreation() {
        onView(withId(R.id.first_name)).perform(typeText("Victor"),closeSoftKeyboard());
        onView(withId(R.id.last_name)).perform(typeText("Noel"),closeSoftKeyboard());
        onView(withId(R.id.user_name)).perform(typeText("vnoel02"),closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("vnoel890@gmail.com"),closeSoftKeyboard());

        onView(withId(R.id.create_profile)).perform(click());
        onView(withId(R.id.miniProfileButton)).perform(click());

        onView(withId(R.id.text_firstname)).check(matches(withText("Victor")));
        onView(withId(R.id.text_lastName)).check(matches(withText("Noel")));
        onView(withId(R.id.profile_username)).check(matches(withText("vnoel02")));
        onView(withId(R.id.profile_email)).check(matches(withText("vnoel890@gmail.com")));



    }




}