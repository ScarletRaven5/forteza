package com.red.forteza.ui.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.red.forteza.R;
import com.red.forteza.data.model.Guard;
import com.red.forteza.ui.activity.GuardDetailsActivity;
import com.red.forteza.util.Res;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuardsAdapter extends RecyclerView.Adapter<GuardsAdapter.GuardViewHolder> {

    private ArrayList<Guard> mGuards = new ArrayList<>();

    public GuardsAdapter(ArrayList<Guard> guards) {
        mGuards = guards;
    }

    @Override
    public GuardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GuardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guard, parent, false));
    }

    @Override
    public void onBindViewHolder(GuardViewHolder holder, int position) {
        holder.bind(position);
    }


    @Override
    public int getItemCount() {
        return mGuards.size();
    }

    public class GuardViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_guard)
        ImageView guardImage;
        @BindView(R.id.title_guard_italian)
        TextView italianGuardName;
        @BindView(R.id.title_guard_english)
        TextView englishGuardName;

        Guard mGuard;

        public GuardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(int position) {
            mGuard = mGuards.get(position);
            Glide.with(itemView.getContext()).load(Res.drawableId(itemView.getContext(), mGuard.fioreImage)).into(guardImage);
            italianGuardName.setText(mGuard.italianName);
            englishGuardName.setText(mGuard.englishName);
        }

        @OnClick(R.id.item_guard)
        protected void onClick() {
            Bundle extras = new Bundle();
            extras.putParcelable(Guard.ARG, mGuard);
            Intent intent = new Intent(itemView.getContext(), GuardDetailsActivity.class);
            intent.putExtras(extras);

            itemView.getContext().startActivity(intent, extras);
        }
    }
}
