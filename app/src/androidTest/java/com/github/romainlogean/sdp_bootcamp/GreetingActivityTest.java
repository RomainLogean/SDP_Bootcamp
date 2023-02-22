package com.github.romainlogean.sdp_bootcamp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;
import android.util.Log;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {

    @Test
    public void GoodWayTest(){
        String greetingText = "Welcome in my app Ema !";
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intent.putExtra("NAME", "Ema");

        try {
            ActivityScenario.launch(intent);

            onView(ViewMatchers.withId(R.id.greeting_text)).check(matches(withText(greetingText)));
        }
        catch (Exception e) {
            Log.e("GreetingActivityTest", "Error launching activity: ${e.message}");
        }
    }
}