package org.pmm.trivial;


import java.util.ArrayList;




import android.os.AsyncTask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import android.widget.ProgressBar;



public class Play extends Activity {

	private TextView tvpregunta, tvscore;
	private Button bt1, bt2, bt3, bt4;
	private ProgressBar pgb;
	private int posicion, respcorrecta;
	

	public ArrayList<Question> preguntas;

	
	ProgressBar barraTiempo;
	private HiloProgreso hilo;
	int progreso;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);


		
		preguntas = new ArrayList<Question>();
		cargaPreguntas();
		

		tvpregunta = (TextView)findViewById(R.id.miTextoPregunta);
		tvscore = (TextView)findViewById(R.id.miTextoScore);
		bt1 = (Button)findViewById(R.id.miBoton1);
		bt2 = (Button)findViewById(R.id.miBoton2);
		bt3 = (Button)findViewById(R.id.miBoton3);
		bt4 = (Button)findViewById(R.id.miBoton4);
		pgb = (ProgressBar)findViewById(R.id.miProgressbar);


		
		barraTiempo=(ProgressBar)findViewById(R.id.miProgressbar);
		cargaSiguientePregunta();
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
	
	
	//Metodo para cargar las preguntas en el arraylist
	public void cargaPreguntas(){
		
		preguntas.add(new Question("Historia", "¿En qué año finalizó la Guerra Civil Española?", new String[]{"1929","1932","1939","1937"}, 3, 1));
		preguntas.add(new Question("Deportes", "¿Cuál fue el tenista que lideró más tiempo el titulo de número uno?", new String[]{"Pete Sampras","André Agassi","Rafael Nadal","Roger Federer"}, 4, 2));
		preguntas.add(new Question("Literatura", "¿Quién fue el autor del Lazarillo de Tormes?", new String[]{"Miguel de Cervantes","Anónimo","Pio Baroja","Federico García Lrca"}, 2, 1));
		preguntas.add(new Question("Informatica", "¿Qué nuevo Sistema Operativo va a lanzar para moviles en 2013?", new String[]{"Ubuntu Phone","Android Cake","Neo Samsung ","Xtream"}, 1, 2));

	}
	
	
	//Metodo para cargar la siguiente pregunta en los botones
	private void cargaSiguientePregunta(){
		
		String listarespuestas[];	//creo un array con las preguntas	
		Question q;
		
		if(posicion >= 0 && posicion < preguntas.size()){
		
		q = preguntas.get(posicion);//devuelve la posicion del num de pregunta
		listarespuestas = q.getAnswers();//LLamo a la pregunta y respuestas de la clase question
		
		tvpregunta.setText(q.getQuestionText());
		bt1.setText(listarespuestas[0]);
		bt2.setText(listarespuestas[1]);
		bt3.setText(listarespuestas[2]);
		bt4.setText(listarespuestas[3]);
		
		respcorrecta = q.getRightAnswer();//le digo cual es la respuesta correcta
		
		}
		
	}

}
