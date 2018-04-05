package es.ucm.fdi.negocio;

public interface UsuarioSA {

	public boolean EliminarUsuarioClan(String idUsuario);

	public boolean AnadirUsuarioClan(String idUsuario);

	public void AnadirAlarma(String idAlarma, int horas, int minutos,
			boolean active, String Tono);

	public void EliminarAlarma(String idAlarma);
	
}
