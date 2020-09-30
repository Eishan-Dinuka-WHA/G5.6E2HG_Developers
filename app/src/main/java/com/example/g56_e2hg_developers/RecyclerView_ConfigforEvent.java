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

public class RecyclerView_ConfigforEvent {
    private Context eContext;
    private EventsAdapter eEventAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<Event> events, List<String> keys){
        eContext = context;
        eEventAdapter = new EventsAdapter(events,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(eEventAdapter);
    }

    class EventItemView extends RecyclerView.ViewHolder {

        private TextView eEtype;
        private TextView eName;
        private TextView eEmail;
        private TextView eEname;
        private TextView enog;
        private TextView eDate;
        private TextView eHtype;
        private TextView eNop;
        private TextView eHprice;

        private String key;

        public EventItemView(ViewGroup parent) {

            super(LayoutInflater.from(eContext).inflate(R.layout.event_list_item, parent, false));


            eEtype = (TextView) itemView.findViewById(R.id.etype_textView);
            eName = (TextView) itemView.findViewById(R.id.name_textView);
            eEmail = (TextView) itemView.findViewById(R.id.email_textView);
            eEname = (TextView) itemView.findViewById(R.id.ename_textView);
            enog = (TextView) itemView.findViewById(R.id.nog_textView);
            eDate = (TextView) itemView.findViewById(R.id.date_textView);
            eHtype = (TextView) itemView.findViewById(R.id.htype_textView);
            eNop = (TextView) itemView.findViewById(R.id.nop_textView);
            eHprice = (TextView) itemView.findViewById(R.id.hprice_textView);

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(eContext,EventDetailsActivity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("etype",eEtype.getText().toString());
                    intent.putExtra("name",eName.getText().toString());
                    intent.putExtra("email",eEmail.getText().toString());
                    intent.putExtra("ename",eEname.getText().toString());
                    intent.putExtra("nog",enog.getText().toString());
                    intent.putExtra("date",eDate.getText().toString());
                    intent.putExtra("htype",eHtype.getText().toString());
                    intent.putExtra("nop",eNop.getText().toString());
                    intent.putExtra("hprice",eHprice.getText().toString());

                    eContext.startActivity(intent);

                }
            });

        }

        public void bind(Event event, String key) {

            eEtype.setText(event.getEtype());
            eName.setText(event.getName());
            eEmail.setText(event.getEmail());
            eEname.setText(event.getEname());
            enog.setText(event.getNog());
            eDate.setText(event.getDate());
            eHtype.setText(event.getHtype());
            eNop.setText(event.getNop());
            eHprice.setText(event.getHprice());
            this.key = key;
        }
    }
    class EventsAdapter extends RecyclerView.Adapter <EventItemView>{

        private List<Event> eEventList;
        private  List<String> eKeys;

        public EventsAdapter(List<Event> eEventList, List<String> eKeys) {
            this.eEventList = eEventList;
            this.eKeys = eKeys;
        }

        @NonNull
        @Override
        public EventItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EventItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull EventItemView holder, int position) {
            holder.bind(eEventList.get(position), eKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return eEventList.size();
        }
    }
}