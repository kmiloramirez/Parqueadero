package reglas;

import java.util.Calendar;

import dominio.Recibo;
import dominio.logica.CalcularCobro;


public class ReglaCobroCarro implements ReglasCobro{
	
	private static final int VALORDIAS=2000;
	private static final int VALORHORAS=1000;
	private CalcularCobro calcularCobro = new CalcularCobro();
	@Override
	public int cobrar(Recibo recibo, Calendar fechaDeSalida) {
		return calcularCobro.calcular(recibo.getFechaDeIngreso(), fechaDeSalida, VALORDIAS, VALORHORAS);
	}
	
	
	

}
