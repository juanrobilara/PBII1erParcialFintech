#Persiste el proyecto de Fintech, en este caso llamada Bitso
###La idea es la misma, pero se agregaron casos de prueba y se fueron corrigiendo los problemas de herencia.
###Así mismo, se modificaron algunos métodos para darle mayor funcionalidad

Los valores de las monedas son:
-Bitcoin 200.0
-Ethereum 100.0
-DAI 50.0
Compradas a partir de un peso
-Peso 1.0

Tanto las criptomonedas como el peso heredan de la clase Moneda, la cual actúa como una billetera de cada tipo de ellas.
Se puede observar como se inicializan en el constructor de la cuenta, permitiendo acceder a sus atributos mediante los getters.
Se añadió la posibilidad de enviar solicitudes de amistad, aceptarlas y rechazarlas.
Se pueden transferir en todos los tipos de moneda, siempre y cuando las monedas de Cuenta origen y Cuenta destino sean las mismas.
Se corrigió la forma de comprar criptomonedas, ahora se especifica la cantidad de la moneda que se quiere comprar, en vez de calcular antes el total en pesos.
Solo se puede extraer, comprar y depositar en pesos

Los casos de prueba a utilizar son:
queSePuedaCrearUnaCuenta()
queNoSePuedanCrearCuentasRepetidas()
queSePuedaTransferirEnPesos()
queSePuedaComprarBitcoinsA_200_Pesos()
queSePuedaComprarEthereumA_100_Pesos()
queSePuedaComprarDaiA_50_Pesos()
queSePuedaTenerDivididoElSaldoEnPesosYEnCripto()
queSePuedaRetirarPesos()
queSePuedaAceptarUnaSolicitudDeAmistad()
queSePuedaDenegarUnaSolicitudDeAmistad()
queSePuedaRegistrarLasTransaccionesHechas()
queNoSePuedaRetirarSaldoNegativo()
queSePuedanListarLosAmigosDeUnaCuenta()
