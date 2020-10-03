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

public class RecyclerView_Config_Attendance {

    private Context mContext;
    private AttendanceAdapter mAttenAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Attendance> attendances, List<String> keys){
        mContext = context;
        mAttenAdapter = new AttendanceAdapter(attendances,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mAttenAdapter);
    }

    class AttendanceItemView extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView date;
        private TextView atype;


        private String key;

        public AttendanceItemView(ViewGroup parent) {

            super(LayoutInflater.from(mContext).inflate(R.layout.attandan_list_item, parent, false));


            name = (TextView) itemView.findViewById(R.id.aname_txtview);
            date = (TextView) itemView.findViewById(R.id.adate_txtview);
            atype = (TextView) itemView.findViewById(R.id.atype_txtview);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,EmployeeDetailsActivity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("name",name.getText().toString());
                    intent.putExtra("date",date.getText().toString());
                    intent.putExtra("status",atype.getText().toString());

                    mContext.startActivity(intent);

                }
            });

        }

        public void bind(Attendance attendance, String key) {

            name.setText(attendance.getAtime());
            date.setText(attendance.getAdate());
            atype.setText(attendance.getAtype());
            this.key = key;
        }
    }
    class AttendanceAdapter extends RecyclerView.Adapter<AttendanceItemView>{

        private List<Attendance> mAttendanceList;
        private  List<String> mKeys;

        public AttendanceAdapter(List<Attendance> mAttendanceList, List<String> mKeys) {
            this.mAttendanceList = mAttendanceList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public AttendanceItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AttendanceItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull AttendanceItemView holder, int position) {
            holder.bind(mAttendanceList.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mAttendanceList.size();
        }
    }
}