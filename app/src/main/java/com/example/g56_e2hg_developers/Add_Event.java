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

public class Add_Event extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    private Spinner txttype;
    private EditText txtname;
    private EditText txtemail;
    private EditText txtename;
    private EditText txtnog;
    private EditText txtdate;
    private Spinner txthtype;
    private EditText txtnop;
    private EditText txthprice;
    private int total;

    private Button mAdd_btn;
    private Button mBack_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__event);

        //        change spinner colour ------------------------------------------------------------------------------------------------------
        Spinner coloredSpinner1 = findViewById(R.id.ett_evtype);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource( this,R.array.Event_catagory,R.layout.color_spinner_layout);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner1.setAdapter(adapter1);
        coloredSpinner1.setOnItemSelectedListener(this);

        Spinner coloredSpinner2 = findViewById(R.id.ett_htype);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource( this,R.array.Hall_Type,R.layout.color_spinner_layout);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner2.setAdapter(adapter2);
        coloredSpinner2.setOnItemSelectedListener(this);
        //-----------------------------------------------------------------------------------------------------------------------------------

        txttype = (Spinner) findViewById(R.id.ett_evtype);
        txtname = (EditText) findViewById(R.id.ett_name);
        txtemail = (EditText) findViewById(R.id.ett_email);
        txtename = (EditText) findViewById(R.id.ett_ename);
        txtnog = (EditText) findViewById(R.id.ett_nog);
        txtdate = (EditText) findViewById(R.id.ett_date);
        txthtype = (Spinner) findViewById(R.id.ett_htype);
        txtnop = (EditText) findViewById(R.id.ett_nop);
        txthprice = (EditText) findViewById(R.id.ett_hprice);

        mAdd_btn = (Button) findViewById(R.id.update_btn);
        mBack_btn = (Button) findViewById(R.id.delete_btn);

        txtdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date_picker");
            }
        });

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//-----------------------------------------------------------------------------------------------


                String name = txtname.getText().toString().trim();
                String email = txtemail.getText().toString().trim();
                String ename = txtename.getText().toString().trim();
                String nog = txtnog.getText().toString().trim();
                String date = txtdate.getText().toString().trim();
                String nop = txtnop.getText().toString().trim();
                String price = txthprice.getText().toString().trim();



                if (TextUtils.isEmpty(name)) {
                    txtname.setError("Enter Name is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(email)) {
                    txtemail.setError("Email is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(ename)) {
                    txtename.setError("Event Name is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(nog)) {
                    txtnog.setError("Enter number of guest is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(date)) {
                    txtdate.setError("Enter date is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(nop)) {
                    txtdate.setError("Enter Number of Plate is Required.");
                    return;
                }
                else if (TextUtils.isEmpty(price)) {
                    txtdate.setError("Enter Plate price is Required.");
                    return;
                }


                total = Integer.parseInt(txthprice.getText().toString()) * Integer.parseInt(txtnop.getText().toString());



                Event event = new Event();
                event.setEtype(txttype.getSelectedItem().toString());
                event.setName(txtname.getText().toString());
                event.setEmail(txtemail.getText().toString());
                event.setEname(txtename.getText().toString());
                event.setNog(txtnog.getText().toString());
                event.setDate(txtdate.getText().toString());
                event.setHtype(txthtype.getSelectedItem().toString());
                event.setNop(txtnop.getText().toString());
                event.setHprice(txthprice.getText().toString());
                event.setTotalP(total);

                new FirebaseDatabaseHelperForEvent().addEvents(event, new FirebaseDatabaseHelperForEvent.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Event> events, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(Add_Event.this,"The Event has Booked Successfully",Toast.LENGTH_SHORT).show();

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance().format(c.getTime());
        txtdate.setText(currentDate);

    }
}