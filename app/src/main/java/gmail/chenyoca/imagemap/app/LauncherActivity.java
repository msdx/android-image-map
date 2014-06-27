package gmail.chenyoca.imagemap.app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-06-07
 * TODO
 */
public class LauncherActivity extends ListActivity {

	final String[] SAMPLES = {
					"Touch Image View",
					"Hight Light Image",
					"Image Map"};

	final static Class<?>[] targets = {
					TouchImageActivity.class,
					HighlightImageActivity.class,
					ImageMapActivity.class
					};

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_sample_list);

		List<String> items = new ArrayList<String>(Arrays.asList(SAMPLES));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);

		this.setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		Intent intent = new Intent(LauncherActivity.this,targets[position]);
		startActivity(intent);
	}
}
