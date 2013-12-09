package org.pmm.trivial;


import java.util.ArrayList;




import android.os.AsyncTask;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import android.widget.ProgressBar;



public class Play extends Activity {

	private TextView tvpregunta, tvscore;
	private Button bt1, bt2, bt3, bt4;
	private ProgressBar pgb;
	private int posicion, respcorrecta;
	private AlertDialog.Builder dialog;
	

	public ArrayList<Question> preguntas;

	
	ProgressBar barraTiempo;
	private HiloProgreso hilo;
	int puntos,puntosGenerales;
	boolean tiempo;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);

		preguntas = new ArrayList<Question>();
		cargaPreguntas();
		posicion=0;

		tvpregunta = (TextView)findViewById(R.id.miTextoPregunta);
		tvscore = (TextView)findViewById(R.id.miTextoScore);
		bt1 = (Button)findViewById(R.id.miBoton1);
		bt2 = (Button)findViewById(R.id.miBoton2);
		bt3 = (Button)findViewById(R.id.miBoton3);
		bt4 = (Button)findViewById(R.id.miBoton4);
		pgb = (ProgressBar)findViewById(R.id.miProgressbar);
		barraTiempo=(ProgressBar)findViewById(R.id.miProgressbar);
		
		puntosGenerales=0;
		
		cargaSiguientePregunta();
		
		bt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(respcorrecta==0){
					bt1.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
					acierto();
				}else{
					bt1.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
					//pintaAcierto(respcorrecta);
					fallo();
				}
				tiempo=false;
				try{
					
					Thread.sleep(1000);
				}catch(InterruptedException e){	
				}
				puntosGenerales+=puntos;
				//cargaSiguientePregunta();
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(respcorrecta==1){
					bt2.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
					acierto();
				}else{
					bt2.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
					//pintaAcierto(respcorrecta);
					fallo();
				}
					tiempo=false;
				try{
					
					Thread.sleep(1000);
				}catch(InterruptedException e){	
				}	
				puntosGenerales+=puntos;
				//cargaSiguientePregunta();
				
			}
		});
		bt3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(respcorrecta==2){
					bt3.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
					acierto();
				}else{
					bt3.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
					//pintaAcierto(respcorrecta);
					fallo();
				}
					tiempo=false;
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){	
				}	
				puntosGenerales+=puntos;
				//cargaSiguientePregunta();
			}
		});
		bt4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(respcorrecta==3){
					bt4.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
					acierto();
				}else{
					bt4.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
					//pintaAcierto(respcorrecta);
					fallo();
				}
					tiempo=false;
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){	
				}	
				puntosGenerales+=puntos;
				//cargaSiguientePregunta();
			}
		});
	}
	
	public class HiloProgreso extends AsyncTask<Void, Void, Void>{
		protected void onPostExecute(Void result){
			
		}
		@Override
		protected void onPreExecute() {
			barraTiempo.setMax(1000);
			barraTiempo.setProgress(0);
		}
		@Override
		protected void onProgressUpdate(Void... values) {
			barraTiempo.incrementProgressBy(100);
			
			
		}
		
		@Override
		protected Void doInBackground(Void... arg0) {
			while(!isCancelled()&&tiempo){
				try{
					Thread.sleep(1000);
					publishProgress();
					puntos-=200;
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
		
		preguntas.add(new Question("Historia", "¿En qué año finalizó la Guerra Civil Española?", new String[]{"1929","1932","1939","1937"}, 2, 0));
		preguntas.add(new Question("Deportes", "¿Cuál fue el tenista que lideró más tiempo el titulo de número uno?", new String[]{"Pete Sampras","André Agassi","Rafael Nadal","Roger Federer"}, 3, 1));
		preguntas.add(new Question("Literatura", "¿Quién fue el autor del Lazarillo de Tormes?", new String[]{"Miguel de Cervantes","Anónimo","Pio Baroja","Federico García Lrca"}, 1, 0));
		preguntas.add(new Question("Informatica", "¿Qué nuevo Sistema Operativo va a lanzar para moviles en 2013?", new String[]{"Ubuntu Phone","Android Cake","Neo Samsung ","Xtream"}, 0, 1));

	}
	
	
	//Metodo para cargar la siguiente pregunta en los botones
	private void cargaSiguientePregunta(){
		this.puntos=2000;
		this.tiempo=true;
		String listarespuestas[];	//creo un array con las preguntas
		System.out.println();
		Question q;
		
		q = preguntas.get(posicion);//devuelve la posicion del num de pregunta
		listarespuestas = q.getAnswers();//LLamo a la pregunta y respuestas de la clase question
		
		tvscore.setText(Integer.toString(puntosGenerales));
		tvpregunta.setText(q.getQuestionText());
		bt1.setText(listarespuestas[0]);
		bt2.setText(listarespuestas[1]);
		bt3.setText(listarespuestas[2]);
		bt4.setText(listarespuestas[3]);
		bt1.getBackground().setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
		bt2.getBackground().setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
		bt3.getBackground().setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
		bt4.getBackground().setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
		
		respcorrecta = q.getRightAnswer();//le digo cual es la respuesta correcta
		System.out.println(listarespuestas.length );
		hilo = new HiloProgreso();
		hilo.execute();
		
		posicion++;
		
	}
	/*
	private void pintaAcierto(int respcorrecta){
		switch(respcorrecta){
			case 1:		
				bt1.setBackgroundColor(Color.GREEN);			
				break;	
		
			case 2:
				bt2.setBackgroundColor(Color.GREEN);
				break;
			
			case 3:
				bt3.setBackgroundColor(Color.GREEN);
				break;
				
			case 4:
				bt4.setBackgroundColor(Color.GREEN);
				break;				
		}		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	public void acierto(){
		
		String mensaje;
		
		if(posicion == preguntas.size())
			mensaje = "Has acertado!!! Se ha finalizado el juego";
		else
			mensaje = "Has acertado!!! Siguiente pregunta, ¿Quieres continuar?";
			
		dialog = new AlertDialog.Builder(Play.this);
		dialog.setMessage(mensaje);
		dialog.setCancelable(false);
		dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(!(posicion == preguntas.size())){
					
					//posicion++; 
	    	  		cargaSiguientePregunta();
					
					}else{
						
						Intent data = new Intent();
						setResult(RESULT_OK, data);
		    			finish();
					}
				}
		});
		
		if(posicion != preguntas.size()){
			
			dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					setResult(RESULT_CANCELED);
					Play.this.finish();
					
				}
			});
			
			}

		dialog.show();
		
	}
	
	
public void fallo(){
		
		String mensaje;
		
		if(posicion == preguntas.size())
			mensaje = "Has fallado!!! Se ha finalizado el juego";
		else
			mensaje = "Has fallado!!! Siguiente pregunta, ¿Quieres continuar?";
			
		dialog = new AlertDialog.Builder(Play.this);
		dialog.setMessage(mensaje);
		dialog.setCancelable(false);
		dialog.setPositiveButton("Si", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(!(posicion == preguntas.size())){
					
					//posicion++; 
	    	  		cargaSiguientePregunta();
					
					}else{
						
						Intent data = new Intent();
						setResult(RESULT_OK, data);
		    			finish();
					}
				}
		});
		
		if(posicion != preguntas.size()){
			
			dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					setResult(RESULT_CANCELED);
					Play.this.finish();
					
				}
			});
			
			}

		dialog.show();
		
	}
	
	
	
	
}