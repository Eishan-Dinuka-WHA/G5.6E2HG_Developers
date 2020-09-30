package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Add_Salary extends AppCompatActivity {

    private EditText txtsname;
    private EditText txtbas;
    private EditText txtover;
    private EditText txtallow;
    private EditText txtbonus;
    private EditText txtfest;
    private EditText txtstamp;
    private EditText txtepf;

    private Button sAddbutton;
    private Button sBack_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__salary);

        txtsname = (EditText) findViewById(R.id.ett_eename);
        txtbas = (EditText) findViewById(R.id.ett_bas);
        txtover = (EditText) findViewById(R.id.ett_over);
        txtallow = (EditText) findViewById(R.id.ett_allow);
        txtbonus = (EditText) findViewById(R.id.ett_bonu);
        txtfest = (EditText) findViewById(R.id.ett_fes);
        txtstamp = (EditText) findViewById(R.id.ett_stam);
        txtepf = (EditText) findViewById(R.id.ett_epf);


        sAddbutton = (Button) findViewById(R.id.SUB_btn);
        sBack_btn = (Button) findViewById(R.id.BACK_btn);

        sAddbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Salary salary = new Salary();
                salary.setEname(txtsname.getText().toString());
                salary.setBas(txtbas.getText().toString());
                salary.setOver(txtover.getText().toString());
                salary.setAllow(txtallow.getText().toString());
                salary.setBonus(txtbonus.getText().toString());
                salary.setFest(txtfest.getText().toString());
                salary.setStamp(txtstamp.getText().toString());
                salary.setEpf(txtepf.getText().toString());

                new FirebaseDatabaseHelperForSalary().addSalary(salary, new FirebaseDatabaseHelperForSalary.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Salary> salars, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                        Toast.makeText(Add_Salary.this, "The Salary Details are added Successfully", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });

            }
        });

        sBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                return;
            }
        });
    }
}