package com.sssoyalan.ogoochallenge.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sssoyalan.ogoochallenge.R;
import com.sssoyalan.ogoochallenge.models.BadgeModel;
import com.sssoyalan.ogoochallenge.models.Value;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {
    private final LayoutInflater mInflater;
    private final Context context;
    private final List<List<Value>> mData;
    private List<BadgeModel> badgesList;
    private RcyBadgeAdapter rcyBadgeAdapter;

    public ViewPagerAdapter(Context context, List<List<Value>> mData, List<BadgeModel> badgesList, RcyBadgeAdapter rcyBadgeAdapter) {
        this.context=context;
        this.mData = mData;
        this.badgesList = badgesList;
        this.mInflater = LayoutInflater.from(context);
        this.rcyBadgeAdapter = rcyBadgeAdapter;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_viewpager2, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        holder.recyclerView.setAdapter(new RcyBadgeAdapter(mData.get(position),badgesList,context));
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerView2);
            recyclerView.setAdapter(rcyBadgeAdapter);
            recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        }
    }
}
