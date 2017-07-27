package com.red.forteza.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.util.Res;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoadingView extends FrameLayout {


    private static Paint sPaint;

    static {
        sPaint = new Paint();
        sPaint.setColor(Res.color(R.color.colorAccent));
        sPaint.setStyle(Paint.Style.FILL);
        sPaint.setShadowLayer(Res.dp(3), Res.dp(3), Res.dp(3), Res.color(R.color.colorPrimary));
        sPaint.setAntiAlias(true);
    }

    @BindView(R.id.popup_box)
    View popup;
    @BindView(R.id.text)
    TextView text;

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_loading, this, true);
        ButterKnife.bind(this, this);

        setLayerType(LAYER_TYPE_SOFTWARE, sPaint);
    }

    public void setText(String str) {
        text.setText(str);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawRect(popup.getLeft(), popup.getTop(), popup.getRight(), popup.getBottom(), sPaint);
        super.dispatchDraw(canvas);
    }
}
