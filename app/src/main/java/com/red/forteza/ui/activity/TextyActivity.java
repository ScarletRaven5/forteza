package com.red.forteza.ui.activity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.data.model.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextyActivity extends BaseActivity {

    @BindView(R.id.texty_paragraphs)
    TextView paragraphs;
    @BindView(R.id.texty_checks)
    TextView points;

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

        if (texts != null) {
            String paragraphText = "";
            for (Text t : texts) {
                paragraphText = paragraphText.concat(t.text + "<br/><br/>");
            }
            paragraphs.setText(Html.fromHtml(paragraphText));
        }

        if (checks != null) {
            String checkText = "";
            for (Text t : checks) {
                checkText = checkText.concat(t.text + "<br/><br/>");
            }
            points.setText(Html.fromHtml(checkText));
        }

    }
}
