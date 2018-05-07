package es.ucm.fdi.integracion.POJOs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class POJO {

	protected String id;

	public POJO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public POJO clone() {
		Object clonedObj = null;
	    try {
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      ObjectOutputStream oos = new ObjectOutputStream(baos);
	      oos.writeObject(this);
	      oos.close();

	      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	      ObjectInputStream ois = new ObjectInputStream(bais);
	      clonedObj = ois.readObject();
	      ois.close();
	    } catch (Exception cnfe) {
	      System.out.println("Class not found " + cnfe);
	    }
	    return (POJO) clonedObj;
	}

}
