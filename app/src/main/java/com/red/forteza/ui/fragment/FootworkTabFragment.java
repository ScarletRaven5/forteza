package com.red.forteza.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.model.Basic;
import com.red.forteza.ui.activity.TextyActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FootworkTabFragment extends TabFragment {

    @BindView(R.id.paragraph1)
    TextView paragraph1;
    @BindView(R.id.paragraph2)
    TextView paragraph2;
    @BindView(R.id.paragraph3)
    TextView paragraph3;
    @BindView(R.id.paragraph4)
    TextView paragraph4;
    @BindView(R.id.checkpoint1)
    TextView checkpoint1;
    @BindView(R.id.checkpoint2)
    TextView checkpoint2;
    @BindView(R.id.checkpoint3)
    TextView checkpoint3;
    @BindView(R.id.checkpoint4)
    TextView checkpoint4;
    @BindView(R.id.label_acressimento)
    TextView acressimentoLabel;
    @BindView(R.id.label_passamento)
    TextView passamentoLabel;
    @BindView(R.id.label_volta)
    TextView voltaLabel;

    ArrayList<Basic> mFootworks;
    Basic mFootwork;
    Basic mAcressimento;
    Basic mPassamento;
    Basic mVolta;

    public static FootworkTabFragment newInstance(ArrayList<Basic> footworks) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Basic.ARG, footworks);
        FootworkTabFragment fragment = new FootworkTabFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_tab_footwork;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mFootworks = getArguments().getParcelableArrayList(Basic.ARG);
        mFootwork = mFootworks.get(0);
        mAcressimento = mFootworks.get(1);
        mPassamento = mFootworks.get(2);
        mVolta = mFootworks.get(3);

        paragraph1.setText(Html.fromHtml(mFootwork.paragraphs.get(0).text));
        paragraph2.setText(Html.fromHtml(mFootwork.paragraphs.get(1).text));
        paragraph3.setText(Html.fromHtml(mFootwork.paragraphs.get(2).text));
        paragraph4.setText(Html.fromHtml(mFootwork.paragraphs.get(3).text));
        checkpoint1.setText(Html.fromHtml(mFootwork.checkpoints.get(0).text));
        checkpoint2.setText(Html.fromHtml(mFootwork.checkpoints.get(1).text));
        checkpoint3.setText(Html.fromHtml(mFootwork.checkpoints.get(2).text));
        checkpoint4.setText(Html.fromHtml(mFootwork.checkpoints.get(3).text));

        acressimentoLabel.setText(mAcressimento.title);
        passamentoLabel.setText(mPassamento.title);
        voltaLabel.setText(mVolta.title);
    }

    @OnClick(R.id.button_acressimento)
    protected void clickAcressimento() {
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", mAcressimento.title);
        bundle.putParcelableArrayList("TEXT", mAcressimento.paragraphs);
        startActivity(TextyActivity.class, bundle, false);
    }

    @OnClick(R.id.button_passamento)
    protected void clickPassamento() {
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", mPassamento.title);
        bundle.putParcelableArrayList("TEXT", mPassamento.paragraphs);
        startActivity(TextyActivity.class, bundle, false);
    }

    @OnClick(R.id.button_volta)
    protected void clickVolta() {
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", mVolta.title);
        bundle.putParcelableArrayList("TEXT", mVolta.paragraphs);
        bundle.putParcelableArrayList("CHECKS", mVolta.checkpoints);
        startActivity(TextyActivity.class, bundle, false);
    }
}
