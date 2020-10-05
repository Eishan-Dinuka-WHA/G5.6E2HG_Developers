package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PizzaChicken extends AppCompatActivity {

    private Button ORDER;
    private Button BACK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_chicken);

        ORDER = findViewById(R.id.button21);
        BACK  = findViewById(R.id.button31);

        ORDER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PizzaChicken.this,pizzaOne.class);
                startActivity(intent);
            }
        });

        BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                return;
            }
        });

    }
}