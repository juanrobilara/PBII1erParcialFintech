<h1>Persiste el proyecto de Fintech, en este caso llamada Bitso</h1>
<h3>La idea es la misma, pero se agregaron casos de prueba y se fueron corrigiendo los problemas de herencia.</h3>
<h3>Así mismo, se modificaron algunos métodos para darle mayor funcionalidad</h3>

<h4>Los valores de las criptomonedas son:</h4> 
<br>
-Bitcoin 200.0  <br>
-Ethereum 100.0 <br>
-DAI 50.0 <br>
<h4> Compradas a partir de un peso </h4>
-Peso 1.0 <br>
<br>
Tanto las criptomonedas como el peso heredan de la clase Moneda, la cual actúa como una billetera de cada tipo de ellas. 
<br>
Se puede observar como se inicializan en el constructor de la cuenta, permitiendo acceder a sus atributos mediante los getters. 
<br>
Se añadió la posibilidad de enviar solicitudes de amistad, aceptarlas y rechazarlas. 
<br>
Se pueden transferir en todos los tipos de moneda, siempre y cuando las monedas de Cuenta origen y Cuenta destino sean las mismas. 
<br>
Se corrigió la forma de comprar criptomonedas, ahora se especifica la cantidad de la moneda que se quiere comprar, en vez de calcular antes el total en pesos.
<br>
Solo se puede extraer, comprar y depositar en pesos 
<br>
<br>
<h3>Los casos de prueba a utilizar son:</h3> <br>
queSePuedaCrearUnaCuenta() <br>
queNoSePuedanCrearCuentasRepetidas() <br>
queSePuedaTransferirEnPesos() <br>
queSePuedaComprarBitcoinsA_200_Pesos() <br>
queSePuedaComprarEthereumA_100_Pesos() <br>
queSePuedaComprarDaiA_50_Pesos() <br>
queSePuedaTenerDivididoElSaldoEnPesosYEnCripto() <br>
queSePuedaRetirarPesos() <br>
queSePuedaAceptarUnaSolicitudDeAmistad() <br>
queSePuedaDenegarUnaSolicitudDeAmistad() <br>
queSePuedaRegistrarLasTransaccionesHechas() <br>
queNoSePuedaRetirarSaldoNegativo() <br>
queSePuedanListarLosAmigosDeUnaCuenta() <br>
