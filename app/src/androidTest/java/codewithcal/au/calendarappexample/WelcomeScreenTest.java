package codewithcal.au.calendarappexample;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import com.example.workflow.R;

import org.junit.Test;


public class WelcomeScreenTest {

    @Test
    public void testSendUserOnClick() {
        onView(withId(R.id.create_profile_button)).perform(click());
    }
}