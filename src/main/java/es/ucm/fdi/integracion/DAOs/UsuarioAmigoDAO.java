package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.datos.BD;
import es.ucm.fdi.integracion.POJOs.UsuarioAmigoPOJO;

public class UsuarioAmigoDAO implements UsuarioAmigoDAOInt {
	
	private BD<UsuarioAmigoPOJO> amigos;
	// cada pareja de amigos solo aparece una vez
	// el ID de cada pareja es la suma de los ID de cada usuario
	
	public UsuarioAmigoDAO(BD<UsuarioAmigoPOJO> amigos) {
		super();
		this.amigos = amigos;
	}
	
	public String getPrincipal(String id){
		return amigos.find(id).getIdUsuarioPrincipal();
	}
	
	public String getSecundario(String id){
		return amigos.find(id).getIdUsuarioAmigo();
	}
	
	public ArrayList<String> getAmigos(String user){
		ArrayList<String> amigosUsuario = new ArrayList<String>();
		for(String id : amigos.getIds()){
			if(id.substring(0, user.length() - 1) == user) 
				amigosUsuario.add(getSecundario(id));
			if(id.substring(id.length() - user.length(), id.length() - 1) == user)
				amigosUsuario.add(getPrincipal(id));
		}
		return amigosUsuario;
	}
	
	public boolean sonAmigos(String a, String b){
		return (amigos.getIds().contains(a + b) || amigos.getIds().contains(b + a));
	}
	
	public void guardaUsuarioAmigo(UsuarioAmigoPOJO uamigo){
		amigos.insert(uamigo, uamigo.getIdUsuarioPrincipal() + uamigo.getIdUsuarioAmigo());
	}
	
	public void eliminaUsuarioAmigo(UsuarioAmigoPOJO uamigo){
		amigos.removeId(uamigo.getIdUsuarioPrincipal() + uamigo.getIdUsuarioAmigo());
	}

}
