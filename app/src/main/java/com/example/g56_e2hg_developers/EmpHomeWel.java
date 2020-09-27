package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EmpHomeWel extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_home_wel);


        imageView1 = findViewById(R.id.adde);
        imageView2 = findViewById(R.id.addel);
        imageView3 = findViewById(R.id.adda);
        imageView4 = findViewById(R.id.addal);
        imageView5 = findViewById(R.id.adds);
        imageView6 = findViewById(R.id.addsl);


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmpHomeWel.this, Add_EmpActivity.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmpHomeWel.this, List_Employee.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmpHomeWel.this, Add_EmpActivity.class);
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmpHomeWel.this, Add_EmpActivity.class);
                startActivity(intent);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmpHomeWel.this, Add_EmpActivity.class);
                startActivity(intent);
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmpHomeWel.this, Add_EmpActivity.class);
                startActivity(intent);
            }
        });

    }
}