import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ar.unlam.pb2.Cuenta;
import ar.unlam.pb2.Fintech;
import ar.unlam.pb2.TipoTransaccion;
import ar.unlam.pb2.Titular;

public class FintechTest {

	Fintech nuevaApp = new Fintech("Bitso");

	@Test
	public void queSePuedaCrearUnaCuenta() {
		// CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;

		Titular mario = new Titular(usuario, nombre, apellido, dni);

		// CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;

		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// EJECUCI�N
		assertNotNull(cuentaDeMario);
	}

	@Test
	public void queNoSePuedanCrearCuentasRepetidas() {
		// CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;

		Titular mario = new Titular(usuario, nombre, apellido, dni);

		// CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;

		// CAMPOS CREACION CUENTA 2;
		Integer idDos = 1;
		Long cvuDos = 10987654321L;

		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);
		Cuenta cuentaCopionaDeMario = new Cuenta(idDos, cvuDos, mario);

		// AGREGO CUENTAS
		nuevaApp.agregarCuenta(cuentaDeMario);
		nuevaApp.agregarCuenta(cuentaCopionaDeMario);

		// EJECUCI�N
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevaApp.cantidadDeCuentas();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void queSePuedaTransferirEnPesos() {
		// CAMPOS CREACION TITULARES
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;

		String usuario2 = "pedrito27";
		String nombre2 = "Pedro";
		String apellido2 = "Perez";
		Integer dni2 = 44444444;

		Titular mario = new Titular(usuario, nombre, apellido, dni);
		Titular pedro = new Titular(usuario2, nombre2, apellido2, dni2);

		// CAMPOS CREACION CUENTA 1
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// CAMPOS CREACION CUENTA 2;
		Integer idDos = 2;
		Long cvuDos = 10987654321L;
		Cuenta cuentaDePedro = new Cuenta(idDos, cvuDos, pedro);

		// A�ADO USUARIOS A LA FINTECH
		nuevaApp.agregarCuenta(cuentaDePedro);
		nuevaApp.agregarCuenta(cuentaDeMario);

		// MONEDA A UTILIZAR
		String peso = "Peso";

		// DEPOSITO PESOS Y TRANSFIERO A OTRA CUENTA
		nuevaApp.depositar(cuentaDeMario, 300.0);
		nuevaApp.transferir(cuentaDeMario, cuentaDePedro, 250.0, peso);

		Double valorEsperado = 250.0;
		Double valorObtenido = cuentaDePedro.obtenerSaldo(peso);

		Double valorEsperadoMario = 50.0;
		Double valorObtenidoMario = cuentaDeMario.obtenerSaldo(peso);

		// EJECUCION: VERIFICO QUE PEDRO TENGA 250 PESOS
		assertEquals(valorEsperado, valorObtenido);

		// EJECUCION DOS (OPCIONAL): VERIFICO QUE MARIO TENGA 50 PESOS
		assertEquals(valorEsperadoMario, valorObtenidoMario);
	}

	@Test
	public void queSePuedaComprarBitcoinsA_200_Pesos() {
		// CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
		Titular mario = new Titular(usuario, nombre, apellido, dni);

		// CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// PREPARACION
		String bitcoin = "Bitcoin";
		String peso = "Peso";
		nuevaApp.agregarCuenta(cuentaDeMario);
		nuevaApp.depositar(cuentaDeMario, 10000.0);
		nuevaApp.comprarCripto(cuentaDeMario, 50.0, bitcoin);

		Double valorEsperado = 50.0;
		Double valorObtenido = cuentaDeMario.obtenerSaldo(bitcoin);
		// EJECUCION
		assertEquals(valorEsperado, valorObtenido);
		// EJECUCION DOS (OPCIONAL): VERIFICO QUE MARIO TENGA 0 PESOS
		assertEquals(0.0, cuentaDeMario.obtenerSaldo(peso), 0.01);

	}

	@Test
	public void queSePuedaComprarEthereumA_100_Pesos() {
		// CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
		Titular mario = new Titular(usuario, nombre, apellido, dni);

		// CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// PREPARACION
		String ethereum = "Ethereum";
		String peso = "Peso";

		nuevaApp.agregarCuenta(cuentaDeMario);
		nuevaApp.depositar(cuentaDeMario, 10000.0);
		nuevaApp.comprarCripto(cuentaDeMario, 100.0, ethereum);

		Double valorEsperado = 100.0;
		Double valorObtenido = cuentaDeMario.obtenerSaldo(ethereum);
		// EJECUCION
		assertEquals(valorEsperado, valorObtenido);

		// EJECUCION DOS (OPCIONAL): VERIFICO QUE MARIO TENGA 0 PESOS
		assertEquals(0.0, cuentaDeMario.obtenerSaldo(peso), 0.01);
	}

