package mouse.simple;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListView1 extends Activity {

	private ListView listView;
	private ArrayAdapter<String> adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview1);

		listView = (ListView) findViewById(R.id.listView1);

		// ?M??}?C
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1);
		adapter.add("????");
		adapter.add("???");
		adapter.add("??");
		adapter.add("??");
		adapter.add("??");
		adapter.add("?g??");
		adapter.add("???Y");
		adapter.add("?a??");

		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) { //(????,?,??M???r,?M??s??);
				// TODO Auto-generated method stub
				ListView listView = (ListView) arg0;
				Toast.makeText(
						ListView1.this,
						"ID?G" + arg3 +
						"   ????r?G"+ listView.getItemAtPosition(arg2).toString(),
						Toast.LENGTH_LONG).show();

			}
		});
	}

}
