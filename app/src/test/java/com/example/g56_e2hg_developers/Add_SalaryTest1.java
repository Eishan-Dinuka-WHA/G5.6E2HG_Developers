package com.example.g56_e2hg_developers;

import org.junit.Test;

import static org.junit.Assert.*;

public class Add_SalaryTest1 {
    private Add_Salary add_salary;


    @Test
    public void newTest() {

        double input1 = 1000;
        double input2 = 1000;
        double input3 = 1000;
        double input4 = 1000;
        double output;

        double expected = 4000;
        double delta = 0.001;

        output = Add_Salary.calcear(1000, 1000, 1000,1000);

        assertEquals(4000, output,delta);
    }
}