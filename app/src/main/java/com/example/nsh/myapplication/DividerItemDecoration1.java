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
public class DividerItemDecoration1 extends RecyclerView.ItemDecoration {
    // 默认分隔条资源id
    private static final int[] ATTRS = {android.R.attr.listDivider};
    //分隔条Drawable对象
    private Drawable mDivider;

    public DividerItemDecoration1(Context context) {
        TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int childCount = parent.getChildCount();

        // RecyclerView布局的距离左边的间隔 从左边的这个坐标开始绘制
        int left = parent.getPaddingLeft();

        // RecyclerView布局的宽度减去右边到边界的距离 绘制到右边的这个坐标
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            // 当前列表项布局参数信息
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            // 字体底部的坐标 加上控件内边距的距离是整个控件的底部坐标 表示从这里开始绘制
            int top = child.getBottom() + params.bottomMargin;
            // 开始绘制的纵距离加上高度就是底部坐标
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

}
