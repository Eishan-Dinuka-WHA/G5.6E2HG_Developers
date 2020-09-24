package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class List_Employee extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__employee);
        mRecyclerView =(RecyclerView) findViewById(R.id.recyclerview_employees);
        new FirebaseDatabaseHelperForEmployee().readEmployee(new FirebaseDatabaseHelperForEmployee.DataStatus() {
            @Override
            public void DataIsLoaded(List<Employee> employees, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView,List_Employee.this,employees,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}