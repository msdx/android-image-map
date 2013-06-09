package net.yoojia.imagemap.sample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import net.yoojia.imagemap.HighlightImageView;
import net.yoojia.imagemap.core.CircleShape;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-06-07
 * 图片高亮区域演示Activity
 */
public class HighlightImageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_highlight_image);
		HighlightImageView imageView = (HighlightImageView) findViewById(R.id.image);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.imm_01, new BitmapFactory.Options());
		imageView.setImageBitmap(bitmap);

		CircleShape shape = new CircleShape("Tag", Color.RED);
		shape.setValues(100,100,20);

		imageView.addShape(shape);

	}
}
