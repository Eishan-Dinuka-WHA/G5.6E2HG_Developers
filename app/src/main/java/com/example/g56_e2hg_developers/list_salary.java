package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class list_salary extends AppCompatActivity {


    private RecyclerView sRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_salary);

        sRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_salary);
        new FirebaseDatabaseHelperForSalary().readSalary(new FirebaseDatabaseHelperForSalary.DataStatus() {
            @Override
            public void DataIsLoaded(List<Salary> salaries, List<String> keys) {

                findViewById(R.id.progressBar_salary).setVisibility(View.GONE);
                new RecyclerView_Config_Salary().setConfig(sRecyclerView,list_salary.this,salaries,keys);
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