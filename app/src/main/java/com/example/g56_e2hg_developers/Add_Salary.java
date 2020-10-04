package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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
    private int tdeducation;
    private int tarning;
    private int totalp;
    private float calepf;

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

                String name = txtsname.getText().toString().trim();
                String bas = txtbas.getText().toString().trim();
                String over = txtover.getText().toString().trim();
                String allow = txtallow.getText().toString().trim();
                String bonus = txtbonus.getText().toString().trim();
                String fest = txtfest.getText().toString().trim();
                String stamp = txtstamp.getText().toString().trim();
                String epf = txtepf.getText().toString().trim();


                if (TextUtils.isEmpty(name)) {
                    txtsname.setError("Enter Name is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(bas)) {
                    txtbas.setError("Enter Basic Salary");
                    return;
                }
                else if (TextUtils.isEmpty(over)) {
                    txtover.setError("Enter over time ");
                    return;
                }
                else if (TextUtils.isEmpty(allow)) {
                    txtallow.setError("Enter allowance Salary");
                    return;
                }
                else if (TextUtils.isEmpty(bonus)) {
                    txtbonus.setError("Enter Bonus Salary");
                    return;
                }
                else if (TextUtils.isEmpty(fest)) {
                    txtfest.setError("Enter Fest Advance Salary");
                    return;
                }
                else if (TextUtils.isEmpty(stamp)) {
                    txtstamp.setError("Enter stamp");
                    return;
                }
                else if (TextUtils.isEmpty(epf)) {
                    txtepf.setError("Enter loan");
                    return;
                }

                tarning = Integer.parseInt(txtbas.getText().toString()) + Integer.parseInt(txtover.getText().toString())+Integer.parseInt(txtallow.getText().toString())+Integer.parseInt(txtbonus.getText().toString());
                tdeducation =  Integer.parseInt(txtfest.getText().toString()) + Integer.parseInt(txtstamp.getText().toString())+Integer.parseInt(txtepf.getText().toString());
                //calepf = Integer.parseInt(txtbas.getText().toString())*(10/100.0f);
                totalp= tarning-tdeducation;




                Salary salary = new Salary();
                salary.setEname(txtsname.getText().toString());
                salary.setBas(txtbas.getText().toString());
                salary.setOver(txtover.getText().toString());
                salary.setAllow(txtallow.getText().toString());
                salary.setBonus(txtbonus.getText().toString());
                salary.setFest(txtfest.getText().toString());
                salary.setStamp(txtstamp.getText().toString());
                salary.setEpf(txtepf.getText().toString());
                salary.setTearning(tarning);
                salary.setTdeducation(tdeducation);
                salary.setTotalp(totalp);

                new FirebaseDatabaseHelperForSalary().addSalary(salary, new FirebaseDatabaseHelperForSalary.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Salary> salary, List<String> keys) {

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
    public static int calcear( int basic, int overtime, int allownce  ){
        int val;
        val = basic+overtime+allownce;
        return val;
    }

    public float newTest(float one, float two, float three){
        return one+two+three;

    }
}