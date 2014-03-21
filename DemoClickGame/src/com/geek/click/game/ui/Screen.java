
package com.geek.click.game.ui;

import com.geek.click.game.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class Screen extends FrameLayout {

    private int X = 4;
    private int Y = X;

    private int[][] flag = new int[X][Y];
    private int color = 0x55000000;

    private int mScore = 0;
    private int w;
    private int h;

    private boolean isStop = false;

    public Screen(Context context) {

        super(context);
        init(context);
    }

    private void init(Context context) {

        w = screenWidthPixel(context) / X;
        h = screenHeightPixel(context) / Y;
        initFlag();
        initView(context);
    }

    private void initFlag() {

        for (int i = 0; i < X; i++) {
            int tag = (int) (Math.random() * 4);
            for (int j = 0; j < Y; j++) {
                if (tag == j) {
                    flag[i][j] = 1;
                } else {
                    flag[i][j] = 0;
                }
            }
        }
    }

    private void initView(Context context) {

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                createItem(context, i, j);
            }
        }
        refreshFlag();
    }

    private void refreshFlag() {

        for (int i = Y - 1; i > 0; i--) {
            for (int j = 0; j < X; j++) {
                flag[i][j] = flag[i - 1][j];
            }
        }
        int tag = (int) (Math.random() * 4);
        for (int i = 0; i < X; i++) {
            if (i == tag) {
                flag[0][i] = 1;
            } else {
                flag[0][i] = 0;
            }
        }
        initViewColor();
    }

    private void initViewColor() {

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                View layout = getChildAt(i * 4 + j);
                if (flag[j][i] == 1) {
                    layout.setBackgroundResource(R.drawable.color_black);
                } else {
                    layout.setBackgroundResource(R.drawable.color_white);
                }
                layout.setTag(flag[j][i]);
            }
        }
    }

    private void createItem(final Context context, int x, int y) {

        LayoutParams params = new LayoutParams(w, h);
        params.setMargins(w * x, h * y, 0, 0);
        FrameLayout layout = new FrameLayout(context);
        layout.setLayoutParams(params);
        layout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (isStop) {
                    return;
                }
                int tag = (Integer) v.getTag();
                if (tag != 1) {
                    isStop = true;
                    showDialog(context);
                } else {
                    refreshFlag();
                    mScore++;
                }
            }
        });
        addView(layout);
    }

    private void showDialog(Context context) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setMessage("Your Score is: " + mScore);
        alert.setCancelable(false);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                isStop = false;
                refreshFlag();
            }
        });
        alert.show();
        mScore = 0;
    }

    public static int screenWidthPixel(Context context) {

        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int widthPixels = windowManager.getDefaultDisplay().getWidth();
        return widthPixels;
    }

    public static int screenHeightPixel(Context context) {

        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int heightPixels = windowManager.getDefaultDisplay().getHeight();
        return heightPixels;
    }

}
