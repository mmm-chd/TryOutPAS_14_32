package com.intent.tryoutpas_14_32;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RvPremiereAdapter extends RecyclerView.Adapter<RvPremiereAdapter.ViewHolder> {

    List<ModelClass> teamList;

    public RvPremiereAdapter(PremiereFragment premiereList, List<ModelClass> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass team = teamList.get(position);
        holder.tvTeam.setText(team.getStrTeam());
        holder.tvStadium.setText(team.getStrStadium());

        Glide.with(holder.itemView.getContext())
                .load(team.getStrBadge())
                .into(holder.ivBadge);

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTeam, tvStadium;
        ImageView ivBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTeam = itemView.findViewById(R.id.tvTeam);
            tvStadium = itemView.findViewById(R.id.tvStadium);
            ivBadge = itemView.findViewById(R.id.ivBadge);

        }
    }
}
