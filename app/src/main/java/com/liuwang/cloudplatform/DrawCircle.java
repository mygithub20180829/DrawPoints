package com.liuwang.cloudplatform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class DrawCircle extends View {

    private int currentX = getScreenWidth()/2;//40
    private int currentY = getScreenHeight()/2;//50
    //定义并创建画笔
    Paint p = new Paint();

    public DrawCircle(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public DrawCircle(Context context, AttributeSet set){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        //设置画笔的颜色
        p.setColor(Color.BLUE);
        //绘制一个小圆（作为小球） 四个参数代表坐标   半径  画笔
        canvas.drawCircle(currentX, currentY, 15, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
/*

            case MotionEvent.ACTION_DOWN:

                currentX = (int) event.getX();
                currentY = (int) event.getY();
                break;*/

            case MotionEvent.ACTION_MOVE:
                currentX = (int) event.getX();
                currentY = (int) event.getY();

                if(currentX - getScreenWidth()/2 >= 200)
                    currentX = getScreenWidth()/2 + 200;
                if(currentX - getScreenWidth()/2 <= -200)
                    currentX = getScreenWidth()/2 - 200;

                if(currentY - getScreenHeight()/2 >= 200)
                    currentY = getScreenHeight()/2 + 200;
                if(currentY - getScreenHeight()/2 <= -200)
                    currentY = getScreenHeight()/2 - 200;


               break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }

        //通知当前组件重绘自己
        invalidate();
        //返回true表明该处理方法已经处理该事件
        //return super.onTouchEvent(event);
        return true;
    }

    private int getScreenWidth() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int getScreenHeight() {
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /**
     * 在屏幕中央处画圆
     * @param radius
     * @param canvas
     * @param paint
     */
    private void drawCircleInCenter(float radius,Canvas canvas,Paint paint){
        WindowManager manager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);//获取WM对象
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        int screenPxHeight = dm.heightPixels;//获取真实屏幕的高度以px为单位
        int sceenPxWidth = dm.widthPixels;
    }


}
