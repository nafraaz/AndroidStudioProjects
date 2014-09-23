package mouse.simple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Basie_ListViewActivity extends Activity {
	/** Called when the activity is first created. */

	private Button but1,but2,but3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		but1 = (Button) findViewById(R.id.button1);
		but1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Basie_ListViewActivity.this, ListView1.class);
				startActivity(intent);

			}
		});
		
		but2 = (Button) findViewById(R.id.button2);
		but2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Basie_ListViewActivity.this, ListView2.class);
				startActivity(intent);

			}
		});
		
		but3 = (Button) findViewById(R.id.button3);
		but3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Basie_ListViewActivity.this, ListView3.class);
				startActivity(intent);

			}
		});
	}
}