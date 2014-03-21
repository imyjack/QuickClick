
package com.geek.click.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ScreenFrame extends LinearLayout {

    private Context mContext;

    private static final int COUNT = 4;
    public ScreenFrame(Context context) {

        super(context);
        init(context);
    }

    public ScreenFrame(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(context);
    }

    public ScreenFrame(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {


    }

}
