package com.red.forteza.ui.adapter;

import android.os.CountDownTimer;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.model.Component;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ComponentViewHolder> {

    private ArrayList<Component> mComponents = new ArrayList<>();

    public ComponentAdapter(ArrayList<Component> components) {
        mComponents = components;
    }

    @Override
    public ComponentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ComponentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component, parent, false));
    }

    @Override
    public void onBindViewHolder(ComponentViewHolder holder, int position) {
        holder.bind(mComponents.get(position));
    }


    @Override
    public int getItemCount() {
        return mComponents.size();
    }

    public class ComponentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.arrow_more_info)
        ImageView moreInfoArrow;
        @BindView(R.id.title_component)
        TextView component;
        @BindView(R.id.italian_component)
        TextView componentItalian;
        @BindView(R.id.component_definition)
        TextView definition;

        @BindView(R.id.item_component)
        CardView componentCard;
        @BindView(R.id.layout_details)
        LinearLayout detailsLayout;

        private Component mComponent;

        public ComponentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Component componentItem) {
            mComponent = componentItem;
            component.setText(mComponent.term);
            definition.setText(Html.fromHtml(mComponent.meaning));

            if (mComponent.italian != null) {
                componentItalian.setVisibility(View.VISIBLE);
                componentItalian.setText(mComponent.italian);
            }

            if (mComponent.isExpanded) {
                moreInfoArrow.setRotation(180);
                detailsLayout.setVisibility(View.VISIBLE);
            } else {
                moreInfoArrow.setRotation(0);
                detailsLayout.setVisibility(View.GONE);
            }
        }

        @OnClick(R.id.item_component)
        protected void onClick() {
            mComponent.isExpanded = !mComponent.isExpanded;
            moreInfoArrow.animate().rotation(mComponent.isExpanded ? 180 : 0).start();

            if (!mComponent.isExpanded) {
                detailsLayout.startAnimation(AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade_out));
                CountDownTimer countDownTimerStatic = new CountDownTimer(500, 16) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        detailsLayout.setVisibility(View.GONE);
                    }
                };
                countDownTimerStatic.start();
            } else {
                detailsLayout.setVisibility(View.VISIBLE);
                detailsLayout.startAnimation(AnimationUtils.loadAnimation(itemView.getContext(), R.anim.fade_in));
            }
        }
    }
}
