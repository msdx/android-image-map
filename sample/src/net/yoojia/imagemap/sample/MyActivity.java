package net.yoojia.imagemap.sample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import net.yoojia.imagemap.ImageMap;
import net.yoojia.imagemap.support.Bubble;
import net.yoojia.imagemap.support.CircleShape;
import net.yoojia.imagemap.support.Shape;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set image
        ImageMap map = (ImageMap) findViewById(R.id.imagemap);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.imm_01, new BitmapFactory.Options());
        map.setMapBitmap(bitmap);

        View bubble = getLayoutInflater().inflate(R.layout.popup,null);

        map.setBubbleView(bubble,new Bubble.BubbleDisplayer() {
            @Override
            public void onDisplay(Shape shape, View bubbleView) {
                ImageView logo = (ImageView) bubbleView.findViewById(R.id.logo);
                TextView name = (TextView) bubbleView.findViewById(R.id.name);

                name.setText(shape.tag.toString());
                logo.setImageResource(R.drawable.kfc_logo);
            }
        });

        // set color
        // circle
        CircleShape black = new CircleShape("KFC Fastfood", Color.BLUE);
        black.setValues("292.35898,133.64102,15");

        // 设置一个Shape，并在初始显示时，将Bubble显示到它的位置上
        map.addShapeAndRefToBubble(black);

        // circle
//        Shape red = new CircleShape("red", Color.BLACK);
//        red.setValues(665,144,15);
//        map.addShape(red);
//
//        // rect
//        Shape blue = new RectShape("blue",Color.BLUE);
//        blue.setValues(104,7,226, 94);
//        map.addShape(blue);
//
//        // poly
//
//        // croods int/float values
//        Shape orange = new PolyShape("orange",0xff8226);
//        orange.setValues(172,370, 178,332, 194,283, 220,215, 253,172, 262,173, 268,197, 269,213, 279,264, 279,286, 288,319, 290,344, 288,368, 270,376, 238,370, 199,370, 175,373);
//        map.addShape(orange);
//
//        // coores string values
//        Shape green = new PolyShape("poly",Color.GREEN);
//        green.setValues("229,432, 238,394, 262,384, 293,372, 312,381, 342,393, 355,414, 357,420, 371,434, 375,456, 370,471, 363,479, 360,499, 358,509, 329,513, 310,518, 281,518, 268,512, 182,536, 133,544, 89,539, 98,530, 133,532, 125,520, 88,522, 79,530, 67,521, 84,510, 100,510, 133,491, 149,494, 228,436");
//        map.addShape(green);
//
//        Shape yellow = new PolyShape("yellow",Color.YELLOW);
//        yellow.setValues("626,482, 625,481, 669,491, 710,480, 679,522, 676,537, 658,538, 650,518, 628,486");
//        map.addShape(yellow);
//
//        //
//        Shape white = new PolyShape("white",0x8962a0);
//        white.setValues(559,270, 599,239, 627,265, 642,267, 668,266, 680,294, 664,303, 669,323, 690,325, 712,310, 720,311, 713,335, 715,369, 722,390, 744,443, 745,456, 717,475, 673,481, 636,477, 604,458, 586,439, 591,423, 590,398, 571,336, 561,273);
//        map.addShape(white);

    }
}
