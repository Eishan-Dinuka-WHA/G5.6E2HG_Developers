package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;
import java.util.Random;


public class Add_EmpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText txtID;
    private EditText txtFname;
    private EditText txtmob;
    private EditText txtadd;
    private EditText txtdob;
    private EditText txtnic;
    private Spinner txtdesign;
    private Spinner txttype;
    private Spinner txtgen;
    private Spinner txtedu;



    private Button mAdd_btn;
    private Button mBack_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__emp);

//        change spinner colour ------------------------------------------------------------------------------------------------------
        Spinner coloredSpinner1 = findViewById(R.id.ett_gen);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource( this,R.array.Gender_catagory,R.layout.color_spinner_layout);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner1.setAdapter(adapter1);
        coloredSpinner1.setOnItemSelectedListener(this);

        Spinner coloredSpinner2 = findViewById(R.id.ett_des);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource( this,R.array.Employee_desig,R.layout.color_spinner_layout);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner2.setAdapter(adapter2);
        coloredSpinner2.setOnItemSelectedListener(this);

        Spinner coloredSpinner3 = findViewById(R.id.ett_edu);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource( this,R.array.Employee_edu,R.layout.color_spinner_layout);
        adapter3.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner3.setAdapter(adapter3);
        coloredSpinner3.setOnItemSelectedListener(this);

        Spinner coloredSpinner4 = findViewById(R.id.ett_etype);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource( this,R.array.Employee_type,R.layout.color_spinner_layout);
        adapter4.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner4.setAdapter(adapter4);
        coloredSpinner4.setOnItemSelectedListener(this);
// -----------------------------------------------------------------------------------------------------------------------------------

        txtID = (EditText) findViewById(R.id.ett_no);
        txtFname = (EditText) findViewById(R.id.ett_name);
        txtmob =  (EditText) findViewById(R.id.ett_mob);
        txtadd = (EditText) findViewById(R.id.ett_add);
        txtdob = (EditText) findViewById(R.id.ett_dob);
        txtnic = (EditText) findViewById(R.id.ett_nic);
        txtdesign = (Spinner) findViewById(R.id.ett_des);
        txttype = (Spinner) findViewById(R.id.ett_etype);
        txtgen = (Spinner) findViewById(R.id.ett_gen);
        txtedu = (Spinner) findViewById(R.id.ett_edu);

        mAdd_btn = (Button) findViewById(R.id.sub_btn);
        mBack_btn = (Button) findViewById(R.id.back_btn);

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String fname = txtFname.getText().toString().trim();
                String mobile = txtmob.getText().toString().trim();
                String add = txtadd.getText().toString().trim();
                String nic = txtnic.getText().toString().trim();
                String dob = txtdob.getText().toString().trim();


                if (TextUtils.isEmpty(fname)) {
                    txtFname.setError("Enter Name is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(mobile)) {
                    txtmob.setError("Enter valid mobile number");
                    return;
                }
                else if (TextUtils.isEmpty(add)) {
                    txtadd.setError("Enter Address is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(nic)) {
                    txtadd.setError("Enter Valid NIC is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(dob)) {
                    txtadd.setError("Enter DOB is Required.");
                    return;
                }


                final Random random = new Random();


                Employee employee = new Employee();
                employee.setId(String.valueOf(random.nextInt(10000)));
                employee.setFname(txtFname.getText().toString());
                employee.setMob(txtmob.getText().toString());
                employee.setAdd(txtadd.getText().toString());
                employee.setDob(txtdob.getText().toString());
                employee.setNic(txtnic.getText().toString());
                employee.setDesin(txtdesign.getSelectedItem().toString());
                employee.setType(txttype.getSelectedItem().toString());
                employee.setGen(txtgen.getSelectedItem().toString());
                employee.setEdu(txtedu.getSelectedItem().toString());

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
//        Toast.makeText(this,parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
    }
//----------------------------------------------------------------------------------------------------------
}