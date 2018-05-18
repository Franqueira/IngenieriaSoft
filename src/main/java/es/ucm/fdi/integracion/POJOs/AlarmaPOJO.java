package es.ucm.fdi.integracion.POJOs;

/**
 * 
 * Clase que representa una alarma en la aplicación, alamacenando informacion
 * acerca de su id (idAlarma), sus hora(horas, minutos) y el Tono que reproduce
 * cuando se activa (tono)
 *
 */
public class AlarmaPOJO extends POJO {
	private int horas;
	private int minutos;
	private boolean active;
	private String Tono;

	public AlarmaPOJO(String idAlarma, int horas, int minutos, boolean activa,
			String Tono) {
		super(idAlarma);
		if (!comprobarTiempo(horas, minutos))
			throw new IllegalArgumentException("Tiempo incorrecto");

		this.horas = horas;
		this.minutos = minutos;
		this.active = activa;
		String extension = Tono.substring(Tono.length() - 4, Tono.length()); // creo
																				// que
																				// así
																				// esta
																				// bien.
		if (!extension.equals(".mp3"))
			throw new IllegalArgumentException(
					"El tono debe tener extensión .mp3");
		this.Tono = Tono;
	}

	private boolean comprobarTiempo(int horas, int minutos) {
		return 0 <= horas && horas < 24 && 0 <= minutos && minutos < 60;
	}

	public void setTiempo(int horas, int minutos) {
		this.horas = horas;
		this.minutos = minutos;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public boolean isActive() {
		return active;
	}

	public void setActiva(boolean active) {
		this.active = active;
	}

	public String getTono() {
		return Tono;
	}

	public void setTono(String idTono) {
		this.Tono = idTono;
	}

	@Override
	public String toString() {
		return horas + ":" + minutos;
	}

	public boolean isTime(int horas, int minutos) {
		return horas == this.horas && minutos == this.minutos;
	}
}
