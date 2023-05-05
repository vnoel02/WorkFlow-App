package codewithcal.au.calendarappexample;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;




import com.example.workflow.R;

import org.junit.Test;

public class MainActivityTest {

    @Test
    public void imageButtonOnClick() {
        onView(withId(R.id.miniProfileButton)).perform(click());
        onView(withId(R.layout.activity_profile_view)).check(matches(isDisplayed()));
    }
}