	@Test
	public void queSePuedaComprarDaiA_50_Pesos() {
		// CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
		Titular mario = new Titular(usuario, nombre, apellido, dni);

		// CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// PREPARACION
		String dai = "DAI";
		String peso = "Peso";

		nuevaApp.agregarCuenta(cuentaDeMario);
		nuevaApp.depositar(cuentaDeMario, 10000.0);
		nuevaApp.comprarCripto(cuentaDeMario, 200.0, dai);

		Double valorEsperado = 200.0;
		Double valorObtenido = cuentaDeMario.obtenerSaldo(dai);
		// EJECUCION
		assertEquals(valorEsperado, valorObtenido);

		// EJECUCION DOS (OPCIONAL): VERIFICO QUE MARIO TENGA 0 PESOS
		assertEquals(0.0, cuentaDeMario.obtenerSaldo(peso), 0.01);
	}

	@Test
	public void queSePuedaTenerDivididoElSaldoEnPesosYEnCripto() {
		// CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
		Titular mario = new Titular(usuario, nombre, apellido, dni);

		// CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// PREPARACION
		String peso = "Peso";
		String dai = "DAI";
		// String ethereum = "Ethereum";
		String bitcoin = "Bitcoin";

		nuevaApp.agregarCuenta(cuentaDeMario);
		nuevaApp.depositar(cuentaDeMario, 100000.0);

		nuevaApp.comprarCripto(cuentaDeMario, 200.0, dai);
		nuevaApp.comprarCripto(cuentaDeMario, 200.0, bitcoin);

		Double valorEsperadoBitcoin = 200.0;
		Double valorObtenidoBitcoin = cuentaDeMario.obtenerSaldo(bitcoin);

		Double valorEsperadoDAI = 200.0;
		Double valorObtenidoDAI = cuentaDeMario.obtenerSaldo(dai);

		Double valorEsperadoPeso = 50000.0;
		Double valorObtenidoPeso = cuentaDeMario.obtenerSaldo(peso);
		// EJECUCION: Verificar que se hayan podido comprar correctamente las dos
		// criptos
		// y asegurarse de que hayan quedado los pesos correspondientes
		assertEquals(valorEsperadoBitcoin, valorObtenidoBitcoin);
		assertEquals(valorEsperadoDAI, valorObtenidoDAI);
		assertEquals(valorEsperadoPeso, valorObtenidoPeso);

	}

