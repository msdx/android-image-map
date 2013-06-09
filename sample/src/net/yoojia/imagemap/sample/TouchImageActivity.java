package net.yoojia.imagemap.sample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import net.yoojia.imagemap.TouchImageView;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-06-07
 * 演示TouchImageView的Activity
 */
public class TouchImageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imageview);
		TouchImageView imageView = (TouchImageView) findViewById(R.id.image);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.imm_01, new BitmapFactory.Options());
		imageView.setImageBitmap(bitmap);

	}
}
