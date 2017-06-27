package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.model.TandD;
import com.red.forteza.data.model.TandDs;
import com.red.forteza.data.model.Text;
import com.red.forteza.ui.view.TandDTermView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TandDTabFragment extends TabFragment {

    @BindView(R.id.text_intro)
    TextView intro;
    @BindView(R.id.text_paragraphs)
    TextView paragraphs;
    @BindView(R.id.layout_terms)
    LinearLayout termsLayout;

    TandDs mTandD;

    public static TandDTabFragment newInstance(TandDs info) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TandDs.ARG, info);
        TandDTabFragment fragment = new TandDTabFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_tab_t_and_d;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mTandD = getArguments().getParcelable(TandDs.ARG);

        intro.setText(Html.fromHtml(mTandD.intro));
        String paragraphText = "";
        for (Text t : mTandD.paragraphs) {
            paragraphText = paragraphText.concat(t.text + "<br/><br/>");
        }

        for(TandD term : mTandD.terms) {
            TandDTermView termView = new TandDTermView(getContext());
            termView.setTermInfo(term.term, term.meaning, term.image);
            termsLayout.addView(termView);
        }
        paragraphs.setText(Html.fromHtml(paragraphText));
    }
}
