package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class ResturantListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview_res);
        new FirebaseDatabaseHelpersForResturant().readResturants(new FirebaseDatabaseHelpersForResturant.DataStatus() {
            @Override
            public void DataIsLoaded(List<Resturant> resturants, List<String> keys) {
                findViewById(R.id.progressBarres).setVisibility(View.GONE);
                new RecycleView_ConfigforRes().setConfig(recyclerView,ResturantListActivity.this,resturants,keys);

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