package lab.multitierapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import business.Coordinator;
import business.VinylRecord;

public class MainActivity extends Activity {

    private ListView mListView;
    private TextView mTextView;
	private Coordinator coobj;
    private List<VinylRecord> records;
	private String[] values;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mListView = (ListView) findViewById(R.id.list);
		mTextView = (TextView) findViewById(R.id.text);
		records = new ArrayList<VinylRecord>();
		coobj = new Coordinator(MainActivity.this);
		
		records = coobj.read();
		fillListView();
		
		mListView.setOnItemClickListener(itemClickListener);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private void sortByArtist(){
		records = coobj.readSortByArtist(); 
		fillListView();
	}
	private void sortByTitle(){
		records = coobj.readSortByTitle();
		fillListView();
	}
	private void sortByTrack(){
		records = coobj.read();
		fillListView();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
        case R.id.artist: sortByArtist();
            return true;
        case R.id.title: sortByTitle();
            return true;
        case R.id.track: sortByTrack();
            return true;            
        default:
            return super.onOptionsItemSelected(item);
    }
	}
	
	private void fillListView(){
		
		//mListView.
		
		if(records != null){
			int size = records.size();
			values = new String[size];
			for(int i = 0;i<size;i++){
				values[i] = records.get(i).getTitleArtist();
			}
			mTextView.setText(size + " records.");
		}
		else{
			values = new String[1];
			values[0] = "No records";
			mTextView.setText("Database not found");
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		// Assign adapter to ListView
		mListView.setAdapter(adapter);
		
	}
	
	
	private OnItemClickListener itemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long id) {

//			  Toast.makeText(getApplicationContext(),
//		      "Click ListItem Number " + position, Toast.LENGTH_LONG)
//		      .show();
			  //setContentView(R.layout.activity_detail);
			String[] values = new String[6];
			values[0] = records.get(position).getTitle();
			values[1] = records.get(position).getArtist();
			values[2] = records.get(position).getProducer();
			values[3] = records.get(position).getTracks() + "";
			values[4] = records.get(position).getSample();
			values[5] = records.get(position).getDesc();
			
			Intent intent = new Intent(MainActivity.this,DetailActivity.class);
			intent.putExtra("RecordDetail", values);
			startActivity(intent);
			
			
		}
	};

}
