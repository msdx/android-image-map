package gmail.chenyoca.imagemap.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gmail.chenyoca.imagemap.ImageMap;
import gmail.chenyoca.imagemap.support.Bubble;
import gmail.chenyoca.imagemap.support.CircleShape;
import gmail.chenyoca.imagemap.support.Shape;

public class ImageMapActivity extends Activity {

	private ImageMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagemap);

        // set image
        map = (ImageMap) findViewById(R.id.imagemap);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.imm_01, new BitmapFactory.Options());
        map.setMapBitmap(bitmap);

        View bubble = getLayoutInflater().inflate(R.layout.popup,null);

        map.setBubbleView(bubble,new Bubble.RenderDelegate() {
            @Override
            public void onDisplay(Shape shape, View bubbleView) {
                ImageView logo = (ImageView) bubbleView.findViewById(R.id.logo);
                TextView name = (TextView) bubbleView.findViewById(R.id.name);

                name.setText(shape.tag.toString()+":"+((int)(Math.random()*100)+100));
                logo.setImageResource(R.drawable.kfc_logo);
            }
        });

    }

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE,10086,0,"变换").setIcon(android.R.drawable.ic_menu_add);
		menu.add(Menu.NONE,10087,1,"缩放").setIcon(android.R.drawable.ic_menu_add);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item){
//		super.onOptionsItemSelected(item);

		if(item.getItemId() == 10086){
			// set color
			// circle
			CircleShape black = new CircleShape("NO", Color.BLUE);
			double x = Math.random()*300 + 500;
			double y = Math.random()*300 + 500;
			black.setValues(String.format("%.5f,%.5f,15",x,y));
			// 设置一个Shape，并在初始显示时，将Bubble显示到它的位置上
			map.addShapeAndRefToBubble(black);

		}else if(item.getItemId() == 10087){
//			map.resetImage();
		}

		return true;
	}

}
