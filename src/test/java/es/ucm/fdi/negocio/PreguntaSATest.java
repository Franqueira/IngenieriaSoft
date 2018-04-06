package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import es.ucm.fdi.datos.BDHashMap;
import es.ucm.fdi.integracion.DAOs.AlarmaDAOImp;
import es.ucm.fdi.integracion.DAOs.PreguntaDAO;
import es.ucm.fdi.integracion.DAOs.PreguntaDAOImp;

public class PreguntaSATest {
	/*
	    public boolean comprobarRespuesta(String idPregunta, int respuesta) {
		return ((PreguntaPOJO) preguntaDAO.getFromId(idPregunta)).getRespuestaCorrecta() == respuesta;
	}
	*/
public void setup(PreguntaDAOImp preguntaDAO){
		
	ArrayList<String> respuestas1=new ArrayList<String>();
	respuestas1.add("Madrid");
	respuestas1.add("Paris");
	respuestas1.add("Roma");
	respuestas1.add("Londres");
	preguntaDAO.save(new PreguntaPOJO("a1", "cual es la capital de españa?", respuestas1, 1));
	ArrayList<String> respuestas2=new ArrayList<String>();
	respuestas2.add("Madrid");
	respuestas2.add("Paris");
	respuestas2.add("Roma");
	respuestas2.add("Londres");
	preguntaDAO.save(new PreguntaPOJO("a2", "cual es la capital de francia?", respuestas2, 2));
	ArrayList<String> respuestas3=new ArrayList<String>();
	respuestas3.add("Madrid");
	respuestas3.add("Paris");
	respuestas3.add("Roma");
	respuestas3.add("Londres");
	preguntaDAO.save(new PreguntaPOJO("a3", "cual es la capital de italia?", respuestas3, 3));
	ArrayList<String> respuestas4=new ArrayList<String>();
	respuestas4.add("Madrid");
	respuestas4.add("Paris");
	respuestas4.add("Roma");
	respuestas4.add("Londres");
	preguntaDAO.save(new PreguntaPOJO("a4", "cual es la capital de reino unido?", respuestas4, 4));
	ArrayList<String> respuestas5=new ArrayList<String>();
	respuestas5.add("Wahington");
	respuestas5.add("Moscu");
	respuestas5.add("Praga");
	respuestas5.add("Berlin");
	preguntaDAO.save(new PreguntaPOJO("a5", "cual es la capital de eeuu?", respuestas5, 1));
	ArrayList<String> respuestas6=new ArrayList<String>();
	respuestas6.add("Wahington");
	respuestas6.add("Moscu");
	respuestas6.add("Praga");
	respuestas6.add("Berlin");
	preguntaDAO.save(new PreguntaPOJO("a6", "cual es la capital de rusia?", respuestas5, 2));
	ArrayList<String> respuestas7=new ArrayList<String>();
	respuestas7.add("Wahington");
	respuestas7.add("Moscu");
	respuestas7.add("Praga");
	respuestas7.add("Berlin");
	preguntaDAO.save(new PreguntaPOJO("a7", "cual es la capital de checoslovaquia?", respuestas5, 3));
	ArrayList<String> respuestas8=new ArrayList<String>();
	respuestas8.add("Wahington");
	respuestas8.add("Moscu");
	respuestas8.add("Praga");
	respuestas8.add("Berlin");
	preguntaDAO.save(new PreguntaPOJO("a8", "cual es la capital de alemania?", respuestas8, 4));
	ArrayList<String> respuestas9=new ArrayList<String>();
	respuestas9.add("el cairo");
	respuestas9.add("copenague");
	respuestas9.add("estocolmo");
	respuestas9.add("helsinki");
	preguntaDAO.save(new PreguntaPOJO("a9", "cual es la capital de egipto?", respuestas9, 1));
	ArrayList<String> respuestas10=new ArrayList<String>();
	respuestas10.add("el cairo");
	respuestas10.add("copenague");
	respuestas10.add("estocolmo");
	respuestas10.add("helsinki");
	preguntaDAO.save(new PreguntaPOJO("a10", "cual es la capital de dinamarca?", respuestas10, 1));
	ArrayList<String> respuestas11=new ArrayList<String>();
	respuestas11.add("el cairo");
	respuestas11.add("copenague");
	respuestas11.add("estocolmo");
	respuestas11.add("helsinki");
	preguntaDAO.save(new PreguntaPOJO("a11", "cual es la capital de suecia?", respuestas11, 1));
	ArrayList<String> respuestas12=new ArrayList<String>();
	respuestas12.add("el cairo");
	respuestas12.add("copenague");
	respuestas12.add("estocolmo");
	respuestas12.add("helsinki");
	preguntaDAO.save(new PreguntaPOJO("a12", "cual es la capital de finlandia?", respuestas12, 1));	
	}
	
	@Test
	public void getActiveTest(){
		PreguntaDAOImp preguntaDAO = new PreguntaDAOImp(new BDHashMap<PreguntaPOJO>());
		setup(preguntaDAO);
		PreguntaSA preguntaSA = new PreguntaSAImp(preguntaDAO);
		assertTrue("Debería ser correcta",preguntaSA.comprobarRespuesta("a1",1));
		assertFalse("Debería ser falsa",preguntaSA.comprobarRespuesta("a1",2));
		assertFalse("Debería ser falsa",preguntaSA.comprobarRespuesta("a1",3));
	}
}
