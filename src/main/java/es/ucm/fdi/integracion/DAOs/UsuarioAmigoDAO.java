package es.ucm.fdi.integracion.DAOs;

import java.util.ArrayList;

import es.ucm.fdi.datos.BD;
import es.ucm.fdi.integracion.POJOs.UsuarioAmigoPOJO;

public interface UsuarioAmigoDAO{
	
public String getPrincipal(String id);
	
	public String getSecundario(String id);
	
	public ArrayList<String> getAmigos(String user);
	
	public boolean sonAmigos(String a, String b);
	
	public void guardaUsuarioAmigo(UsuarioAmigoPOJO uamigo);
	
	public void eliminaUsuarioAmigo(UsuarioAmigoPOJO uamigo);

}
