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

public class FirebaseDatabaseHelperForSalary {

    private FirebaseDatabase sDatabase;
    private DatabaseReference sReferenceEvent;
    private List<Salary> salaries = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Salary> salars, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelperForSalary() {
        sDatabase = FirebaseDatabase.getInstance();
        sReferenceEvent = sDatabase.getReference("salary");
    }

    public void readSalary(final DataStatus dataStatus){
        sReferenceEvent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                salaries.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Salary salary = keyNode.getValue(Salary.class);
                    salaries.add(salary);
                }
                dataStatus.DataIsLoaded(salaries,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void addSalary(Salary salary, final DataStatus dataStatus){
        String key = sReferenceEvent.push().getKey();
        sReferenceEvent.child(key).setValue(salary).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }

    public void UpdateSalary(String key, Salary salary, final DataStatus dataStatus){
        sReferenceEvent.child(key).setValue(salary).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }
    public void DeleteSalary(String key,final DataStatus dataStatus){
        sReferenceEvent.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}