package com.example.g56_e2hg_developers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private EmployeesAdapter mEmployeesAdapter;

    public void setConfig(RecyclerView recyclerView, Context context,List<Employee> employees, List<String> keys){
        mContext = context;
        mEmployeesAdapter = new EmployeesAdapter(employees,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mEmployeesAdapter);
    }

    class EmployeeItemView extends RecyclerView.ViewHolder {

        private TextView mId;
        private TextView mFname;
        private TextView mMob;
        private TextView mDesin;
        private TextView mGen;
        private TextView mEmptype;
        private TextView mAdd;
        private TextView mEdu;

        private String key;

        public EmployeeItemView(ViewGroup parent) {

            super(LayoutInflater.from(mContext).inflate(R.layout.employee_list_item, parent, false));


            mId = (TextView) itemView.findViewById(R.id.reg_textView);
            mFname = (TextView) itemView.findViewById(R.id.fname_textView);
            mMob = (TextView) itemView.findViewById(R.id.mob_textView);
            mDesin = (TextView) itemView.findViewById(R.id.desin_textView);
            mGen = (TextView) itemView.findViewById(R.id.gen_textView);
            mEmptype = (TextView) itemView.findViewById(R.id.emptype_textView);
            mAdd = (TextView) itemView.findViewById(R.id.add_textView);
            mEdu = (TextView) itemView.findViewById(R.id.edu_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,EmployeeDetailsActivity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("id",mId.getText().toString());
                    intent.putExtra("fname",mFname.getText().toString());
                    intent.putExtra("mob",mMob.getText().toString());
                    intent.putExtra("desin",mDesin.getText().toString());
                    intent.putExtra("gen",mGen.getText().toString());
                    intent.putExtra("type",mEmptype.getText().toString());
                    intent.putExtra("add",mAdd.getText().toString());
                    intent.putExtra("edu",mEdu.getText().toString());

                    mContext.startActivity(intent);

                }
            });

        }

        public void bind(Employee employee, String key) {

            mId.setText(employee.getId());
            mFname.setText(employee.getFname());
            mDesin.setText(employee.getDesin());
            mMob.setText(employee.getMob());
            mGen.setText(employee.getGen());
            mEmptype.setText(employee.getType());
            mAdd.setText(employee.getAdd());
            mEdu.setText(employee.getEdu());
            this.key = key;
        }
    }
    class EmployeesAdapter extends RecyclerView.Adapter<EmployeeItemView>{

            private List<Employee> mEmployeeList;
            private  List<String> mKeys;

            public EmployeesAdapter(List<Employee> mEmployeeList, List<String> mKeys) {
                this.mEmployeeList = mEmployeeList;
                this.mKeys = mKeys;
            }

            @NonNull
            @Override
            public EmployeeItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new EmployeeItemView(parent);
            }

            @Override
            public void onBindViewHolder(@NonNull EmployeeItemView holder, int position) {
               holder.bind(mEmployeeList.get(position),mKeys.get(position));

            }

            @Override
            public int getItemCount() {
                return mEmployeeList.size();
            }
        }
    }