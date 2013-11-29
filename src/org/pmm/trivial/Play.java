package org.pmm.trivial;

import java.util.ArrayList;

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
	

	public ArrayList<Question> preguntas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);

		
		preguntas = new ArrayList<Question>();
		cargaPreguntas();
		

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
	
	
	//Metodo para cargar las preguntas en el arraylist
	public void cargaPreguntas(){
		
		preguntas.add(new Question("Historia", "¿En qué año finalizó la Guerra Civil Española?", new String[]{"1929","1932","1939","1937"}, 3, 1));
		preguntas.add(new Question("Deportes", "¿Cuál fue el tenista que lideró más tiempo el titulo de número uno?", new String[]{"Pete Sampras","André Agassi","Rafael Nadal","Roger Federer"}, 4, 2));
		preguntas.add(new Question("Literatura", "¿Quién fue el autor del Lazarillo de Tormes?", new String[]{"Miguel de Cervantes","Anónimo","Pio Baroja","Federico García Lrca"}, 2, 1));
		preguntas.add(new Question("Informatica", "¿Qué nuevo Sistema Operativo va a lanzar para moviles en 2013?", new String[]{"Ubuntu Phone","Android Cake","Neo Samsung ","Xtream"}, 1, 2));

	}

}
