package es.ucm.fdi.integracion.DAOs;
import java.util.ArrayList;
import es.ucm.fdi.datos.*;
import es.ucm.fdi.integracion.POJOs.UsuarioPOJO;

/**
 * 
 * @author Javier Guzmán
 *
 */
public class UsuarioDAOImp implements UsuarioDAO{
	private BD<UsuarioPOJO> BD;

	public UsuarioDAOImp(BD<UsuarioPOJO> BD) {
		this.BD = BD;
	}
	
	public UsuarioPOJO getUsuario(String idUsuario){
		return BD.find(idUsuario);
	}
	
	public void guardaUsuario(UsuarioPOJO user){
		BD.insert(user, user.getIdUsuario());
	}
	
	public void eliminaUsuario(UsuarioPOJO user){
		BD.removeId(user.getIdUsuario());
	}
	
	public UsuarioPOJO buscaPorNombre(String nombre){
		for(String id: BD.getIds()){
			if(getUsuario(id).getNombreReal().equals(nombre)){
				return getUsuario(id);
			}
		}
		return null;
	}
	
	
	//esta funcion no creo que sea muy eficiente y tampoco sirve para mucho, la pongo por poner algo
	public ArrayList<UsuarioPOJO> getUsersByCountry(String country){
		ArrayList<UsuarioPOJO> lista = new ArrayList<UsuarioPOJO>();
		for(String id: BD.getIds()){
			UsuarioPOJO user = getUsuario(id);
			if(user.getCountry().equals(country)){
				lista.add(user);
			}
		}
		return lista;
	}
	
	
	
}
