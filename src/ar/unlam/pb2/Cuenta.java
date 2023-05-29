package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Cuenta {

	private Integer idCuenta;
	protected Titular titular; 
	private Long cvu;
    private Map<String, Moneda> saldos;
	private ArrayList<Cuenta> listaDeUsuariosAmigos;
	private HashSet<Cuenta> solicitudesDeAmistad;
	private ArrayList<Transaccion> transacciones;



	
	public Cuenta(Integer idCuenta, Long cvu, Titular titular) {
		
		this.idCuenta = idCuenta;
		this.titular = titular;
		this.cvu = cvu;
		this.listaDeUsuariosAmigos = new ArrayList<Cuenta>();
		this.solicitudesDeAmistad = new HashSet<Cuenta>();
		this.transacciones = new ArrayList<Transaccion>();
        this.saldos = new HashMap<>();
        
	}




	public Integer getIdCuenta() {
		return idCuenta;
	}




	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}




	public Titular getTitular() {
		return titular;
	}




	public void setTitular(Titular titular) {
		this.titular = titular;
	}



	public Long getCvu() {
		return cvu;
	}


	public void setCvu(Long cvu) {
		this.cvu = cvu;
	}
	
	
	
}
