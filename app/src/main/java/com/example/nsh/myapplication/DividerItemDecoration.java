package com.example.nsh.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by NSH on 2016/3/24 21:17.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    // 默认分隔条资源id
    private static final int[] ATTRS = {android.R.attr.listDivider};
    //分隔条Drawable对象
    private Drawable mDivider;

    public DividerItemDecoration(Context context) {
        TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider =   a.getDrawable(0);
        a.recycle();
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i ++) {
            View child = parent.getChildAt(i);
            int left = child.getLeft() ;
            int right = child.getRight();
            int top = child.getBottom();

            mDivider.setBounds(left, top, right, top + 6);
            mDivider.draw(c);
        }
    }

}
