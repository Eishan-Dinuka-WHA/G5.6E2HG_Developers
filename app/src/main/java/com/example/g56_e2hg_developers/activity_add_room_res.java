package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class activity_add_room_res extends AppCompatActivity {

    private EditText txtname;
    private EditText txtemail;
    private EditText txttype;
    private EditText txtguests;
    private EditText txtadate;
    private EditText txtddate;

    private Button mAdd_btn;
    private Button mBack_btn;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room_res);

        txtname = (EditText) findViewById(R.id.etno2);
        txtemail = (EditText) findViewById(R.id.etno3);
        txttype =  (EditText) findViewById(R.id.etno4);
        txtguests = (EditText) findViewById(R.id.etno5);
        txtadate =  (EditText) findViewById(R.id.etno6);
        txtddate = (EditText) findViewById(R.id.etno7);


        mAdd_btn = (Button) findViewById(R.id.submit_btn2);
        mBack_btn = (Button) findViewById(R.id.back_btn3);


        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_add_room_res.this,room_item_list.class);
                startActivity(intent);
            }
        });

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Room room = new Room();
                room.setRname(txtname.getText().toString());
                room.setRemail(txtemail.getText().toString());
                room.setRtype(txttype.getText().toString());
                room.setRguests(txtguests.getText().toString());
                room.setAdate(txtadate.getText().toString());
                room.setDdate(txtddate.getText().toString());

                new FirebaseDatabaseHelperForRoom().addRoom(room, new FirebaseDatabaseHelperForRoom.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Room> room, List<String> keys) {
                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(activity_add_room_res.this, "The Room has Inserted Successfully", Toast.LENGTH_SHORT).show();

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



