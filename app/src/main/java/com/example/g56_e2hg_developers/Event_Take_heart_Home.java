package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Event_Take_heart_Home extends AppCompatActivity {

    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event__take_heart__home);

        button1 = findViewById(R.id.T_btn_book);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Event_Take_heart_Home.this,Add_Event.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.t_btn_view);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Event_Take_heart_Home.this,List_Event.class);
                startActivity(intent);
            }
        });
    }
}