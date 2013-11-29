package org.pmm.trivial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Play extends Activity {
	private TextView tv1, tv2;
	private Button bt1, bt2, bt3, bt4;
	private ProgressBar pgb;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		tv1 = (TextView)findViewById(R.id.miTextoPregunta);
		tv2 = (TextView)findViewById(R.id.miTextoScore);
		bt1 = (Button)findViewById(R.id.miBoton1);
		bt2 = (Button)findViewById(R.id.miBoton2);
		bt3 = (Button)findViewById(R.id.miBoton3);
		bt4 = (Button)findViewById(R.id.miBoton4);
		pgb = (ProgressBar)findViewById(R.id.miProgressbar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

}
