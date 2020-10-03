package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class AddAttendance extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener  {

    private Spinner txtatype;
    private EditText txtaname;
    private EditText txtadate;

    private Button mark_btn;
    private Button back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);

        //        change spinner colour ------------------------------------------------------------------------------------------------------
        Spinner coloredSpinner1 = findViewById(R.id.ett_select);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource( this,R.array.Attendance_edu,R.layout.color_spinner_layout);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner1.setAdapter(adapter1);
        coloredSpinner1.setOnItemSelectedListener(this);

        txtaname = (EditText) findViewById(R.id.ett_addempno);
        txtadate = (EditText) findViewById(R.id.ett_adate);
        txtatype = (Spinner) findViewById(R.id.ett_select);

        mark_btn = (Button) findViewById(R.id.button2);
        back_btn = (Button) findViewById(R.id.button3);

        txtadate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date_picker");
            }
        });

        mark_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txtaname.getText().toString().trim();
                String date = txtadate.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    txtaname.setError("Enter Name is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(date)) {
                    txtadate.setError("Enter valid mobile number");
                    return;
                }

                Attendance attendance = new Attendance();
                attendance.setAtime(txtaname.getText().toString());
                attendance.setAdate(txtadate.getText().toString());
                attendance.setAtype(txtatype.getSelectedItem().toString());

                new FirebaseDatabaseHelperForAttendance().addAtten(attendance, new FirebaseDatabaseHelperForAttendance.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Attendance> attendances, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(AddAttendance.this,"The Mark has Inserted Successfully",Toast.LENGTH_SHORT).show();

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

        back_btn.setOnClickListener(new View.OnClickListener() {
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
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance().format(c.getTime());
        txtadate.setText(currentDate);

    }
}