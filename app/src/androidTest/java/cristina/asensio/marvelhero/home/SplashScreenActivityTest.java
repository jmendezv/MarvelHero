package cristina.asensio.marvelhero.home;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import cristina.asensio.marvelhero.R;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

public class SplashScreenActivityTest {

    @Rule
    public ActivityTestRule splashActivity = new ActivityTestRule(SplashScreenActivity.class);

    @Test
    public void splashScreen_checkCandidateNameIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.tv_candidateName)).check(matches(isDisplayed()));
    }

}