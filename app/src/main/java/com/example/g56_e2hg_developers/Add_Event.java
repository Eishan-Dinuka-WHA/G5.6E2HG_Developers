package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class Add_Event extends AppCompatActivity {

    private Spinner txttype;
    private EditText txtname;
    private EditText txtemail;
    private EditText txtename;
    private EditText txtnog;
    private EditText txtdate;
    private Spinner txthtype;
    private EditText txtnop;
    private EditText txthprice;

    private Button mAdd_btn;
    private Button mBack_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__event);

        txttype = (Spinner) findViewById(R.id.ett_etype);
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

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}