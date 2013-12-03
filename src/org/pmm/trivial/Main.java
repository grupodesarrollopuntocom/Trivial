package org.pmm.trivial;

import android.os.Bundle;
import android.app.Activity;
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
					//
				break;
				case 1:
					//
				break;
				case 2:	
					//
				break;
				}
				
				
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
