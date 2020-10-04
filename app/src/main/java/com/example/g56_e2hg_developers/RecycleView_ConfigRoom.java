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

import java.io.ByteArrayOutputStream;
import java.util.List;

public class RecycleView_ConfigRoom {
    private Context rContext;
    private RoomsAdapter rRoomsAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, final List<Room> rooms, List<String> keys) {
        rContext = context;
        rRoomsAdapter = new RoomsAdapter(rooms, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(rRoomsAdapter);
    }

        class RoomItemView extends RecyclerView.ViewHolder {
            private TextView rname;
            private TextView remail;
            private TextView rtype;
            private TextView rguests;
            private TextView adate;
            private TextView ddate;

            private String key;

            public RoomItemView(ViewGroup parent) {
                super(LayoutInflater.from(rContext).inflate(R.layout.room_list_item, parent, false));

                rname = (TextView) itemView.findViewById(R.id.textView111);
                remail = (TextView) itemView.findViewById(R.id.textView222);
                rtype = (TextView) itemView.findViewById(R.id.textView333);
                rguests = (TextView) itemView.findViewById(R.id.textView444);
                adate = (TextView) itemView.findViewById(R.id.textview555);
                ddate = (TextView) itemView.findViewById(R.id.textView666);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(rContext, RoomDetailsActivity.class);
                        intent.putExtra("key", key);
                        intent.putExtra("rname", rname.getText().toString());
                        intent.putExtra("remail", remail.getText().toString());
                        intent.putExtra("rtype", rtype.getText().toString());
                        intent.putExtra("rguests", rguests.getText().toString());
                        intent.putExtra("adate", adate.getText().toString());
                        intent.putExtra("ddate", ddate.getText().toString());

                        rContext.startActivity(intent);
                    }
                });
            }

            public void bind(Room room, String key) {

                rname.setText(room.getRname());
                remail.setText(room.getRemail());
                rtype.setText(room.getRtype());
                rguests.setText(room.getRguests());
                adate.setText(room.getAdate());
                ddate.setText(room.getDdate());
                this.key = key;

            }
        }

        class RoomsAdapter extends RecyclerView.Adapter<RoomItemView> {

            private List<Room> rRoomsList;
            private List<String> rKeys;

            public RoomsAdapter(List<Room> rRoomList, List<String> rKeys) {
                this.rRoomsList = rRoomList;
                this.rKeys = rKeys;
            }

            @NonNull
            @Override
            public RoomItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new RoomItemView(parent);
            }

            @Override
            public void onBindViewHolder(@NonNull RoomItemView holder, int position) {
                holder.bind(rRoomsList.get(position), rKeys.get(position));
            }

            @Override
            public int getItemCount() {
                return rRoomsList.size();
            }
        }
    }