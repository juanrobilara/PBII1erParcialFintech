package ar.unlam.pb2;

public class Dai extends Moneda {
	private static final Double PRECIO_DAI = 50.0;

	public Dai() {
		super("DAI", PRECIO_DAI);		
	}

	@Override
	public String toString() {
		return "Dai";
	}
}
