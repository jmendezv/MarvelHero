package cristina.asensio.marvelhero.home;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;
import cristina.asensio.marvelhero.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    @Rule
    public ActivityTestRule mainActivity = new ActivityTestRule(MainActivity.class);

    @Test
    public void mainActivity_checkHeroNameTextviewIsDisplayed() {
        onView(withId(R.id.tv_hero_name)).check(matches(isDisplayed()));
    }

}