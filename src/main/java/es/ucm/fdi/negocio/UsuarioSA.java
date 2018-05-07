package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public interface UsuarioSA {

	public void AnadirAlarma(AlarmaPOJO alarma, String idUsuario);

	public void EliminarAlarma(String idAlarma);

	public void AnadirUsuario(UsuarioPOJO usuario);
	
	public void EliminarUsuario(String idUsuario);
}
