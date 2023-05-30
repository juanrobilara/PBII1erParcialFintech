import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ar.unlam.pb2.Cuenta;
import ar.unlam.pb2.Fintech;
import ar.unlam.pb2.Titular;

public class FintechTest {
	
	Fintech nuevaApp = new Fintech("Bitso");

	@Test
	public void queSePuedaCrearUnaCuenta() {
		//CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
		
		Titular mario = new Titular(usuario, nombre, apellido, dni);
		
		//CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
		
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);
		
		//EJECUCI�N
		assertNotNull(cuentaDeMario);
	}
	
	@Test
	public void queNoSePuedanCrearCuentasRepetidas() {
		//CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
			
		Titular mario = new Titular(usuario, nombre, apellido, dni);
			
		//CAMPOS CREACION CUENTA
		Integer id = 1;
		Long cvu = 12345678910L;
			
		//CAMPOS CREACION CUENTA 2;
		Integer idDos = 1;
		Long cvuDos = 10987654321L;
		
			
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);
		Cuenta cuentaCopionaDeMario = new Cuenta(idDos, cvuDos, mario);
			
		//AGREGO CUENTAS
		nuevaApp.agregarCuenta(cuentaDeMario);
		nuevaApp.agregarCuenta(cuentaCopionaDeMario);
			
		//EJECUCI�N
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevaApp.cantidadDeCuentas();
			
		assertEquals(valorEsperado, valorObtenido);

	}
	
	@Test
	public void queSePuedaTransferirEnPesos() {
		//CAMPOS CREACION TITULARES
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
		
		//CAMPOS CREACION CUENTA 1
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);
		
		//CAMPOS CREACION CUENTA 2;
		Integer idDos = 2;
		Long cvuDos = 10987654321L;
		Cuenta cuentaDePedro = new Cuenta(idDos, cvuDos, pedro);
		
		//A�ADO USUARIOS A LA FINTECH
		nuevaApp.agregarCuenta(cuentaDePedro);
		nuevaApp.agregarCuenta(cuentaDeMario);
		
		//MONEDA A UTILIZAR
		String peso = "Peso";
	
		//DEPOSITO PESOS Y TRANSFIERO A OTRA CUENTA
		nuevaApp.depositar(cuentaDeMario, 300.0);
		nuevaApp.transferir(cuentaDeMario, cuentaDePedro, 250.0, peso);
		
		Double valorEsperado = 250.0;
		Double valorObtenido = cuentaDePedro.obtenerSaldo(peso);
		
		Double valorEsperadoMario = 50.0;
		Double valorObtenidoMario = cuentaDeMario.obtenerSaldo(peso);
		
		
		//EJECUCION: VERIFICO QUE PEDRO TENGA 250 PESOS
		assertEquals(valorEsperado, valorObtenido);
		
		//EJECUCION DOS (OPCIONAL): VERIFICO QUE MARIO TENGA 50 PESOS
		assertEquals(valorEsperadoMario, valorObtenidoMario);
	}
	
	@Test
	public void queSePuedaComprarBitcoinsA_200_Pesos() {
		//CAMPOS CREACION TITULAR
				String usuario = "marito27";
				String nombre = "Mario";
				String apellido = "Gomez";
				Integer dni = 33333333;
				Titular mario = new Titular(usuario, nombre, apellido, dni);

				//CAMPOS CREACION CUENTA
				Integer id = 1;
				Long cvu = 12345678910L;
				Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

				//PREPARACION
				String bitcoin = "Bitcoin";
				String peso = "Peso";
				nuevaApp.agregarCuenta(cuentaDeMario);
				nuevaApp.depositar(cuentaDeMario, 10000.0);
				nuevaApp.comprarCripto(cuentaDeMario, 50.0, bitcoin);

				Double valorEsperado = 50.0;
				Double valorObtenido = cuentaDeMario.obtenerSaldo(bitcoin);
				//EJECUCION
				assertEquals(valorEsperado, valorObtenido);
				//EJECUCION DOS (OPCIONAL): VERIFICO QUE MARIO TENGA 0 PESOS
				assertEquals(0.0, cuentaDeMario.obtenerSaldo(peso), 0.01);
				
	}
	
	@Test
	public void queSePuedaComprarEthereumA_100_Pesos() {
		//CAMPOS CREACION TITULAR
				String usuario = "marito27";
				String nombre = "Mario";
				String apellido = "Gomez";
				Integer dni = 33333333;
				Titular mario = new Titular(usuario, nombre, apellido, dni);

				//CAMPOS CREACION CUENTA
				Integer id = 1;
				Long cvu = 12345678910L;
				Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

				//PREPARACION
				String ethereum = "Ethereum";
				String peso = "Peso";

				nuevaApp.agregarCuenta(cuentaDeMario);
				nuevaApp.depositar(cuentaDeMario, 10000.0);
				nuevaApp.comprarCripto(cuentaDeMario, 100.0, ethereum);

				Double valorEsperado = 100.0;
				Double valorObtenido = cuentaDeMario.obtenerSaldo(ethereum);
				//EJECUCION
				assertEquals(valorEsperado, valorObtenido);

				//EJECUCION DOS (OPCIONAL): VERIFICO QUE MARIO TENGA 0 PESOS
				assertEquals(0.0, cuentaDeMario.obtenerSaldo(peso), 0.01);
	}
	
	@Test
	public void queSePuedaComprarDaiA_50_Pesos() {
		//CAMPOS CREACION TITULAR
				String usuario = "marito27";
				String nombre = "Mario";
				String apellido = "Gomez";
				Integer dni = 33333333;
				Titular mario = new Titular(usuario, nombre, apellido, dni);

				//CAMPOS CREACION CUENTA
				Integer id = 1;
				Long cvu = 12345678910L;
				Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);

				//PREPARACION
				String dai = "DAI";
				String peso = "Peso";

				nuevaApp.agregarCuenta(cuentaDeMario);
				nuevaApp.depositar(cuentaDeMario, 10000.0);
				nuevaApp.comprarCripto(cuentaDeMario, 200.0, dai);

				Double valorEsperado = 200.0;
				Double valorObtenido = cuentaDeMario.obtenerSaldo(dai);
				//EJECUCION
				assertEquals(valorEsperado, valorObtenido);

				//EJECUCION DOS (OPCIONAL): VERIFICO QUE MARIO TENGA 0 PESOS
				assertEquals(0.0, cuentaDeMario.obtenerSaldo(peso), 0.01);
	}
	
	@Test
	public void queSePuedaTenerDivididoElSaldoEnPesosYEnCripto() {
		//CAMPOS CREACION TITULAR
				String usuario = "marito27";
				String nombre = "Mario";
				String apellido = "Gomez";
				Integer dni = 33333333;		
				Titular mario = new Titular(usuario, nombre, apellido, dni);
					
				//CAMPOS CREACION CUENTA
				Integer id = 1;
				Long cvu = 12345678910L;		
				Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);
					
				//PREPARACION
				String peso = "Peso";
				String dai = "DAI";
				//String ethereum = "Ethereum";
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
				//EJECUCION: Verificar que se hayan podido comprar correctamente las dos criptos
				//y asegurarse de que hayan quedado los pesos correspondientes
				assertEquals(valorEsperadoBitcoin, valorObtenidoBitcoin);		
				assertEquals(valorEsperadoDAI, valorObtenidoDAI);
				assertEquals(valorEsperadoPeso, valorObtenidoPeso);

		
	}
	
	
	@Test
	public void queSePuedaRetirarPesos() {
		//CAMPOS CREACION TITULAR
		String usuario = "marito27";
		String nombre = "Mario";
		String apellido = "Gomez";
		Integer dni = 33333333;
		
	
		Titular mario = new Titular(usuario, nombre, apellido, dni);

		
		//CAMPOS CREACION CUENTA 
		Integer id = 1;
		Long cvu = 12345678910L;
		Cuenta cuentaDeMario = new Cuenta(id, cvu, mario);
		
		
		//A�ADO USUARIO A LA FINTECH
		nuevaApp.agregarCuenta(cuentaDeMario);
		
		String peso = "Peso";
	
		nuevaApp.depositar(cuentaDeMario, 3500.0);
		nuevaApp.extraer(cuentaDeMario, 2500.0);
		
		Double valorObtenido = cuentaDeMario.obtenerSaldo(peso);
		Double valorEsperado = 1000.0;
		//EJECUCION
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	@Test
	public void queSePuedaAceptarUnaSolicitudDeAmistad() {


	}
	
	@Test
	public void queSePuedaDenegarUnaSolicitudDeAmistad() {

	}
	
	@Test
	public void queSePuedaRegistrarLasTransaccionesHechas() {	

	        
		
	}
	
	@Test
	public void queNoSePuedaRetirarSaldoNegativo() {

	}
	
	@Test
	public void queSePuedanListarLosAmigosDeUnaCuenta() {

	}

	

}
