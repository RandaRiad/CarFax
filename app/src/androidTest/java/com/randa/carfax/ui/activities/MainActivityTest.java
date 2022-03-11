package com.randa.carfax.ui.activities;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import android.content.Intent;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnitRunner;

import com.randa.carfax.R;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
   public ActivityTestRule<MainActivity> mainActivityRule=new ActivityTestRule<MainActivity>(MainActivity.class);
   private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity=mainActivityRule.getActivity();

    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void checkClick(){
        onView(withId(R.id.carRecyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));


    }
}