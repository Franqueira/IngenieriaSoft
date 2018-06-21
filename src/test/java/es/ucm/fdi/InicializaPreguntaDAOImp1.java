package es.ucm.fdi;

import java.util.ArrayList;

import es.ucm.fdi.integracion.DAOs.PreguntaDAO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;

/**
 * Implementación de InicializaPreguntaDAO
 */
public class InicializaPreguntaDAOImp1 implements InicializaPreguntaDAO {

	@Override
	public void inicializa(PreguntaDAO preguntaDAO) {
		ArrayList<String> respuestas1 = new ArrayList<String>();
		respuestas1.add("Madrid");
		respuestas1.add("Paris");
		respuestas1.add("Roma");
		respuestas1.add("Londres");
		preguntaDAO.save(new PreguntaPOJO("al1",
				"cual es la capital de españa?", "geografía", respuestas1, 1));
		preguntaDAO.save(new PreguntaPOJO("al2",
				"cual es la capital de francia?", "geografía", respuestas1, 2));
		preguntaDAO.save(new PreguntaPOJO("al3",
				"cual es la capital de italia?", "geografía", respuestas1, 3));
		preguntaDAO.save(new PreguntaPOJO("al4",
				"cual es la capital de reino unido?", "geografía", respuestas1,
				4));

		ArrayList<String> respuestas2 = new ArrayList<String>();
		respuestas2.add("Wahington");
		respuestas2.add("Moscu");
		respuestas2.add("Praga");
		respuestas2.add("Berlin");
		preguntaDAO.save(new PreguntaPOJO("al5", "cual es la capital de eeuu?",
				"geografía", respuestas2, 1));
		preguntaDAO.save(new PreguntaPOJO("al6", "cual es la capital de rusia?",
				"geografía", respuestas2, 2));
		preguntaDAO.save(new PreguntaPOJO("al7",
				"cual es la capital de checoslovaquia?", "geografía",
				respuestas2, 3));
		preguntaDAO
				.save(new PreguntaPOJO("al8", "cual es la capital de alemania?",
						"geografía", respuestas2, 4));

		ArrayList<String> respuestas3 = new ArrayList<String>();
		respuestas3.add("el cairo");
		respuestas3.add("copenague");
		respuestas3.add("estocolmo");
		respuestas3.add("helsinki");
		preguntaDAO.save(new PreguntaPOJO("al9",
				"cual es la capital de egipto?", "geografía", respuestas3, 1));
		preguntaDAO
				.save(new PreguntaPOJO("al10",
						"cual es la capital de dinamarca?", "geografía",
						respuestas3, 2));
		preguntaDAO.save(new PreguntaPOJO("al11",
				"cual es la capital de suecia?", "geografía", respuestas3, 3));
		preguntaDAO
				.save(new PreguntaPOJO("al12",
						"cual es la capital de finlandia?", "geografía",
						respuestas3, 4));
		ArrayList<String> respuestas4 = new ArrayList<String>();
		respuestas4.add("Colon");
		respuestas4.add("Copernico");
		respuestas4.add("Recaredo");
		respuestas4.add("Kennedy");
		preguntaDAO.save(new PreguntaPOJO("al13", "Quien descubrio America?",
				"historia", respuestas4, 1));
		preguntaDAO.save(new PreguntaPOJO("al14",
				"Quien planteo que la tierra giraba alrededor del sol?",
				"historia", respuestas4, 2));
		preguntaDAO.save(new PreguntaPOJO("al15", "Quien fue un rey visigodo?",
				"historia", respuestas4, 3));
		preguntaDAO
				.save(new PreguntaPOJO("al16",
						"Quien fue un presidente de EEUU?", "historia",
						respuestas4, 4));

	}

}