	@Test
	public void queSePuedaRetirarPesos() {
		// CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;

		Titular mario = new Titular(usuario, nombre, apellido, dni);

		// CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// A�ADO USUARIO A LA FINTECH
		nuevaApp.agregarCuenta(cuentaDeMario);

		String peso = "Peso";

		nuevaApp.depositar(cuentaDeMario, 3500.0);
		nuevaApp.extraer(cuentaDeMario, 2500.0);

		Double valorObtenido = cuentaDeMario.obtenerSaldo(peso);
		Double valorEsperado = 1000.0;
		// EJECUCION
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaAceptarUnaSolicitudDeAmistad() {

		// CAMPOS CREACION TITULARES
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
		String usuario2 = "pedrito27";
		String nombre2 = "Pedro";
		String apellido2 = "Perez";
		Integer dni2 = 44444444;
		Titular mario = new Titular(usuario, nombre, apellido, dni);
		Titular pedro = new Titular(usuario2, nombre2, apellido2, dni2);

		// CAMPOS CREACION CUENTA 1
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// CAMPOS CREACION CUENTA 2;
		Integer idDos = 2;
		Long cvuDos = 10987654321L;
		Cuenta cuentaDePedro = new Cuenta(idDos, cvuDos, pedro);

		// AÑADO USUARIOS A LA FINTECH
		nuevaApp.agregarCuenta(cuentaDePedro);
		nuevaApp.agregarCuenta(cuentaDeMario);

		nuevaApp.enviarSolicitudDeAmistad(cuentaDeMario, cuentaDePedro);

		cuentaDePedro.aceptarSolicitudDeAmistad(cuentaDeMario);

		Integer valorEsperado = 1;

		// EJECUCION
		assertEquals(valorEsperado, cuentaDeMario.cantidadDeAmigos());
		assertEquals(valorEsperado, cuentaDePedro.cantidadDeAmigos());

	}

	@Test
	public void queSePuedaDenegarUnaSolicitudDeAmistad() {

		// CAMPOS CREACION TITULARES
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
		String usuario2 = "pedrito27";
		String nombre2 = "Pedro";
		String apellido2 = "Perez";
		Integer dni2 = 44444444;

		Titular mario = new Titular(usuario, nombre, apellido, dni);
		Titular pedro = new Titular(usuario2, nombre2, apellido2, dni2);

		// CAMPOS CREACION CUENTA 1
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// CAMPOS CREACION CUENTA 2;
		Integer idDos = 2;
		Long cvuDos = 10987654321L;
		Cuenta cuentaDePedro = new Cuenta(idDos, cvuDos, pedro);

		// AÑADO USUARIOS A LA FINTECH
		nuevaApp.agregarCuenta(cuentaDePedro);
		nuevaApp.agregarCuenta(cuentaDeMario);

		nuevaApp.enviarSolicitudDeAmistad(cuentaDeMario, cuentaDePedro);
		cuentaDePedro.denegarSolicitudDeAmistad(cuentaDeMario);

		Integer valorEsperado = 0;

		assertEquals(valorEsperado, cuentaDeMario.cantidadDeAmigos());
	}

	@Test
	public void queSePuedaRegistrarLasTransaccionesHechas() {

		// CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;

		Titular mario = new Titular(usuario, nombre, apellido, dni);

		String usuario2 = "pedrito27";
		String nombre2 = "Pedro";
		String apellido2 = "Perez";
		Integer dni2 = 44444444;

		Titular pedro = new Titular(usuario2, nombre2, apellido2, dni2);
		// CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		Integer id2 = 2;
		Long cvu2 = 12345678910L;
		Cuenta cuentaDePedro = new Cuenta(id2, cvu2, pedro);

		// PREPARACION
		String peso = "Peso";
		String dai = "DAI";
		String bitcoin = "Bitcoin";
		nuevaApp.agregarCuenta(cuentaDeMario);
		nuevaApp.agregarCuenta(cuentaDePedro);

		// Verificar que la transacción no sea nula
		assertNotNull(nuevaApp.depositar(cuentaDeMario, 100000.0));

		// Compro DAI
		nuevaApp.comprarCripto(cuentaDeMario, 200.0, dai);
		Double valorObtenidoCompra = cuentaDeMario.obtenerUltimaTransaccion().getMonto();
		assertEquals(200.0, valorObtenidoCompra, 0.001);

		// Transfiero pesos
		nuevaApp.transferir(cuentaDeMario, cuentaDePedro, 5000.0, peso);
		TipoTransaccion valorObtenidoMotivo = cuentaDeMario.obtenerUltimaTransaccion().getMotivo();
		assertEquals(TipoTransaccion.TRANSFERENCIA, valorObtenidoMotivo);

	}

	@Test
	public void queNoSePuedaRetirarSaldoNegativo() {
		// CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;

		Titular mario = new Titular(usuario, nombre, apellido, dni);

		// CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		// AÑADO USUARIO A LA FINTECH
		nuevaApp.agregarCuenta(cuentaDeMario);

		nuevaApp.depositar(cuentaDeMario, 3500.0);

		// EJECUCION
		assertFalse(cuentaDeMario.extraerPesos(3600.0));
	}

	@Test
	public void queSePuedanListarLosAmigosDeUnaCuenta() {
		
		//CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
		Titular mario = new Titular(usuario, nombre, apellido, dni);

		String usuario2 = "pedrito27";
		String nombre2 = "Pedro";
		String apellido2 = "Perez";
		Integer dni2 = 44444444;
		Titular pedro = new Titular(usuario2, nombre2, apellido2, dni2);

		String usuario3 = "Huguete77";
		String nombre3 = "Huguito";
		String apellido3 = "Flores";
		Integer dni3 = 55555555;
		Titular hugo = new Titular(usuario3, nombre3, apellido3, dni3);
		//CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

		Integer id2 = 2;
		Long cvu2 = 12345678910L;
		Cuenta cuentaDePedro = new Cuenta(id2, cvu2, pedro);

		Integer id3 = 3;
		Long cvu3 = 1000000000L;
		Cuenta cuentaDeHugo = new Cuenta(id3, cvu3, hugo);

		nuevaApp.agregarCuenta(cuentaDeMario);
		nuevaApp.agregarCuenta(cuentaDePedro);
		nuevaApp.agregarCuenta(cuentaDeHugo);

		cuentaDeMario.enviarSolicitudDeAmistad(cuentaDePedro);
		cuentaDeMario.enviarSolicitudDeAmistad(cuentaDeHugo);

		cuentaDePedro.aceptarSolicitudDeAmistad(cuentaDeMario);
		cuentaDeHugo.aceptarSolicitudDeAmistad(cuentaDeMario);

		ArrayList<Cuenta> amigosEsperados = new ArrayList<>();
		amigosEsperados.add(cuentaDePedro);
		amigosEsperados.add(cuentaDeHugo);

		assertEquals(amigosEsperados, cuentaDeMario.obtenerAmigos());
		
	}

}
