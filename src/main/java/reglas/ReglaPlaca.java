package reglas;

import java.util.Calendar;

import dominio.Parqueadero;
import dominio.Vehiculo;

public class ReglaPlaca implements ReglasParqueo {

	

	@Override
	public boolean validar(Vehiculo vehicuilo, Parqueadero parqueadero) {
		String placa = vehicuilo.getPlaca();
		if(placa.charAt(0)=='A'){
			return saberSiEsLunes();
		}
		return true;
		
	}

	public boolean saberSiEsLunes() {
		int diaLunes = Calendar.MONDAY;
		int diaActual = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		return diaActual!=diaLunes;
	}
	

}
