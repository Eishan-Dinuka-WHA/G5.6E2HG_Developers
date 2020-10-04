package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class room_item_list extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_item_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview_for_room);
        new FirebaseDatabaseHelperForRoom().readRooms(new FirebaseDatabaseHelperForRoom.DataStatus() {
            @Override
            public void DataIsLoaded(List<Room> rooms, List<String> keys) {
                findViewById(R.id.progressBarrrr).setVisibility(View.GONE);
                new RecycleView_ConfigRoom().setConfig(mRecyclerView,room_item_list.this,rooms,keys);
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