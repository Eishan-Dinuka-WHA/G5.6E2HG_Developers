package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PizzaSuper extends AppCompatActivity {

    private Button ORDER;
    private Button BACK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_super);

        ORDER = findViewById(R.id.buttonres2);
        BACK  = findViewById(R.id.buttonres3);

        ORDER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PizzaSuper.this,pizzaOne.class);
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