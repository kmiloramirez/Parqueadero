package reglas;

import dominio.Recibo;


import java.util.Calendar;

public interface ReglasCobro {
	
	public int cobrar(Recibo recibo, Calendar fechaDeSalida);

}
