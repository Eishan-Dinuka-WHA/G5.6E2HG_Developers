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

public class FirebaseDatabaseHelperForEmployee {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceEmployee;
    private List<Employee> Employees = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Employee> employees, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelperForEmployee() {
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceEmployee = mDatabase.getReference("Employee");
    }
    public void readEmployee(final DataStatus dataStatus){
        mReferenceEmployee.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Employees.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Employee employee = keyNode.getValue(Employee.class);
                    Employees.add(employee);
                }
                dataStatus.DataIsLoaded(Employees,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void addEmployee(Employee employee, final DataStatus dataStatus){
        String key = mReferenceEmployee.push().getKey();
        mReferenceEmployee.child(key).setValue(employee).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }

    public void UpdateEmployee(String key, Employee employee, final DataStatus dataStatus){
        mReferenceEmployee.child(key).setValue(employee).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }
    public void DeleteEmployee(String key,final DataStatus dataStatus){
        mReferenceEmployee.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}
