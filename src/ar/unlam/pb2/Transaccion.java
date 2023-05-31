package ar.unlam.pb2;

public class Transaccion {
	private TipoTransaccion motivo;
	private Double monto;
	private String moneda;

	public Transaccion(TipoTransaccion motivo, Double monto, String moneda) {
		this.motivo = motivo;
		this.monto = monto;
		this.moneda = moneda;
	}

	public TipoTransaccion getMotivo() {
		return motivo;
	}

	public void setMotivo(TipoTransaccion motivo) {
		this.motivo = motivo;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@Override
	public String toString() {
		return "[motivo= " + motivo + ", monto= " + monto + ", moneda= " + moneda + "]";
	}

}