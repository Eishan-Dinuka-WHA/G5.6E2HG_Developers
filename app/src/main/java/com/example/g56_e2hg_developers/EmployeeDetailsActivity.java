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

public class EmployeeDetailsActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    private EditText txtID;
    private EditText txtFname;
    private EditText txtmob;
    private EditText txtadd;
    private EditText txtdnic;
    private EditText txtdob;
    private Spinner txtdesign;
    private Spinner txttype;
    private Spinner txtgen;
    private Spinner txtedu;

    private Button mDelete_btn;
    private Button mUpdate_btn;

    private String key;
    private String id;
    private String fname;
    private String mob;
    private String add;
    private String desin;
    private String nic;
    private String dob;
    private String type;
    private String gen;
    private String edu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        //        change spinner colour ------------------------------------------------------------------------------------------------------
        Spinner coloredSpinner = findViewById(R.id.ett_gens);
        ArrayAdapter adapter = ArrayAdapter.createFromResource( this,R.array.Gender_catagory,R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner.setAdapter(adapter);
        coloredSpinner.setOnItemSelectedListener(this);
// -----------------------------------------------------------------------------------------------------------------------------------


        key = getIntent().getStringExtra("key");
        id = getIntent().getStringExtra("id");
        fname = getIntent().getStringExtra("fname");
        mob = getIntent().getStringExtra("mob");
        add = getIntent().getStringExtra("add");
        desin = getIntent().getStringExtra("desin");
        nic = getIntent().getStringExtra("nic");
        dob = getIntent().getStringExtra("dob");
        type = getIntent().getStringExtra("type");
        gen = getIntent().getStringExtra("gen");
        edu = getIntent().getStringExtra("edu");

        txtID = (EditText) findViewById(R.id.ett_no);
        txtID.setText(id);
        txtFname = (EditText) findViewById(R.id.ett_name);
        txtFname.setText(fname);
        txtmob = (EditText) findViewById(R.id.ett_mob);
        txtmob.setText(mob);
        txtadd = (EditText) findViewById(R.id.ett_add);
        txtadd.setText(add);
        txtdnic = (EditText) findViewById(R.id.ett_nic);
        txtdnic.setText(nic);
        txtdob = (EditText) findViewById(R.id.ett_dob);
        txtdob.setText(dob);

        txtdesign = (Spinner) findViewById(R.id.ett_des);
        txtdesign.setSelection(getIndex_spinnerItem(txtdesign, desin));

        txttype = (Spinner) findViewById(R.id.ett_eetype);
        txttype.setSelection(getIndex_spinnerItem(txttype, type));

        txtgen = (Spinner) findViewById(R.id.ett_gens);
        txtgen.setSelection(getIndex_spinnerItem(txtgen, gen));

        txtedu = (Spinner) findViewById(R.id.ett_edu);
        txtedu.setSelection(getIndex_spinnerItem(txtedu, edu));

        mUpdate_btn = (Button) findViewById(R.id.update_btn);
        mDelete_btn = (Button) findViewById(R.id.delete_btn);

        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Employee employee = new Employee();
                employee.setId(id);
                employee.setFname(txtFname.getText().toString());
                employee.setMob(txtmob.getText().toString());
                employee.setAdd(txtadd.getText().toString());
                employee.setNic(txtdnic.getText().toString());
                employee.setDob(txtdob.getText().toString());
                employee.setDesin(txtdesign.getSelectedItem().toString());
                employee.setType(txttype.getSelectedItem().toString());
                employee.setGen(txtgen.getSelectedItem().toString());
                employee.setEdu(txtedu.getSelectedItem().toString());

                new FirebaseDatabaseHelperForEmployee().UpdateEmployee(key, employee, new FirebaseDatabaseHelperForEmployee.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Employee> employees, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(EmployeeDetailsActivity.this,"Employee record has been Updated Successfully",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        mDelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelperForEmployee().DeleteEmployee(key, new FirebaseDatabaseHelperForEmployee.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Employee> employees, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(EmployeeDetailsActivity.this,"Employee record has been Deleted Successfully",Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                });
            }
        });
    }

    private int getIndex_spinnerItem(Spinner spinner,String item){
        int index = 0;
        for(int i = 0; i<spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}