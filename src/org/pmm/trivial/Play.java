package org.pmm.trivial;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ProgressBar;


public class Play extends Activity {
	
	ProgressBar barraTiempo;
	private HiloProgreso hilo;
	int progreso;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		
		barraTiempo=(ProgressBar)findViewById(R.id.miProgressbar);
		hilo = new HiloProgreso();
		hilo.execute();
	}
	
	public class HiloProgreso extends AsyncTask<Void, Void, Void>{
		protected void onPostExecute(Void result){
			
		}
		@Override
		protected void onPreExecute() {
			barraTiempo.setMax(1000);
		}
		@Override
		protected void onProgressUpdate(Void... values) {
			barraTiempo.incrementProgressBy(100);
		}
		
		@Override
		protected Void doInBackground(Void... arg0) {
			while(!isCancelled()){
				try{
					Thread.sleep(1000);
					publishProgress();
				}catch(InterruptedException e){
					
				}					
			}
			return null;
		}
		
}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}

}
