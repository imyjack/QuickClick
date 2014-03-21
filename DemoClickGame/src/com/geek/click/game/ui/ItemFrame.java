
package com.geek.click.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ItemFrame extends LinearLayout {

    private Context mContext;
    private LinearLayout mLeftLayout;
    private LinearLayout mLeftMiddleLayout;
    private LinearLayout mRightMiddleLayout;
    private LinearLayout mRightLayout;

    public ItemFrame(Context context) {

        super(context);
        init(context);
    }

    public ItemFrame(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(context);
    }

    public ItemFrame(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {

        mContext = context;
        mLeftLayout = createItem(mContext);
        mLeftMiddleLayout = createItem(mContext);
        mRightMiddleLayout = createItem(mContext);
        mRightLayout = createItem(mContext);

        addView(mLeftLayout);
        addView(mLeftMiddleLayout);
        addView(mRightMiddleLayout);
        addView(mRightLayout);
    }

    private LinearLayout createItem(Context context) {

        LinearLayout layout = new LinearLayout(context);
        LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        layout.setLayoutParams(params);
        return layout;
    }
}
