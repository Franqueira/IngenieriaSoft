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
		alarmaSA.AnadirAlarma(alarma, idUsuario);

	}

	@Override
	public void EliminarAlarma(String idAlarma) {
		alarmaSA.EliminarAlarma(idAlarma);

	}

	@Override
	public void eliminarUsuarioClan(String idUsuario) {
		// TODO Auto-generated method stub
		testperclanSA.eliminarUsuarioClan(idUsuario);
	}

	@Override
	public void anadirUsuarioClan(String idUsuario, String idClan) {
		// TODO Auto-generated method stub
		testperclanSA.anadirUsuarioClan(idUsuario, idClan);
	}

	@Override
	public ArrayList<String> preguntasClan(String idClan) {
		// TODO Auto-generated method stub
		return testperclanSA.preguntasClan(idClan);
	}

	@Override
	public void crearClan(String idUsuario, String idClan) {
		// TODO Auto-generated method stub
		testperclanSA.crearClan(idUsuario, idClan);
	}

	@Override
	public void AnadirUsuario(UsuarioPOJO usuario) {
		// TODO Auto-generated method stub
		usuarioSA.anadirUsuario(usuario);
	}

	@Override
	public void informarRespuesta(String idUsuario, String idPregunta,
			int respuesta) {
		// TODO Auto-generated method stub
		usuarioSA.informarRespuesta(idUsuario, idPregunta, respuesta);
	}

	@Override
	public ArrayList<String> preguntasUsuario(String usuario) {
		// TODO Auto-generated method stub
		return usuarioSA.preguntasUsuario(usuario);
	}

	@Override
	public void eliminarUsuario(String idUsuario) {
		// TODO Auto-generated method stub
		usuarioSA.eliminarUsuario(idUsuario);
	}

	@Override
	public void desvincularCategoria(String categoria, String idUsuario) {
		// TODO Auto-generated method stub
		preguntaSA.desvincularCategoria(categoria, idUsuario);
	}

	@Override
	public void vincularCategoria(String categoria, String idUsuario) {
		// TODO Auto-generated method stub
		preguntaSA.vincularCategoria(categoria, idUsuario);
	}

	@Override
	public void agregarPregunta(PreguntaPOJO pregunta, String idUsuario) {
		// TODO Auto-generated method stub
		preguntaSA.agregarPregunta(pregunta, idUsuario);
	}

	@Override
	public void eliminarPregunta(String idPregunta, String idUsuario) {
		// TODO Auto-generated method stub
		preguntaSA.eliminarPregunta(idPregunta, idUsuario);
	}

}
