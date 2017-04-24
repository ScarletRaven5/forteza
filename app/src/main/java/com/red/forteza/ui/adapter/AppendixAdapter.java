package com.red.forteza.ui.adapter;

import android.support.transition.TransitionManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.model.Term;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppendixAdapter extends RecyclerView.Adapter<AppendixAdapter.TermViewHolder> {

    private ArrayList<Term> mTerms = new ArrayList<>();

    public AppendixAdapter(ArrayList<Term> terms) {
        mTerms = terms;
    }

    @Override
    public TermViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TermViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_term, parent, false));
    }

    @Override
    public void onBindViewHolder(TermViewHolder holder, int position) {
        holder.bind(mTerms.get(position));
    }


    @Override
    public int getItemCount() {
        return mTerms.size();
    }

    public class TermViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.arrow_more_info)
        ImageView moreInfoArrow;
        @BindView(R.id.title_term)
        TextView term;
        @BindView(R.id.term_pronunciation)
        TextView pronunciation;
        @BindView(R.id.term_translation)
        TextView translation;
        @BindView(R.id.term_definition)
        TextView definition;
        @BindView(R.id.term_plural)
        TextView plural;
        @BindView(R.id.term_noun)
        TextView noun;
        @BindView(R.id.term_modern_italian)
        TextView modernItalian;

        @BindView(R.id.item_term)
        CardView termCard;
        @BindView(R.id.layout_details)
        LinearLayout detailsLayout;
        @BindView(R.id.layout_plural)
        LinearLayout pluralLayout;
        @BindView(R.id.layout_noun)
        LinearLayout nounLayout;
        @BindView(R.id.layout_modern_italian)
        LinearLayout modernItalianLayout;

        private Term mTerm;

        public TermViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Term termItem) {
            mTerm = termItem;
            term.setText(mTerm.term);
            pronunciation.setText(mTerm.pronunciation);
            translation.setText(Html.fromHtml(mTerm.translation));
            definition.setText(Html.fromHtml(mTerm.definition));

            if(mTerm.isExpanded) {
                moreInfoArrow.setRotation(180);
                detailsLayout.setVisibility(View.VISIBLE);
            } else {
                moreInfoArrow.setRotation(0);
                detailsLayout.setVisibility(View.GONE);
            }
            if(!mTerm.plural.isEmpty()) {
                pluralLayout.setVisibility(View.VISIBLE);
                plural.setText(mTerm.plural);
            } else {
                pluralLayout.setVisibility(View.GONE);
            }
            if(!mTerm.noun.isEmpty()) {
                nounLayout.setVisibility(View.VISIBLE);
                noun.setText(mTerm.noun);
            } else {
                nounLayout.setVisibility(View.GONE);
            }
            if(!mTerm.modernItalian.isEmpty()) {
                modernItalianLayout.setVisibility(View.VISIBLE);
                modernItalian.setText(mTerm.modernItalian);
            } else {
                modernItalianLayout.setVisibility(View.GONE);
            }
        }

        @OnClick(R.id.item_term)
        protected void onClick() {
            if (!mTerm.isExpanded) {
                moreInfoArrow.animate().rotation(180).start();
                TransitionManager.beginDelayedTransition(termCard);
                detailsLayout.setVisibility(View.VISIBLE);
            } else {
                moreInfoArrow.animate().rotation(0).start();
                TransitionManager.beginDelayedTransition(termCard);
                detailsLayout.setVisibility(View.GONE);
            }
            mTerm.isExpanded = !mTerm.isExpanded;
        }
    }
}
