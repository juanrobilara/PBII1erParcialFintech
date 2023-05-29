package ar.unlam.pb2;

import java.util.Objects;

public class Titular {

	private String usuario;
	private String nombre;
	private String apellido;
	private Integer dni;
	
	public Titular(String usuario, String nombre, String apellido, Integer dni) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titular other = (Titular) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(usuario, other.usuario);
	}
	


	
	
	
	
}
