package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.POJOs.AlarmaPOJO;

public interface UsuarioSA {

	public void AnadirAlarma(AlarmaPOJO alarma, String idUsuario);

	public void EliminarAlarma(String idAlarma);

	public void AnadirUsuario(String idUsuario, String nombreReal,
			int puntuacion, String descPerfil, String password, String country);
	
	public void EliminarUsuario(String idUsuario);

}
