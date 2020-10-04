package com.example.g56_e2hg_developers;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FirebaseDatabaseHelperForRoom {
    private FirebaseDatabase rDatabase;
    private DatabaseReference rReferenceRoom;
    private List<Room> rooms = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Room> rooms, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelperForRoom() {
        rDatabase = FirebaseDatabase.getInstance();
        rReferenceRoom = rDatabase.getReference("rooms");
    }

    public void readRooms(final DataStatus dataStatus){
        rReferenceRoom.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rooms.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Room room = keyNode.getValue(Room.class);
                    rooms.add(room);
                }
                dataStatus.DataIsLoaded(rooms,keys);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError ) {

            }
        });
    }

    public void  addRoom(Room room, final DataStatus dataStatus){
        String key = rReferenceRoom.push().getKey();
        rReferenceRoom.child(key).setValue(room).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();

            }
        });
    }

    public void updateRoom(String key, Room room, final DataStatus dataStatus){
        rReferenceRoom.child(key).setValue(room).addOnSuccessListener( new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }

    public void deleteBook(String key, final DataStatus dataStatus){
        rReferenceRoom.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}

