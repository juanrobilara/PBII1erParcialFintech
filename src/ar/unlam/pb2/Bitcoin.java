package ar.unlam.pb2;

public class Bitcoin extends Moneda {
	private static final Double PRECIO_BITCOIN = 200.0;


	public Bitcoin() {
		super("Bitcoin", PRECIO_BITCOIN);		
	}


	@Override
	public String toString() {
		return "Bitcoin";
	}
}
