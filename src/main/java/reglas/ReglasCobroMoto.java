package reglas;

import java.util.Calendar;



import dominio.Moto;
import dominio.Recibo;
import dominio.logica.CalcularCobro;

public class ReglasCobroMoto implements ReglasCobro{

	private static final int VALORDIAS=600;
	private static final int VALORHORAS=500;
	private static final int CILINDRAJE_PARA_COBRAR_MAS=500;
	private static final int COBRO_POR_CILINDRAJE=2000;
	private static final String COBROPARAMOTO="moto";
	private CalcularCobro calcularCobro = new CalcularCobro();
	Moto moto;
	@Override
	public int cobrar(Recibo recibo, Calendar fechaDeSalida) {
		moto=(Moto)recibo.getVehiculo();
		if(moto.getCilindraje()>=CILINDRAJE_PARA_COBRAR_MAS){
			return ((calcularCobro.calcular(recibo.getFechaDeIngreso(), fechaDeSalida, VALORDIAS, VALORHORAS))+COBRO_POR_CILINDRAJE);
		}
		return calcularCobro.calcular(recibo.getFechaDeIngreso(), fechaDeSalida, VALORDIAS, VALORHORAS);
	}
	@Override
	public String tipoDeCobro() {
		
		return COBROPARAMOTO;
	}
	

}
