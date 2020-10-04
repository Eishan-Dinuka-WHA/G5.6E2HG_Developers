package com.example.g56_e2hg_developers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RoomDetailsActivity extends AppCompatActivity {

    private EditText rname_editTxt;
    private EditText remail_editTxt;
    private EditText rtype_editTxt;
    private EditText rguests_editTxt;
    private EditText radate_editTxt;
    private EditText rddate_editTxt;
    private Button submit_btn2_btn;
    private Button update_btn3_btn;
    private Button delate_btn;

    private String key;
    private String rname;
    private String remail;
    private String rtype;
    private String rguests;
    private String adate;
    private String ddate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        key = getIntent().getStringExtra("key");
        rname = getIntent().getStringExtra("rname");
        remail = getIntent().getStringExtra("remail");
        rtype = getIntent().getStringExtra("rtype");
        rguests = getIntent().getStringExtra("rguests");
        adate = getIntent().getStringExtra("adate");
        ddate = getIntent().getStringExtra("ddate");

        rname_editTxt = (EditText) findViewById(R.id.etno2);
        rname_editTxt.setText(rname);
        remail_editTxt = (EditText) findViewById(R.id.etno3);
        remail_editTxt.setText(remail);
        rtype_editTxt = (EditText) findViewById(R.id.etno4);
        rtype_editTxt.setText(rtype);
        rguests_editTxt = (EditText) findViewById(R.id.etno5);
        rguests_editTxt.setText(rguests);
        radate_editTxt = (EditText) findViewById(R.id.etno6);
        radate_editTxt.setText(adate);
        rddate_editTxt = (EditText) findViewById(R.id.etno7);
        rddate_editTxt.setText(ddate);

        update_btn3_btn = (Button) findViewById(R.id.update_btn3);
        delate_btn = (Button) findViewById(R.id.delete_btn2);

        update_btn3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Room room = new Room();
                room.setRname(rname_editTxt.getText().toString());
                room.setRemail((remail_editTxt.getText().toString()));
                room.setRtype(rtype_editTxt.getText().toString());
                room.setRguests(rguests_editTxt.getText().toString());
                room.setAdate(radate_editTxt.getText().toString());
                room.setDdate(rddate_editTxt.getText().toString());

                new FirebaseDatabaseHelperForRoom().updateRoom(key, room, new FirebaseDatabaseHelperForRoom.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Room> rooms, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {


                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(RoomDetailsActivity.this, "The room details have been updated successfully", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        delate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelperForRoom().deleteBook(key, new FirebaseDatabaseHelperForRoom.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Room> rooms, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(RoomDetailsActivity.this, "Deleted", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
