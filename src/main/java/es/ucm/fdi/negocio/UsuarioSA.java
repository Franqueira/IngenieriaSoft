package es.ucm.fdi.negocio;

public interface UsuarioSA {

	public void EliminarUsuarioClan(String idUsuario);

	public void AnadirUsuarioClan(String idUsuario,String idClan);

	public void AnadirAlarma(String idAlarma, int horas, int minutos,
			boolean active, String Tono,String idUsuario);

	public void EliminarAlarma(String idAlarma);

	public void AnadirUsuario(String idUsuario, String nombreReal,
			int puntuacion, String descPerfil, String password, String country);
	public void EliminarUsuario(String idUsuario);
	public void CrearClan(String idUsuario,String idClan);

}
