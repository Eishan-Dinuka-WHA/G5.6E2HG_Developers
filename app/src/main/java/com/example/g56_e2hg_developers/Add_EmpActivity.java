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


public class Add_EmpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText txtID;
    private EditText txtFname;
    private EditText txtmob;
    private EditText txtadd;
    private EditText txtdesign;
    private EditText txttype;
    private Spinner txtgen;
    private EditText txtedu;


    private Button mAdd_btn;
    private Button mBack_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__emp);

//        change spinner colour ------------------------------------------------------------------------------------------------------
        Spinner coloredSpinner = findViewById(R.id.ett_gen);
        ArrayAdapter adapter = ArrayAdapter.createFromResource( this,R.array.Gender_catagory,R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner.setAdapter(adapter);
        coloredSpinner.setOnItemSelectedListener(this);
// -----------------------------------------------------------------------------------------------------------------------------------
        txtID = (EditText) findViewById(R.id.ett_no);
        txtFname = (EditText) findViewById(R.id.ett_name);
        txtmob =  (EditText) findViewById(R.id.ett_mob);
        txtadd = (EditText) findViewById(R.id.ett_add);
        txtdesign = (EditText) findViewById(R.id.ett_des);
        txttype = (EditText) findViewById(R.id.ett_etype);
        txtgen = (Spinner) findViewById(R.id.ett_gen);
        txtedu = (EditText) findViewById(R.id.ett_edu);

        mAdd_btn = (Button) findViewById(R.id.sub_btn);
        mBack_btn = (Button) findViewById(R.id.back_btn);

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Employee employee = new Employee();
                employee.setId(txtID.getText().toString());
                employee.setFname(txtFname.getText().toString());
                employee.setMob(txtmob.getText().toString());
                employee.setAdd(txtadd.getText().toString());
                employee.setDesin(txtdesign.getText().toString());
                employee.setType(txttype.getText().toString());
                employee.setGen(txtgen.getSelectedItem().toString());
                employee.setEdu(txtedu.getText().toString());

                new FirebaseDatabaseHelperForEmployee().addEmployee(employee, new FirebaseDatabaseHelperForEmployee.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Employee> employees, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(Add_EmpActivity.this,"The Employee has Inserted Successfully",Toast.LENGTH_SHORT).show();

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

    mBack_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
            return;
        }
    });
    }
//---------------------------------------------------------------------------------------------------------
    // for Spppiner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
    }
//----------------------------------------------------------------------------------------------------------
}