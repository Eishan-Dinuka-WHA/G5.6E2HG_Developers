package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class List_Event extends AppCompatActivity {

    private RecyclerView eRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__event);

        eRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_events);
        new FirebaseDatabaseHelperForEvent().readEvents(new FirebaseDatabaseHelperForEvent.DataStatus() {
            @Override
            public void DataIsLoaded(List<Event> events, List<String> keys) {
                findViewById(R.id.progressBar_event).setVisibility(View.GONE);
                new RecyclerView_ConfigforEvent().setConfig(eRecyclerView,List_Event.this,events,keys);
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