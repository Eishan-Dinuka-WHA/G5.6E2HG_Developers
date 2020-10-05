package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class pizzaHome extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_home);


        imageView1 = findViewById(R.id.pizza1);
        imageView2 = findViewById(R.id.pizza2);
        imageView3 = findViewById(R.id.pizza3);
        imageView4 = findViewById(R.id.pizza4);



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pizzaHome.this, PizzaChicken.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pizzaHome.this,PizzaSuper.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pizzaHome.this,PizzaPrawn.class);
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pizzaHome.this,PizzaHot.class);
                startActivity(intent);
            }
        });
    }
}