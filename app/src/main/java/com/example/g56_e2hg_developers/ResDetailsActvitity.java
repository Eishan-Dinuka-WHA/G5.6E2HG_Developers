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

public class ResDetailsActvitity extends AppCompatActivity {
    private Spinner txtmeal;
    private Spinner txtsize;
    private Spinner txtquantity;
    private Spinner txttime;
    private EditText txtname;
    private EditText txtcontacts;
    private EditText txtemail;
    private EditText txthouse;
    private EditText txtstreet;
    private EditText txtcity;
    private Double total;

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
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_details_actvitity);

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
        time = getIntent().getStringExtra("time");


        txtmeal = (Spinner) findViewById(R.id.reet_selectedd);
        txtmeal.setSelection(getIndex_spinnerItem(txtmeal, meal));

        txtsize = (Spinner) findViewById(R.id.reet_selected);
        txtsize.setSelection(getIndex_spinnerItem(txtsize, size));

        txtquantity = (Spinner) findViewById(R.id.reet_quea);
        txtquantity.setSelection(getIndex_spinnerItem(txtquantity, quantity));

        txttime = (Spinner) findViewById(R.id.reet_selecteddd);
        txttime.setSelection(getIndex_spinnerItem(txttime, time));

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
}