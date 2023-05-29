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

	public Boolean existeCuenta(Integer idCuenta) {
		for(Cuenta c : cuentas) {
			if(c.getIdCuenta() == idCuenta) {
				return true;
			}
		}
		return false;
	}

	public Boolean agregarCuenta(Cuenta nuevo) {
		if(cuentas.contains(nuevo)) {
			return false;
		} else {
			cuentas.add(nuevo);
			return true;
		}		
	}
	
	public void borrarCuenta(Cuenta eliminada) {
		
		cuentas.remove(eliminada);
		
	}
	
	public Cuenta buscarCuenta(Integer idCuenta) {
		
		
		for (Cuenta c : cuentas) {
			if(c.getIdCuenta().equals(idCuenta)) {
				return c;
			}
		}
		return null;
	}
	
}
