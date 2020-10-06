package com.example.g56_e2hg_developers;

import org.junit.Test;

import static org.junit.Assert.*;

public class Add_SalaryTest3 {

    @Test
    public void calcepf() {

        double input1 = 1000;
        double output;

        double expected = 100.0;
        double delta = 0.001;

        output = Add_Salary.calcepf(1000);

        assertEquals(100.0, output,delta);
    }
}