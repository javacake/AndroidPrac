package lab.multitierapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DetailActivity extends Activity {

	private ListView dList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		dList = (ListView) findViewById(R.id.listView1);
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		Intent i = getIntent();
		String[] values = (String[]) i.getSerializableExtra("RecordDetail");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);
		
		// Assign adapter to ListView
		dList.setAdapter(adapter);

		super.onStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_detail, menu);
		return true;
	}
	


}
