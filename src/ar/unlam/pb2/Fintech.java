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

	

	public Integer cantidadDeCuentas() {
		return cuentas.size();
	}
	
	
	public Boolean transferir(Cuenta origen, Cuenta destino, Double monto, String moneda) {
		
		
		if(existeCuenta(origen.getIdCuenta()) && existeCuenta(destino.getIdCuenta())) {
		
			for(Cuenta cuentaOrigen : cuentas) {
				if(cuentaOrigen.getIdCuenta() == origen.getIdCuenta()) {
					for(Cuenta cuentaDestino : cuentas) {
						if(cuentaDestino.getIdCuenta() == destino.getIdCuenta()) {
							cuentaOrigen.transferir(cuentaDestino, moneda, monto);
							return true;
						}
					}
				}
			}
		
		} return false;
	}

	public Boolean depositar(Cuenta actual, Double monto) {
		if(existeCuenta(actual.getIdCuenta())) {
			for(Cuenta c : cuentas) {
				if(c.getIdCuenta() == actual.getIdCuenta()) {
					c.depositarPesos(monto);
					return true;
				}
			}
		}
		return false;
		
	}

	public Boolean extraer(Cuenta cuenta, Double monto) {
		if(existeCuenta(cuenta.getIdCuenta())) {
			for(Cuenta c : cuentas) {
				if(c.getIdCuenta() == cuenta.getIdCuenta()) {
					c.extraerPesos(monto);
					return true;
				}
			}
		}
		return false;	
	}
	

public Boolean comprarCripto(Cuenta cuenta, Double monto, String moneda) {

		if(existeCuenta(cuenta.getIdCuenta())) {
		for(Cuenta c : cuentas) {
		if(c.getIdCuenta() == cuenta.getIdCuenta()) {
		if((c.comprarCriptomonedas(moneda, monto))){
		return true;
		}
		}
		}
		}
		return false;
		}
}
