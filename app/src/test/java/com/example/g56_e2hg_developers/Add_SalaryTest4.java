package com.example.g56_e2hg_developers;

import org.junit.Test;

import static org.junit.Assert.*;

public class Add_SalaryTest4 {

    @Test
    public void total() {

        double input1 = 200;
        double input2 = 100;
        double input3 = 100;
        double output;

        double expected = 100.0;
        double delta = 0.001;

        output = Add_Salary.total(300,100,100);

        assertEquals(100.0, output,delta);
    }

}