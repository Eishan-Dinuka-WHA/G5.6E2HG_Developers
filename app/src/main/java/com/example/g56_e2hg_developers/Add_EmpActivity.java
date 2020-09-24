package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.List;


public class Add_EmpActivity extends AppCompatActivity {

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

        txtID = findViewById(R.id.etno);
        txtFname = findViewById(R.id.etfname);
        txtmob = findViewById(R.id.etmob);
        txtadd = findViewById(R.id.etadd);
        txtdesign = findViewById(R.id.etdes);
        txttype = findViewById(R.id.ettype);
        txtgen = findViewById(R.id.etgen);
        txtedu = findViewById(R.id.etedu);

        mAdd_btn = (Button) findViewById(R.id.update_btn);
        mBack_btn = (Button) findViewById(R.id.delete_btn);

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
}