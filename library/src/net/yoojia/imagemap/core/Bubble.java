package net.yoojia.imagemap.core;

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
public class Bubble extends FrameLayout{

    static final boolean IS_API_11_LATER = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;

    public final View view;
    public final PointF position = new PointF();

	private Shape currentShape;

    private RenderDelegate renderDelegate;

    public Bubble(View view){
		super(view.getContext());
        this.view = view;
        final int wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT;
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(wrapContent,wrapContent);
        this.view.setLayoutParams(params);
        this.view.setClickable(true);
		addView(view);
    }

//	@Override
//	protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		if(currentShape != null){
//			showAtShape(currentShape);
//		}
//	}

	public interface RenderDelegate {
        void onDisplay(Shape shape, View bubbleView);
    }

    /**
     * Set the interface for bubble viewcontroller render.
     * @param renderDelegate renderDelegate implments
     */
    public void setRenderDelegate (RenderDelegate renderDelegate) {
        this.renderDelegate = renderDelegate;
    }

    /**
     * Show the bubble viewcontroller on the shape.
     * @param shape the shape to show on
     */
    public void showAtShape(Shape shape){
        if(view == null) return;
		currentShape = shape;
        shape.createBubbleRelation(this);
        setBubbleViewAtPosition(shape.getCenterPoint());
        if (renderDelegate != null){
            renderDelegate.onDisplay(shape, view);
        }
        view.setVisibility(View.VISIBLE);
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

}
