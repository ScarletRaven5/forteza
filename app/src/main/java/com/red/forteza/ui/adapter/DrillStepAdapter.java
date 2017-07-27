package com.red.forteza.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.red.forteza.R;
import com.red.forteza.data.model.Step;
import com.red.forteza.util.Res;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrillStepAdapter extends RecyclerView.Adapter<DrillStepAdapter.StepViewHolder> {

    private ArrayList<Step> mSteps = new ArrayList<>();

    public DrillStepAdapter(ArrayList<Step> steps) {
        mSteps = steps;
    }

    @Override
    public StepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StepViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drill_step, parent, false));
    }

    @Override
    public void onBindViewHolder(StepViewHolder holder, int position) {
        holder.bind(mSteps.get(position));
    }


    @Override
    public int getItemCount() {
        return mSteps.size();
    }

    public class StepViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_step)
        TextView stepText;
        @BindView(R.id.gif_step_front)
        ImageView stepGifFront;
        @BindView(R.id.gif_step_side)
        ImageView stepGifSide;

        private Step mStep;

        public StepViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Step step) {
            mStep = step;
            stepText.setText(Html.fromHtml(step.text));
            Glide.with(itemView.getContext()).load(Res.drawableId(itemView.getContext(), mStep.frontGif)).asGif().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).crossFade().into(stepGifFront);
            Glide.with(itemView.getContext()).load(Res.drawableId(itemView.getContext(), mStep.sideGif)).asGif().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).crossFade().into(stepGifSide);
        }
    }
}
