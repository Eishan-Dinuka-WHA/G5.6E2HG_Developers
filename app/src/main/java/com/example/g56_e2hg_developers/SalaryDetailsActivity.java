package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class SalaryDetailsActivity extends AppCompatActivity {

    private EditText txtename;
    private EditText txtbas;
    private EditText txtover;
    private EditText txtallow;
    private EditText txtbonus;
    private EditText txtfest;
    private EditText txtstamp;
    private EditText txtepf;

    private Button sDelete_btn;
    private Button sUpdate_btn;

    private String key;
    private String ename;
    private String bas;
    private String over;
    private String allow;
    private String bonus;
    private String fest;
    private String stamp;
    private String epf;
    private Double tdeducation;
    private Double tarning;
    private Double totalp;
    private Double calepf;
    private Double calepf1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_details);

        key = getIntent().getStringExtra("key");
        ename = getIntent().getStringExtra("ename");
        bas = getIntent().getStringExtra("bas");
        over = getIntent().getStringExtra("over");
        allow = getIntent().getStringExtra("allow");
        bonus = getIntent().getStringExtra("bonus");
        fest = getIntent().getStringExtra("fest");
        stamp = getIntent().getStringExtra("stamp");
        epf = getIntent().getStringExtra("epf");

        txtename = (EditText) findViewById(R.id.ett_eename);
        txtename.setText(ename);
        txtbas = (EditText) findViewById(R.id.ett_bas);
        txtbas.setText(bas);
        txtover = (EditText) findViewById(R.id.ett_over);
        txtover.setText(over);
        txtallow = (EditText) findViewById(R.id.ett_allow);
        txtallow.setText(allow);
        txtbonus = (EditText) findViewById(R.id.ett_bonu);
        txtbonus.setText(bonus);
        txtfest = (EditText) findViewById(R.id.ett_fes);
        txtfest.setText(fest);
        txtstamp = (EditText) findViewById(R.id.ett_stam);
        txtstamp.setText(stamp);
        txtepf = (EditText) findViewById(R.id.ett_epf);
        txtepf.setText(epf);

        sUpdate_btn = (Button) findViewById(R.id.Up_BTN);
        sDelete_btn = (Button) findViewById(R.id.Del);

        sUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tarning =  Double.parseDouble(txtbas.getText().toString()) +  Double.parseDouble(txtover.getText().toString())+ Double.parseDouble(txtallow.getText().toString())+ Double.parseDouble(txtbonus.getText().toString());
                tdeducation =   Double.parseDouble(txtfest.getText().toString()) +  Double.parseDouble(txtstamp.getText().toString())+ Double.parseDouble(txtepf.getText().toString());


                calepf1 = Double.parseDouble(txtbas.getText().toString()) * 0.1;

//                calepf = Integer.parseInt(txtbas.getText().toString())+10;

                totalp= (tarning)-(tdeducation + calepf1);

                Salary salary = new Salary();
                salary.setEname(txtename.getText().toString());
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



                new FirebaseDatabaseHelperForSalary().UpdateSalary(key, salary, new FirebaseDatabaseHelperForSalary.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Salary> salars, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(SalaryDetailsActivity.this,"Salary detials has been Updated Successfully",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        sDelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelperForSalary().DeleteSalary(key, new FirebaseDatabaseHelperForSalary.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Salary> salars, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(SalaryDetailsActivity.this,"Salary Details has been Deleted Successfully",Toast.LENGTH_SHORT).show();
                        finish();
                        return;

                    }
                });
            }
        });
    }
}