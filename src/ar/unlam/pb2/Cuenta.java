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
		agregarMoneda(new Bitcoin());
		agregarMoneda(new Ethereum());
		agregarMoneda(new Dai());
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

	public Boolean depositarPesos(Double monto) {
		Moneda peso = saldos.get("Peso");

		if (peso != null) {
			peso.agregarSaldo(monto);
			transacciones.add(new Transaccion(TipoTransaccion.DEPOSITO, monto, peso.toString()));
			return true;
		}
		return false;

	}

	public Double obtenerSaldo(String tipoMoneda) {
		Moneda moneda = saldos.get(tipoMoneda);
		if (moneda != null) {
			return moneda.getSaldo();
		} else {

			return -1.0;
		}
	}

	public Boolean extraerPesos(Double monto) {
		Moneda peso = saldos.get("Peso");

		if (peso != null) {
			if (peso.getSaldo() >= monto) {
				peso.restarSaldo(monto);
				transacciones.add(new Transaccion(TipoTransaccion.EXTRACCION, monto, peso.toString()));
				return true;
			}
		}
		return false;

	}

	public Boolean comprarCriptomonedas(String criptomoneda, double cantidad) {
		Moneda peso = saldos.get("Peso");
		Moneda monedaCriptomoneda = saldos.get(criptomoneda);

		if (peso != null && monedaCriptomoneda != null) {
			double costoCriptomoneda = cantidad * monedaCriptomoneda.getValor();
			if (peso.getSaldo() >= costoCriptomoneda) {
				peso.restarSaldo(costoCriptomoneda);
				monedaCriptomoneda.agregarSaldo(cantidad);
				transacciones.add(new Transaccion(TipoTransaccion.COMPRA, cantidad, criptomoneda));
				return true;
			}
		}
		return false;
	}

	public void enviarSolicitudDeAmistad(Cuenta cuentaAmigo) {
		cuentaAmigo.solicitudesDeAmistad.add(this);
	}

	public void recibirSolicitudDeAmistad(Cuenta cuentaSolicitante) {
		solicitudesDeAmistad.add(cuentaSolicitante);
	}

	public Boolean aceptarSolicitudDeAmistad(Cuenta cuentaAmigo) {
		if (solicitudesDeAmistad.contains(cuentaAmigo)) {
			listaDeUsuariosAmigos.add(cuentaAmigo);
			cuentaAmigo.listaDeUsuariosAmigos.add(this);
			solicitudesDeAmistad.remove(cuentaAmigo);
			cuentaAmigo.solicitudesDeAmistad.remove(this);
			return true;
		}
		return false;
	}

	public Boolean denegarSolicitudDeAmistad(Cuenta cuentaAmigo) {
		if (solicitudesDeAmistad.contains(cuentaAmigo)) {
			solicitudesDeAmistad.remove(cuentaAmigo);
			cuentaAmigo.solicitudesDeAmistad.remove(this);
			return true;
		}

		return false;
	}

	public void eliminarAmigo(Cuenta amigo) {
		listaDeUsuariosAmigos.remove(amigo);
		amigo.listaDeUsuariosAmigos.remove(this);
	}

	public Integer cantidadDeAmigos() {
		return listaDeUsuariosAmigos.size();
	}

	public String mostrarTransacciones() {
		return "Transacciones Del usuario " + this.getTitular().getUsuario() + ": \n" + transacciones.toString() + "\n";
	}

	public Integer cantidadTransacciones() {
		return transacciones.size();
	}

	public Transaccion obtenerUltimaTransaccion() {
		if (transacciones.isEmpty()) {
			return null;
		}

		Integer ultimaPosicion = transacciones.size() - 1;
		return transacciones.get(ultimaPosicion);
	}

	public ArrayList<Cuenta> obtenerAmigos() {
		return new ArrayList<>(listaDeUsuariosAmigos);
	}

}
