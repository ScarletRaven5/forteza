package com.red.forteza.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.red.forteza.R;
import com.red.forteza.data.model.Drill;
import com.red.forteza.data.model.Text;
import com.red.forteza.ui.adapter.DrillStepAdapter;
import com.red.forteza.ui.view.FToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrillActivity extends BaseActivity {

    @BindView(R.id.recycler_steps)
    RecyclerView stepsRecycler;

    Drill mDrill;
    DrillStepAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackNavigation();
        ButterKnife.bind(this, setContent(R.layout.activity_drill));

        Bundle extras = getIntent().getExtras();
        mDrill = extras.getParcelable(Drill.ARG);

        setTitle("Drills");
        setActions(new FToolbar.Action("INTRO") {
            @Override
            public void onClick(View v) {
                String intro = "";
                for (Text t : mDrill.paragraphs) {
                    intro = intro.concat(t.text + "<br/><br/>");
                }
                Bundle extra = new Bundle();
                extra.putString("title", mDrill.title);
                extra.putString("text", intro);
                startActivity(IntroductionActivity.class, extra, false);
            }
        });;


        mAdapter = new DrillStepAdapter(mDrill.steps);
        stepsRecycler.setLayoutManager(new LinearLayoutManager(this));
        stepsRecycler.setAdapter(mAdapter);
    }
}
