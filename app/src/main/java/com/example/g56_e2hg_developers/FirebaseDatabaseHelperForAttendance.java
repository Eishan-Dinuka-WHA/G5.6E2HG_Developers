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

public class FirebaseDatabaseHelperForAttendance {
    private FirebaseDatabase ADatabase;
    private DatabaseReference mReferenceAttendance;
    private List<Attendance> Attendances = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Attendance> attendances, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelperForAttendance() {
        ADatabase = FirebaseDatabase.getInstance();
        mReferenceAttendance = ADatabase.getReference("attendance");
    }
    public void readAtten(final FirebaseDatabaseHelperForAttendance.DataStatus dataStatus){
        mReferenceAttendance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Attendances.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Attendance attendance = keyNode.getValue(Attendance.class);
                    Attendances.add(attendance);
                }
                dataStatus.DataIsLoaded(Attendances,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void addAtten(Attendance attendance, final FirebaseDatabaseHelperForAttendance.DataStatus dataStatus){
        String key = mReferenceAttendance.push().getKey();
        mReferenceAttendance.child(key).setValue(attendance).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }
}
