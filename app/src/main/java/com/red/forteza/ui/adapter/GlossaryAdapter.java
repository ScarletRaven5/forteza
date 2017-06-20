package com.red.forteza.ui.adapter;

import android.media.MediaPlayer;
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

import com.red.forteza.App;
import com.red.forteza.R;
import com.red.forteza.data.model.Term;
import com.red.forteza.util.Res;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlossaryAdapter extends RecyclerView.Adapter<GlossaryAdapter.TermViewHolder> {

    private ArrayList<Term> mTerms = new ArrayList<>();
    private MediaPlayer mAudioPlayer;

    public GlossaryAdapter(ArrayList<Term> terms) {
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

            if (mTerm.isExpanded) {
                moreInfoArrow.setRotation(180);
                detailsLayout.setVisibility(View.VISIBLE);
            } else {
                moreInfoArrow.setRotation(0);
                detailsLayout.setVisibility(View.GONE);
            }
            if (!mTerm.plural.isEmpty()) {
                pluralLayout.setVisibility(View.VISIBLE);
                plural.setText(mTerm.plural);
            } else {
                pluralLayout.setVisibility(View.GONE);
            }
            if (!mTerm.noun.isEmpty()) {
                nounLayout.setVisibility(View.VISIBLE);
                noun.setText(mTerm.noun);
            } else {
                nounLayout.setVisibility(View.GONE);
            }
            if (!mTerm.modernItalian.isEmpty()) {
                modernItalianLayout.setVisibility(View.VISIBLE);
                modernItalian.setText(mTerm.modernItalian);
            } else {
                modernItalianLayout.setVisibility(View.GONE);
            }
        }

        @OnClick(R.id.button_audio)
        protected void clickAudio() {
            int id = Res.identifyRaw(itemView.getContext(), mTerm.audio);
            if(mAudioPlayer != null) {
                mAudioPlayer.reset();
                mAudioPlayer.release();
            }
            mAudioPlayer = MediaPlayer.create(App.get(), id);
            mAudioPlayer.start();
        }

        @OnClick(R.id.item_term)
        protected void onClick() {
            mTerm.isExpanded = !mTerm.isExpanded;
            moreInfoArrow.animate().rotation(mTerm.isExpanded ? 180 : 0).start();

            if (!mTerm.isExpanded) {
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
