package com.example.g56_e2hg_developers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Add_SalaryTest {
    private Add_Salary add_salary;

    @Before
    public void setup() {
        add_salary = new Add_Salary();
    }

    @Test
    public void calcear() {

        int input1 = 1000;
        int input2 = 1000;
        int input3 = 1000;
        int output;

        int expected = 3000;
        double delta = 0.001;

        output = Add_Salary.calcear(1000, 1000, 1000);

        assertEquals(3000, output);

    }

    @Test
    public void testRun() {
        float result = add_salary.newTest(100.0f, 100.0f, 100.0f);

        assertEquals(300.0, result, 0.001);
    }
}