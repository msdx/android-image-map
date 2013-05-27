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

    }

    /**
     * 添加形状
     * @param shape 形状描述
     */
    void addShape(Shape shape);

    void addShapes(List<Shape> shapes);

    void removeShape(Object tag);
}