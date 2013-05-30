package net.yoojia.imagemap.support;

import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * author : chenyoca@gmail.com
 * date   : 13-5-19
 * The bubble wrapper.
 */
public class Bubble {

    static final boolean IS_API_11_LATER = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;

    public final View view;
    public final PointF position = new PointF();

    private BubbleDisplayer displayer;

    public Bubble(View view){
        this.view = view;
        final int wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT;
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(wrapContent,wrapContent);
        this.view.setLayoutParams(params);
        this.view.setClickable(true);
    }

    public interface BubbleDisplayer {
        void onDisplay(Shape shape, View bubbleView);
    }

    /**
     * Set the interface for bubble view render.
     * @param displayer displayer implments
     */
    public void setDisplayer(BubbleDisplayer displayer) {
        this.displayer = displayer;
    }

    /**
     * Show the bubble view on the shape.
     * @param shape the shape to show on
     */
    public void showAtShape(Shape shape){
        if(view == null) return;
        shape.createBubbleRelation(this);
        setBubbleViewAtPosition(shape.getCenterPoint());
        if (displayer != null){
            displayer.onDisplay(shape, view);
        }
        view.setVisibility(View.VISIBLE);
    }

    public void onScale(float scale,float scaleCenterX, float scaleCenterY){
        PointF newCenter = ScaleUtility.scaleByPoint(position.x,position.y,scaleCenterX,scaleCenterY,scale);
        setBubbleViewAtPosition(newCenter.x * scale,newCenter.y * scale);
    }

    /**
     * The image translated, sync translate the bubble view.
     * @param deltaX delta x
     * @param deltaY delta y
     */
    public void onTranslate(float deltaX,float deltaY){
        if(view != null && view.isShown()){
           setBubbleViewByOffset(deltaX, deltaY);
        }
    }

    private void setBubbleViewAtPosition(PointF center){
        float posX = center.x - view.getWidth()/2;
        float posY = center.y - view.getHeight();
        setBubbleViewAtPosition(posX, posY);
    }

    private void setBubbleViewAtPosition(float x, float y){
        position.set(x,y);
        if(IS_API_11_LATER){
            view.setX(x);
            view.setY(y);
        }else{
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
            if(params != null){
                params.leftMargin = (int)x;
                params.topMargin = (int)y;
            }
        }
    }

    private void setBubbleViewByOffset(float deltaX, float deltaY){
        if(IS_API_11_LATER){
            float x = view.getX() + deltaX;
            float y = view.getY() + deltaY;
            view.setX(x);
            view.setY(y);
            position.set(x,y);
        }else{
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();
            if(params != null){
                int x = (params.leftMargin += (int)deltaX);
                int y = (params.topMargin += (int)deltaY);
                position.set(x,y);
            }
        }
    }
}
