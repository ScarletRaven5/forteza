package com.red.forteza.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.red.forteza.R;
import com.red.forteza.util.Res;

public class SlidingTabStrip  extends LinearLayout {
    private static final int INDICATOR_THICKNESS = 3;

    private final int mSelectedIndicatorThickness;
    private final Paint mSelectedIndicatorPaint;


    private int mSelectedPosition;
    private float mSelectionOffset;

    SlidingTabStrip(Context context) {
        this(context, null);
    }

    SlidingTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);

        mSelectedIndicatorThickness = (int) Res.dp(INDICATOR_THICKNESS);
        mSelectedIndicatorPaint = new Paint();
        mSelectedIndicatorPaint.setStrokeWidth(Res.dp(1));
        mSelectedIndicatorPaint.setColor(Color.WHITE);

        setBackgroundColor(Color.TRANSPARENT);
    }

    void onViewPagerPageChanged(int position, float positionOffset) {
        int selected = position;
        if (positionOffset * 2 > 1) {
            selected = position + 1;
        }
        for (int i = 0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            if (selected == i) {
                ((TextView) v).setTextColor(Color.WHITE);
            } else {
                ((TextView) v).setTextColor(Res.color(R.color.black));
            }
        }
        mSelectedPosition = position;
        mSelectionOffset = positionOffset;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final int height = getHeight();
        final int childCount = getChildCount();

        // Thick colored underline below the current selection
        if (childCount > 0) {
            View selectedTitle = getChildAt(mSelectedPosition);
            int left = selectedTitle.getLeft();
            int right = selectedTitle.getRight();
            int color = Color.WHITE;

            if (mSelectionOffset > 0f && mSelectedPosition < (getChildCount() - 1)) {
                // Draw the selection partway between the tabs
                View nextTitle = getChildAt(mSelectedPosition + 1);
                left = (int) (mSelectionOffset * nextTitle.getLeft() +
                        (1.0f - mSelectionOffset) * left);
                right = (int) (mSelectionOffset * nextTitle.getRight() +
                        (1.0f - mSelectionOffset) * right);
            }

            canvas.drawRect(left, height - mSelectedIndicatorThickness, right,
                    height + 1, mSelectedIndicatorPaint);
        }
    }
}
