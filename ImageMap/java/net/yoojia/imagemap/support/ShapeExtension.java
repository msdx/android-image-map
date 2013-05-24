package net.yoojia.imagemap.support;

import java.util.List;

/**
 * ShapeExtension是出于ImageMap继承于FrameLayout而又需要嵌入到HighlightImageView内部过程而设计的。
 * 主要是将HighlhgitImageView内部过程的操作扩展到ImageMap中处理。
 */
public interface ShapeExtension{

    public interface OnShapeActionListener {
        /**
         * 当一个Shape被点击
         * @param shape
         * @param xOnImage
         * @param yOnImage
         */
        void onShapeClick(Shape shape, float xOnImage, float yOnImage);

        /**
         * 产生移动。可以在此方法中处理BubbleView的移动
         * @param deltaX
         * @param deltaY
         */
        void onMoving(float deltaX, float deltaY);
    }

    void addShape(Shape shape);

    void addShapes(List<Shape> shapes);

    void removeShape(Object tag);
}