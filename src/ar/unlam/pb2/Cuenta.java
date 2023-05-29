package ar.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

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
        agregarMoneda(new Peso());
	}




	private void agregarMoneda(Moneda moneda) {
		saldos.put(moneda.getNombre(), moneda);
		
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



    public Boolean transferir(Cuenta cuentaDestino, String tipoMoneda, double cantidad) {
        Moneda monedaOrigen = saldos.get(tipoMoneda);
        Moneda monedaDestino = cuentaDestino.saldos.get(tipoMoneda);

        if (monedaOrigen != null && monedaDestino != null) {
            if (monedaOrigen.getSaldo() >= cantidad) {
                monedaOrigen.restarSaldo(cantidad);
                monedaDestino.agregarSaldo(cantidad);
                transacciones.add(new Transaccion(TipoTransaccion.TRANSFERENCIA, cantidad, tipoMoneda));
                return true;
            } 
        }
        return false;
    }
	
	

	@Override
	public int hashCode() {
		return Objects.hash(idCuenta);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(idCuenta, other.idCuenta);
	}
	
	
	
	
	
}
