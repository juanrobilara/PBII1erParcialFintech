package ar.unlam.pb2;

public class Ethereum extends Moneda {
	private static final Double PRECIO_ETHEREUM = 100.0;

	public Ethereum() {
		super("Ethereum", PRECIO_ETHEREUM);		
	}

	@Override
	public String toString() {
		return "Ethereum";
	}
}
