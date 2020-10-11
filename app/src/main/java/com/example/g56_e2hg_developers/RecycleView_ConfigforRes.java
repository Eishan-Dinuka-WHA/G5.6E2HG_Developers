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

public class RecycleView_ConfigforRes {
    private Context mContext;
    private Resadapter mResadapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Resturant> resturants, List<String> keys){
        mContext = context;
        mResadapter = new Resadapter(resturants,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mResadapter);
    }

    class ResItemView extends RecyclerView.ViewHolder {

        private TextView resmeal;
        private TextView ressize;
        private TextView resqty;
        private TextView resname;
        private TextView resnumber;
        private TextView resemail;
        private TextView reshouse;
        private TextView resstreet;
        private TextView rescity;
        private TextView restime;
        private TextView total;


        private String key;

        public ResItemView(ViewGroup parent) {

            super(LayoutInflater.from(mContext).inflate(R.layout.resturant_list_item, parent, false));


            resmeal = (TextView) itemView.findViewById(R.id.textView_meal);
            ressize = (TextView) itemView.findViewById(R.id.textView_size);
            resqty = (TextView) itemView.findViewById(R.id.textView_qty);
            resname = (TextView) itemView.findViewById(R.id.textView_name);
            resnumber = (TextView) itemView.findViewById(R.id.textView_number);
            resemail = (TextView) itemView.findViewById(R.id.textView_email);
            reshouse = (TextView) itemView.findViewById(R.id.textViewhno);
            resstreet = (TextView) itemView.findViewById(R.id.textViewsrtret);
            rescity = (TextView) itemView.findViewById(R.id.textView_city);
            restime = (TextView) itemView.findViewById(R.id.textView_time);
            total = (TextView) itemView.findViewById(R.id.textView_total);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,ResDetailsActvitity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("meal",resmeal.getText().toString());
                    intent.putExtra("size",ressize.getText().toString());
                    intent.putExtra("qty",resqty.getText().toString());
                    intent.putExtra("name",resname.getText().toString());
                    intent.putExtra("number",resnumber.getText().toString());
                    intent.putExtra("email",resemail.getText().toString());
                    intent.putExtra("hno",reshouse.getText().toString());
                    intent.putExtra("srtret",resstreet.getText().toString());
                    intent.putExtra("city",rescity.getText().toString());
                    intent.putExtra("time",restime.getText().toString());
                    intent.putExtra("total",total.getText().toString());

                    mContext.startActivity(intent);

                }
            });

        }

        public void bind(Resturant resturant, String key) {

            resmeal.setText(resturant.getMeal());
            ressize.setText(resturant.getSize());
            resqty.setText(resturant.getQuantity());
            resname.setText(resturant.getCus_name());
            resnumber.setText(resturant.getCon_no());
            resemail.setText(resturant.getEmail());
            reshouse.setText(resturant.getHouse_no());
            resstreet.setText(resturant.getStreet());
            rescity.setText(resturant.getCity());
            restime.setText(resturant.getTime());
            total.setText(String.valueOf(resturant.getTotal()));
            this.key = key;
        }
    }
    class Resadapter extends  RecyclerView.Adapter<ResItemView>{

        private List<Resturant> mResList;
        private  List<String> mKeys;

        public Resadapter(List<Resturant> mResList, List<String> mKeys) {
            this.mResList = mResList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public ResItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ResItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ResItemView holder, int position) {
            holder.bind(mResList.get(position),mKeys.get(position));

        }

        @Override
        public int getItemCount() {
            return mResList.size();
        }
    }
}
