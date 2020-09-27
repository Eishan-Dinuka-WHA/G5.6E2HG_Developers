package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class EventDetailsActivity extends AppCompatActivity {

    private Spinner txttype;
    private EditText txtname;
    private EditText txtemail;
    private EditText txtename;
    private EditText txtnog;
    private EditText txtdate;
    private Spinner txthtype;
    private EditText txtnop;
    private EditText txthprice;

    private Button mDelete_btn;
    private Button mUpdate_btn;

    private String key;
    private String etype;
    private String name;
    private String email;
    private String ename;
    private String nog;
    private String date;
    private String htype;
    private String nop;
    private String hprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        key = getIntent().getStringExtra("key");
        etype = getIntent().getStringExtra("etype");
        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        ename = getIntent().getStringExtra("ename");
        nog = getIntent().getStringExtra("nog");
        date = getIntent().getStringExtra("date");
        htype = getIntent().getStringExtra("htype");
        nop = getIntent().getStringExtra("nop");
        hprice = getIntent().getStringExtra("hprice");

        txttype = (Spinner) findViewById(R.id.ett_etype);
        txttype.setSelection(getIndex_spinnerItem(txttype, etype));
        txtname = (EditText) findViewById(R.id.ett_name);
        txtname.setText(name);
        txtemail = (EditText) findViewById(R.id.ett_email);
        txtemail.setText(email);
        txtename = (EditText) findViewById(R.id.ett_ename);
        txtename.setText(ename);
        txtnog = (EditText) findViewById(R.id.ett_nog);
        txtnog.setText(nog);
        txtdate = (EditText) findViewById(R.id.ett_date);
        txtdate.setText(date);
        txthtype = (Spinner) findViewById(R.id.ett_htype);
        txthtype.setSelection(getIndex_spinnerItem(txthtype, htype));
        txtnop = (EditText) findViewById(R.id.ett_nop);
        txtnop.setText(nop);
        txthprice = (EditText) findViewById(R.id.ett_hprice);
        txthprice.setText(hprice);


        mUpdate_btn = (Button) findViewById(R.id.update_btn);
        mDelete_btn = (Button) findViewById(R.id.delete_btn);

        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
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

                new FirebaseDatabaseHelperForEvent().UpdateEvents(key, event, new FirebaseDatabaseHelperForEvent.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Event> events, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(EventDetailsActivity.this,"Event record has been Updated Successfully",Toast.LENGTH_SHORT).show();
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
                new FirebaseDatabaseHelperForEvent().DeleteEvents(key, new FirebaseDatabaseHelperForEvent.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Event> events, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                        Toast.makeText(EventDetailsActivity.this,"Event record has been Deleted Successfully",Toast.LENGTH_SHORT).show();
                        finish();
                        return;

                    }
                });
            }
        });
    }

    private int getIndex_spinnerItem(Spinner spinner, String item) {
        int index = 0;
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }
}