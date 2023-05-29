package ar.unlam.pb2;


public class Moneda {
    protected String nombre;
    protected double valor;
    protected double saldo;

    public Moneda(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
        this.saldo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void agregarSaldo(double cantidad) {
        saldo += cantidad;
    }

    public void restarSaldo(double cantidad) {
        saldo -= cantidad;
    }
}
	
	
	
