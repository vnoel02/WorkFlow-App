package codewithcal.au.calendarappexample;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import android.content.Intent;

import com.example.workflow.R;

import org.junit.Test;

public class WelcomeScreenUnitTest {

    @Test
    public void testIntent() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();

        Intent intent = new Intent(welcomeScreen, ProfileViewActivity.class);
        intent.putExtra("key","value");
        welcomeScreen.startActivity(intent);

        onView(withId(R.layout.activity_create_profile)).check(matches(isDisplayed()));


    }

}