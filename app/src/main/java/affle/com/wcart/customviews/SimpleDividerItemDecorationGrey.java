package affle.com.wcart.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import affle.com.wcart.R;


/**
 * class to show divider b/w recycler view items.
 */
public class SimpleDividerItemDecorationGrey extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public SimpleDividerItemDecorationGrey(Context context) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.x_ds_line_divider_grey);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}