package com.example.g56_e2hg_developers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Add_SalaryTest2 {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calduc() {

        double input1 = 1000;
        double input2 = 1000;
        double input3 = 1000;
        double input4 = 1000;
        double output;

        double expected = 4000;
        double delta = 0.001;

        output = Add_Salary.calduc(1000, 1000, 1000,1000);

        assertEquals(4000, output,delta);
    }
}