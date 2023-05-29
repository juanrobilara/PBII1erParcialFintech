package ar.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Fintech {
	private String nombre;
	private Set<Cuenta> cuentas;

	public Fintech(String nombre) {
		this.nombre = nombre;
		this.cuentas = new HashSet<Cuenta>();
	}

	
}
