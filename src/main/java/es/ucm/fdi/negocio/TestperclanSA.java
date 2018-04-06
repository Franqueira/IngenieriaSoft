package es.ucm.fdi.negocio;

import java.util.ArrayList;

import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public interface TestperclanSA {
	public ArrayList<UsuarioPOJO> getRanking(String nombreClan);

	public void setGanador(String nombreClan);
	
	public void eliminarUsuarioClan(String idUsuario);

	public void anadirUsuarioClan(String idUsuario,String idClan);
	
	public void crearClan(String idUsuario,String idClan);
}
