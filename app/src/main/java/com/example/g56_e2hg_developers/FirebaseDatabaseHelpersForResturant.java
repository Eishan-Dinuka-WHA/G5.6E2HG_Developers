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

public class FirebaseDatabaseHelpersForResturant {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceResturants;
    private List<Resturant> resturants = new ArrayList<> ();

    public interface DataStatus{
        void DataIsLoaded(List<Resturant> resturants, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public FirebaseDatabaseHelpersForResturant() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceResturants = mDatabase.getReference("restru");
    }
    public void readResturants(final DataStatus dataStatus){
        mReferenceResturants.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
              resturants.clear();
              List<String> keys = new ArrayList<>();
              for(DataSnapshot keyNode : datasnapshot.getChildren()){
                  keys.add (keyNode.getKey());
                  Resturant resturant = keyNode.getValue(Resturant.class);
                  resturants.add(resturant);
              }
              dataStatus.DataIsLoaded(resturants,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void addResturants(Resturant resturant, final DataStatus dataStatus){
        String key = mReferenceResturants.push().getKey();
        mReferenceResturants.child(key).setValue(resturant).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }

    public void UpdateResturants(String key, Resturant resturant, final DataStatus dataStatus){
        mReferenceResturants.child(key).setValue(resturant).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }
    public void DeleteResturants(String key,final DataStatus dataStatus){
        mReferenceResturants.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}
