package com.red.forteza.ui.activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.model.Text;
import com.red.forteza.util.Res;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextyActivity extends BaseActivity {

    @BindView(R.id.linearlayout_texty)
    LinearLayout textyLinearLayout;

    String title;
    ArrayList<Text> texts;
    ArrayList<Text> checks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackNavigation();
        ButterKnife.bind(this, setContent(R.layout.fragment_texty));

        Bundle extras = getIntent().getExtras();
        title = extras.getString("TITLE");
        texts = extras.getParcelableArrayList("TEXT");
        checks = extras.getParcelableArrayList("CHECKS");

        setTitle(title);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        textyLinearLayout.removeAllViews();

        // TODO: make one textview
        if(texts != null) {
            for (Text text : texts) {
                TextView textView = new TextView(this);
                textView.setLayoutParams(layoutParams);
                int dp = (int) Res.dp(12);
                textView.setPadding(dp, dp, dp, dp);
                textView.setText(Html.fromHtml(text.text));
                textyLinearLayout.addView(textView);
            }
        }

        if(checks != null) {
            for (Text text : checks) {
                TextView textView = new TextView(this);
                textView.setLayoutParams(layoutParams);
                int dp = (int) Res.dp(12);
                textView.setPadding(dp, dp, dp, dp);
                textView.setText(Html.fromHtml(text.text));
                textyLinearLayout.addView(textView);
            }
        }

    }
}
