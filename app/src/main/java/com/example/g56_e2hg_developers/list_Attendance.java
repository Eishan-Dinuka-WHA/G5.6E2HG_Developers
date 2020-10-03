package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class list_Attendance extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__attendance);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_att);

        new FirebaseDatabaseHelperForAttendance().readAtten(new FirebaseDatabaseHelperForAttendance.DataStatus() {
            @Override
            public void DataIsLoaded(List<Attendance> attendances, List<String> keys) {
                findViewById(R.id.progressBaratt).setVisibility(View.GONE);
                new RecyclerView_Config_Attendance().setConfig(mRecyclerView, list_Attendance.this, attendances, keys);
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