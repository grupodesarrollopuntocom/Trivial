package org.pmm.trivial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Main extends Activity {
	private String[] datos;
	private ArrayAdapter<String> adaptador;
	private ListView lista;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		datos = new String[] { "Play", "Score", "Credits"};
		adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
		lista = (ListView) findViewById(R.id.miListView);
		lista.setAdapter(adaptador);
		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				switch(position){
				case 0:
					intent = new Intent(Main.this, Play.class);
				break;
				case 1:
					intent = new Intent(Main.this, Score.class);
				break;
				case 2:	
					intent = new Intent(Main.this, Credits.class	);
				break;
				}
				startActivity(intent);
				
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
