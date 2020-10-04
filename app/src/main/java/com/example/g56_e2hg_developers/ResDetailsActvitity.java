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

public class ResDetailsActvitity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner txtmeal;
    private Spinner txtsize;
    private Spinner txtquantity;
    private EditText txtname;
    private EditText txtcontacts;
    private EditText txtemail;
    private EditText txthouse;
    private EditText txtstreet;
    private EditText txtcity;

    private Button mDelete_btn;
    private Button mUpdate_btn;

    private String key;
    private String meal;
    private String size;
    private String quantity;
    private String cus_name;
    private String con_no;
    private String email;
    private String house_no;
    private String street;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_details_actvitity);

        //        change spinner colour ------------------------------------------------------------------------------------------------------
        Spinner coloredSpinner = findViewById(R.id.reet_selectedd);
        ArrayAdapter adapter = ArrayAdapter.createFromResource( this,R.array.meal,R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner.setAdapter(adapter);
        coloredSpinner.setOnItemSelectedListener(this);
        //        change spinner colour ------------------------------------------------------------------------------------------------------
        Spinner coloredSpinner1 = findViewById(R.id.reet_selected);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource( this,R.array.portion_type,R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner1.setAdapter(adapter1);
        coloredSpinner1.setOnItemSelectedListener(this);
        //        change spinner colour ------------------------------------------------------------------------------------------------------
        Spinner coloredSpinner2 = findViewById(R.id.reet_quea);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource( this,R.array.quantity,R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        coloredSpinner2.setAdapter(adapter2);
        coloredSpinner2.setOnItemSelectedListener(this);
// -----------------------------------------------------------------------------------------------------------------------------------


        key = getIntent().getStringExtra("key");
        meal = getIntent().getStringExtra("meal");
        size = getIntent().getStringExtra("size");
        quantity = getIntent().getStringExtra("quantity");
        cus_name = getIntent().getStringExtra("cus_name");
        con_no = getIntent().getStringExtra("con_no");
        email = getIntent().getStringExtra("email");
        house_no = getIntent().getStringExtra("house_no");
        street = getIntent().getStringExtra("street");
        city = getIntent().getStringExtra("city");


        txtmeal = (Spinner) findViewById(R.id.reet_selectedd);
        txtmeal.setSelection(getIndex_spinnerItem(txtmeal, meal));

        txtsize = (Spinner) findViewById(R.id.reet_selected);
        txtsize.setSelection(getIndex_spinnerItem(txtsize, size));

        txtquantity = (Spinner) findViewById(R.id.reet_quea);
        txtquantity.setSelection(getIndex_spinnerItem(txtquantity, quantity));

        txtname = (EditText) findViewById(R.id.rett_name);
        txtname.setText(cus_name);

        txtcontacts = (EditText) findViewById(R.id.rett_details);
        txtcontacts.setText(con_no);

        txtemail = (EditText) findViewById(R.id.rett_mail);
        txtemail.setText(email);

        txthouse = (EditText) findViewById(R.id.rett_hno);
        txthouse.setText(house_no);

        txtstreet  = (EditText) findViewById(R.id.rett_street);
        txtstreet.setText(street);

        txtcity = (EditText) findViewById(R.id.rett_city);
        txtcity.setText(city);

        mUpdate_btn = (Button) findViewById(R.id.update_btn);
        mDelete_btn = (Button) findViewById(R.id.delete_btn);

        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Resturant resturant = new Resturant();
                resturant.setMeal(txtmeal.getSelectedItem().toString());
                resturant.setSize(txtsize.getSelectedItem().toString());
                resturant.setQuantity(txtquantity.getSelectedItem().toString());
                resturant.setCus_name(txtname.getText().toString());
                resturant.setCon_no(txtcontacts.getText().toString());
                resturant.setEmail(txtemail.getText().toString());
                resturant.setHouse_no(txthouse.getText().toString());
                resturant.setStreet(txtstreet.getText().toString());
                resturant.setCity(txtcity.getText().toString());


                new FirebaseDatabaseHelpersForResturant().UpdateResturants(key, resturant, new FirebaseDatabaseHelpersForResturant.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Resturant> resturants, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(ResDetailsActvitity.this, "Your Order has been Update Successfully", Toast.LENGTH_SHORT).show();


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
                new FirebaseDatabaseHelpersForResturant().DeleteResturants(key, new FirebaseDatabaseHelpersForResturant.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Resturant> resturants, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(ResDetailsActvitity.this, "Your Order has been Deleted Successfully", Toast.LENGTH_SHORT).show();
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