package es.ucm.fdi;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;
import es.ucm.fdi.negocio.AlarmaSA;
import es.ucm.fdi.negocio.PreguntaSA;
import es.ucm.fdi.negocio.TestperclanSA;
import es.ucm.fdi.negocio.UsuarioSA;

public class FachadaUsuarioImp implements FachadaUsuario {
	private AlarmaSA alarmaSA;
	private PreguntaSA preguntaSA;
	private TestperclanSA testperclanSA;
	private UsuarioSA usuarioSA;

	public FachadaUsuarioImp(AlarmaSA alarmaSA, PreguntaSA preguntaSA,
			TestperclanSA testperclanSA, UsuarioSA usuarioSA) {
		super();
		this.alarmaSA = alarmaSA;
		this.preguntaSA = preguntaSA;
		this.testperclanSA = testperclanSA;
		this.usuarioSA = usuarioSA;
	}

	@Override
	public void AnadirAlarma(AlarmaPOJO alarma, String idUsuario) {
		alarmaSA.anadirAlarma(alarma, idUsuario);

	}

	@Override
	public void EliminarAlarma(String idAlarma) {
		alarmaSA.eliminarAlarma(idAlarma);

	}

	@Override
	public void eliminarUsuarioClan(String idUsuario) {
		testperclanSA.eliminarUsuarioClan(idUsuario);
	}

	@Override
	public void anadirUsuarioClan(String idUsuario, String idClan) {
		testperclanSA.anadirUsuarioClan(idUsuario, idClan);
	}

	@Override
	public ArrayList<String> preguntasClan(String idClan) {
		return testperclanSA.preguntasClan(idClan);
	}

	@Override
	public void crearClan(String idUsuario, String idClan) {
		testperclanSA.crearClan(idUsuario, idClan);
	}

	@Override
	public void AnadirUsuario(UsuarioPOJO usuario) {
		usuarioSA.anadirUsuario(usuario);
	}

	@Override
	public void informarRespuesta(String idUsuario, String idPregunta,
			int respuesta) {
		usuarioSA.informarRespuesta(idUsuario, idPregunta, respuesta);
	}

	@Override
	public ArrayList<String> preguntasUsuario(String usuario) {
		return usuarioSA.preguntasUsuario(usuario);
	}

	@Override
	public void eliminarUsuario(String idUsuario) {
		usuarioSA.eliminarUsuario(idUsuario);
	}

	@Override
	public void desvincularCategoria(String categoria, String idUsuario) {
		preguntaSA.desvincularCategoria(categoria, idUsuario);
	}

	@Override
	public void vincularCategoria(String categoria, String idUsuario) {
		preguntaSA.vincularCategoria(categoria, idUsuario);
	}

	@Override
	public void agregarPregunta(PreguntaPOJO pregunta, String idUsuario) {
		preguntaSA.agregarPregunta(pregunta, idUsuario);
	}

	@Override
	public void eliminarPregunta(String idPregunta, String idUsuario) {
		preguntaSA.eliminarPregunta(idPregunta, idUsuario);
	}

}
