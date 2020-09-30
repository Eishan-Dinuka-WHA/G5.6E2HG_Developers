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

public class RecyclerView_Config_Salary {

    private Context sContext;
    private  salaryAdapter sSalaryAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Salary> salaries, List<String> keys){
        sContext = context;
        sSalaryAdapter = new salaryAdapter (salaries,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(sSalaryAdapter);
    }

    class SalaryItemView extends RecyclerView.ViewHolder {

        private TextView eeName;
        private TextView eebasic;
        private TextView eeover;
        private TextView eeallown;
        private TextView eebonous;
        private TextView eefestival;
        private TextView eestamp;
        private TextView eeepf;
        private String key;

        public SalaryItemView(ViewGroup parent) {

            super(LayoutInflater.from(sContext).inflate(R.layout.salary_list_item, parent, false));


            eeName = (TextView) itemView.findViewById(R.id.ename_textView);
            eebasic = (TextView) itemView.findViewById(R.id.basic_textView);
            eeover = (TextView) itemView.findViewById(R.id.over_textView);
            eeallown = (TextView) itemView.findViewById(R.id.allown_textView);
            eebonous = (TextView) itemView.findViewById(R.id.Bonous_textView);
            eefestival = (TextView) itemView.findViewById(R.id.festival_textView);
            eestamp = (TextView) itemView.findViewById(R.id.stamp_textView);
            eeepf = (TextView) itemView.findViewById(R.id.epf_textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(sContext,SalaryDetailsActivity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("ename;",eeName.getText().toString());
                    intent.putExtra("bas",eebasic.getText().toString());
                    intent.putExtra("over",eeover.getText().toString());
                    intent.putExtra("allow",eeallown.getText().toString());
                    intent.putExtra("bonus",eebonous.getText().toString());
                    intent.putExtra("fest",eefestival.getText().toString());
                    intent.putExtra("stamp",eestamp.getText().toString());
                    intent.putExtra("epf",eeepf.getText().toString());

                    sContext.startActivity(intent);

                }
            });

        }

        public void bind(Salary salary, String key) {

            eeName.setText(salary.getEname());
            eebasic.setText(salary.getBas());
            eeover.setText(salary.getOver());
            eeallown.setText(salary.getAllow());
            eebonous.setText(salary.getBonus());
            eefestival.setText(salary.getFest());
            eestamp.setText(salary.getStamp());
            eeepf.setText(salary.getEpf());
            this.key = key;
        }
    }
    class salaryAdapter extends RecyclerView.Adapter <SalaryItemView>{

        private List<Salary> ssalaryList;
        private  List<String> eKeys;

        public salaryAdapter(List<Salary> ssalaryList, List<String> eKeys) {
            this.ssalaryList = ssalaryList;
            this.eKeys = eKeys;
        }

        @NonNull
        @Override
        public SalaryItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SalaryItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SalaryItemView holder, int position) {
            holder.bind(ssalaryList.get(position), eKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return ssalaryList.size();
        }
    }
}