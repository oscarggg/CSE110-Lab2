package edu.ucsd.cse110.lab2;

import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            var oneBtn = (TextView) activity.findViewById(R.id.btn_one);
            var plusBtn = (TextView) activity.findViewById(R.id.btn_plus);
            var equalBtn = (TextView) activity.findViewById(R.id.btn_equals);
            TextView display = activity.findViewById(R.id.display);
            oneBtn.performClick();
            plusBtn.performClick();
            oneBtn.performClick();
            equalBtn.performClick();
            var value = display.getText().toString();
            Assert.assertEquals(2,Integer.parseInt(value));
        });
    }
}
