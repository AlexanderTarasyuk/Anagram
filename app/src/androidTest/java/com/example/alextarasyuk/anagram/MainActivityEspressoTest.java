package com.example.alextarasyuk.anagram;


import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextFromInputTextIsConvertedToAnagramToTextViewResultAfterButtonConvertIsClicked() {

        onView(withId(R.id.edt_input_text))
                .perform(typeText("asdf")
                        , closeSoftKeyboard());

        onView(withId(R.id.btn_convert))
                .perform(click());

        onView(withId(R.id.tv_result))
                .check(matches(withText("Initial text is: " + "asdf" +
                        "\n  Anagram is:  " + "fdsa")));
        Spoon.screenshot(mainActivityActivityTestRule.getActivity(), "ButtonIsClickedAndResultMustAppear");


    }

    @Test
    public void ensureTextFromInputTextIfIsEmptyToastWillApearAfterButtonConvertIsClicked() {

        onView(withId(R.id.edt_input_text))
                .perform(typeText("")
                        , closeSoftKeyboard());

        onView(withId(R.id.btn_convert))
                .perform(click());

        onView(withText(startsWith("Please"))).
                inRoot(withDecorView(
                        not(is(mainActivityActivityTestRule.getActivity().
                                getWindow().getDecorView())))).
                check(matches(isDisplayed()));
        Spoon.screenshot(mainActivityActivityTestRule.getActivity(), "ToastMustApeear");

    }

    @Test
    public void ensureEditTextIsCleanAfterButtonConvertIsClicked() {

        onView(withId(R.id.btn_convert))
                .perform(click());
        onView(withId(R.id.edt_input_text))
                .check(matches(withText("")));

        Spoon.screenshot(mainActivityActivityTestRule.getActivity(), "ButtonConvertIsClickedAndEditTextIsCleaned");

    }

    @Test
    public void ensureTextVievStateIsTheSameAfterChangingTheOrientation() {
        onView(withId(R.id.edt_input_text))
                .perform(typeText("asdf")
                        , closeSoftKeyboard());

        onView(withId(R.id.btn_convert))
                .perform(click());

        rotateScreen();

        onView(withId(R.id.tv_result))
                .check(matches(withText("Initial text is: " + "asdf" +
                        "\n  Anagram is:  " + "fdsa")));

        rotateScreen();

        onView(withId(R.id.tv_result))
                .check(matches(withText("Initial text is: " + "asdf" +
                        "\n  Anagram is:  " + "fdsa")));

        Spoon.screenshot(mainActivityActivityTestRule.getActivity(), "CheckTextViewAfterRotation");


    }

    //rotates the screen
    private void rotateScreen() {
        Context context = InstrumentationRegistry.getTargetContext();
        int orientation
                = context.getResources().getConfiguration().orientation;

        Activity activity = mainActivityActivityTestRule.getActivity();
        activity.setRequestedOrientation(
                (orientation == Configuration.ORIENTATION_PORTRAIT) ?
                        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE :
                        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
