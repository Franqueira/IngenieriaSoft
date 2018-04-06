package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.PreguntaPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public interface UsuarioSA {

	public void AnadirAlarma(AlarmaPOJO alarma, String idUsuario);

	public void EliminarAlarma(String idAlarma);

	public void AnadirUsuario(UsuarioPOJO usuario);
	
	public void EliminarUsuario(String idUsuario);
	public void ElminarPregunta(String idPregunta,String idUsuario);
	public void AnadirPregunta(PreguntaPOJO pregunta,String idUsuario);
}
