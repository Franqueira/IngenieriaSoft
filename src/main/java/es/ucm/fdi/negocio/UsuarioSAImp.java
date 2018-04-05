package es.ucm.fdi.negocio;

import es.ucm.fdi.integracion.DAOs.UsuarioDAOImp;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

public class UsuarioSAImp implements UsuarioSA{
	public UsuarioDAOImp usuario;
	
	@Override
	public boolean EliminarUsuarioClan(String idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AnadirUsuarioClan(String idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void AnadirAlarma(String idAlarma, int horas, int minutos,
			boolean active, String Tono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarAlarma(String idAlarma) {
		// TODO Auto-generated method stub
		
	}

}
