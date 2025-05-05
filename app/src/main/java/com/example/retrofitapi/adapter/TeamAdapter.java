package com.example.retrofitapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitapi.R;
import com.example.retrofitapi.model.Team;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private final List<Team> teamList;

    public TeamAdapter(List<Team> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.teamName.setText(team.getStrTeam());
        holder.teamDescription.setText(team.getStrDescriptionEN());
        holder.teamKeywords.setText(formatKeywords(team.getStrKeywords()));
        Glide.with(holder.itemView.getContext())
                .load(team.getStrTeamBadge())
                .placeholder(R.drawable.placeholder)  // Gambar default jika loading
                .error(R.drawable.error_image)        // Gambar jika error
                .into(holder.teamBadge);
    }
    public void updateData(List<Team> newTeams) {
        teamList.clear();
        teamList.addAll(newTeams);
        notifyDataSetChanged();
    }

    private String formatKeywords(String keywords) {
        return keywords != null ? "Keywords: " + keywords.replace(",", ", ") : "";
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamName, teamDescription, teamKeywords;
        ImageView teamBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.tv_team_name);
            teamDescription = itemView.findViewById(R.id.tv_description);
            teamKeywords = itemView.findViewById(R.id.tv_keywords);
            teamBadge = itemView.findViewById(R.id.img_team_badge);
        }
    }
}