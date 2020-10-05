package com.example.g56_e2hg_developers;

import android.view.View;
import android.widget.LinearLayout;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import junit.extensions.ActiveTestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> mainActivityTestRule = new ActivityScenarioRule<LoginActivity>(LoginActivity.class);
    private LoginActivity lactivity = null;


    @Before
    public void setUp() throws Exception {

        ActivityScenario scenario = mainActivityTestRule.getScenario();
    }

    @Test
    public void testLaunch(){
        View view = lactivity.findViewById(R.id.email_editText);
        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        lactivity = null;
    }
}