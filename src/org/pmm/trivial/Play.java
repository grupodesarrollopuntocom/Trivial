package org.pmm.trivial;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Play extends Activity {

	public ArrayList<Question> preguntas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		
		preguntas = new ArrayList<Question>();
		cargaPreguntas();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	
	
	//Metodo para cargar las preguntas en el arraylist
	public void cargaPreguntas(){
		
		preguntas.add(new Question("Historia", "�En qu� a�o finaliz� la Guerra Civil Espa�ola?", new String[]{"1929","1932","1939","1937"}, 3, 1));
		preguntas.add(new Question("Deportes", "�Cu�l fue el tenista que lider� m�s tiempo el titulo de n�mero uno?", new String[]{"Pete Sampras","Andr� Agassi","Rafael Nadal","Roger Federer"}, 4, 2));
		preguntas.add(new Question("Literatura", "�Qui�n fue el autor del Lazarillo de Tormes?", new String[]{"Miguel de Cervantes","An�nimo","Pio Baroja","Federico Garc�a Lrca"}, 2, 1));
		preguntas.add(new Question("Informatica", "�Qu� nuevo Sistema Operativo va a lanzar para moviles en 2013?", new String[]{"Ubuntu Phone","Android Cake","Neo Samsung ","Xtream"}, 1, 2));

	}

}
