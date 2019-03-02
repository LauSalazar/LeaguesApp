package com.example.u93.leagueapp.views.activities;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.u93.leagueapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LeaguesActivityTest {

    @Rule
    public ActivityTestRule<LeaguesActivity> mActivityTestRule = new ActivityTestRule<>(LeaguesActivity.class);

    @Test
    public void leaguesActivityTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Espresso.onView(ViewMatchers.withId(R.id.rvRecyclerLeagues))
                .perform(
                        RecyclerViewActions.actionOnItem(
                                hasDescendant(ViewMatchers.withText("Italian Serie A")),
                                ViewActions.scrollTo()
                        )
                );

        ViewInteraction textView = onView(
                allOf(withId(R.id.tvLeague), withText("Italian Serie A"),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView0 = onView(
                allOf(withId(R.id.tvTeamName), withText("Arsenal"),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.rvRecyclerTeams))
                .perform(
                        RecyclerViewActions.actionOnItem(
                                hasDescendant(ViewMatchers.withText("Arsenal")),
                                ViewActions.scrollTo()
                        )
                );
        Espresso.onView(ViewMatchers.withId(R.id.rvRecyclerTeams))
                .perform(
                        RecyclerViewActions.actionOnItem(
                                hasDescendant(ViewMatchers.withText("Arsenal")),
                                ViewActions.click()
                        )
                );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.ivWebSite),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));
        pressBack();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Espresso.onView(ViewMatchers.withId(R.id.rvRecyclerTeams)).
                check(ViewAssertions.matches(ViewMatchers.withHint("Búsqueda por liga...")));
    }
}
