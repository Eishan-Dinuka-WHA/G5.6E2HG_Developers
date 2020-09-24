package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class EmployeeDetailsActivity extends AppCompatActivity {
    private EditText txtID;
    private EditText txtFname;
    private EditText txtmob;
    private EditText txtadd;
    private EditText txtdesign;
    private EditText txttype;
    private Spinner txtgen;
    private EditText txtedu;

    private Button mDelete_btn;
    private Button mUpdate_btn;

    private String key;
    private String id;
    private String fname;
    private String mob;
    private String add;
    private String desin;
    private String type;
    private String gen;
    private String edu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        key = getIntent().getStringExtra("key");
        id = getIntent().getStringExtra("id");
        fname = getIntent().getStringExtra("fname");
        mob = getIntent().getStringExtra("mob");
        add = getIntent().getStringExtra("add");
        desin = getIntent().getStringExtra("desin");
        type = getIntent().getStringExtra("type");
        gen = getIntent().getStringExtra("gen");
        edu = getIntent().getStringExtra("edu");

        txtID = (EditText) findViewById(R.id.etno);
        txtID.setText(id);
        txtFname = (EditText) findViewById(R.id.etfname);
        txtFname.setText(fname);
        txtmob = (EditText) findViewById(R.id.etmob);
        txtmob.setText(mob);
        txtadd = (EditText) findViewById(R.id.etadd);
        txtadd.setText(add);
        txtdesign = (EditText) findViewById(R.id.etdes);
        txtdesign.setText(desin);
        txttype = (EditText) findViewById(R.id.ettype);
        txttype.setText(type);
        txtgen = (Spinner) findViewById(R.id.etgen);
        txtgen.setSelection(getIndex_spinnerItem(txtgen, gen));
        txtedu = (EditText) findViewById(R.id.etedu);
        txtedu.setText(edu);

        mUpdate_btn = (Button) findViewById(R.id.update_btn);
        mDelete_btn = (Button) findViewById(R.id.delete_btn);

        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
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
        for(int i = 0;i<spinner.getCount();i++) {
            if (Objects.equals(spinner.getItemIdAtPosition(i), item)) {
                index = i;
                break;
            }
        }
        return index;
    }
}