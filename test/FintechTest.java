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
		
		//EJECUCIÓN
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
			
		//EJECUCIÓN
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevaApp.cantidadDeCuentas();
			
		assertEquals(valorEsperado, valorObtenido);

	}
	
	@Test
	public void queSePuedaTransferirEnPesos() {

	}
	
	@Test
	public void queSePuedaComprarBitcoinsA_200_Pesos() {

	}
	
	@Test
	public void queSePuedaComprarEthereumA_100_Pesos() {

	}
	
	@Test
	public void queSePuedaComprarDaiA_50_Pesos() {

	}
	
	@Test
	public void queSePuedaTenerDivididoElSaldoEnPesosYEnCripto() {
		

		
	}
	
	
	@Test
	public void queSePuedaRetirarPesos() {

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
