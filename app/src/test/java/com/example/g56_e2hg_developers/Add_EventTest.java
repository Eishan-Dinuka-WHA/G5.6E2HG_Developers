package com.example.g56_e2hg_developers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Add_EventTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calc() {

        double input1 = 10;
        double input2 = 100;

        double output;

        double expected = 1000;
        double delta = 0.001;

        output = Add_Event.calc(10,100);

        assertEquals(1000, output,delta);
    }
}