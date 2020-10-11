package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class pizzaOne extends AppCompatActivity {

    private Spinner txtmeal;
    private Spinner txtsize;
    private Spinner txtquantity;
    private EditText txtname;
    private EditText txtcontacts;
    private EditText txtemail;
    private EditText txthouse;
    private EditText txtstreet;
    private EditText txtcity;
    private Spinner txttime;
    private Double total;

    private Button sAddbutton;
    private Button sBack_btn;
    private Button sview_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_one);

        txtmeal = (Spinner) findViewById(R.id.reet_selectedd);
        txtsize = (Spinner) findViewById(R.id.reet_selected);
        txtquantity = (Spinner) findViewById(R.id.reet_quea);
        txtname = (EditText) findViewById(R.id.rett_name);
        txtcontacts = (EditText) findViewById(R.id.rett_details);
        txtemail = (EditText) findViewById(R.id.rett_mail);
        txthouse = (EditText) findViewById(R.id.rett_hno);
        txtstreet  = (EditText) findViewById(R.id.rett_street);
        txtcity  = (EditText) findViewById(R.id.rett_city);
        txttime  = (Spinner) findViewById(R.id.reet_selecteddd);


        sAddbutton = (Button) findViewById(R.id.sub_btn);
        sBack_btn = (Button) findViewById(R.id.back_btn);
        sview_btn = (Button) findViewById(R.id.view_btn);

        sview_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pizzaOne.this,ResturantListActivity.class);
                startActivity(intent);
            }
        });


        sAddbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nm = txtname.getText().toString().trim();
                String cnum = txtcontacts.getText().toString().trim();
                String email = txtemail.getText().toString().trim();
                String hnum = txthouse.getText().toString().trim();
                String street = txtstreet.getText().toString().trim();
                String city = txtcity.getText().toString().trim();


                if (TextUtils.isEmpty(nm)) {
                    txtname.setError("Enter Name is Required.");
                    return;
                } else if (TextUtils.isEmpty(cnum)) {
                    txtcontacts.setError("Enter Your Contacts");
                    return;
                } else if (TextUtils.isEmpty(email)) {
                    txtemail.setError("Enter Your Email ");
                    return;
                } else if (TextUtils.isEmpty(hnum)) {
                    txthouse.setError("Details are Required");
                    return;
                } else if (TextUtils.isEmpty(street)) {
                    txtstreet.setError("Details are Required");
                    return;
                } else if (TextUtils.isEmpty(city)) {
                    txtcity.setError("Details are Required");
                    return;
                }


                if(txtsize.getSelectedItem().toString().equals("Medium Rs.500")){
                    total = 500 * Double.parseDouble(txtquantity.getSelectedItem().toString());
                }
                else if(txtsize.getSelectedItem().toString().equals("Large Rs.800")){
                    total = 800 * Double.parseDouble(txtquantity.getSelectedItem().toString());
                }

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
                resturant.setTime(txttime.getSelectedItem().toString());
                resturant.setTotal(total);


                new FirebaseDatabaseHelpersForResturant().addResturants(resturant, new FirebaseDatabaseHelpersForResturant.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Resturant> resturants, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(pizzaOne.this,"Order Placed Successfully",Toast.LENGTH_SHORT).show();
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
        sBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                return;
            }
        });
    }
}
