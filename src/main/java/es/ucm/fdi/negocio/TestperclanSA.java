package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public interface TestperclanSA {
	public ArrayList<UsuarioPOJO> getRanking(String nombreClan);

	public void setGanador(String nombreClan);
	
	public void EliminarUsuarioClan(String idUsuario);

	public void AnadirUsuarioClan(String idUsuario,String idClan);
	
	public void CrearClan(String idUsuario,String idClan);
}
