package reglas;

import java.util.Calendar;

import dominio.Vehiculo;

public class ReglaPlaca implements ReglasParqueo {

	@Override
	public boolean validar(Vehiculo vehicuilo) {
		String placa = vehicuilo.getPlaca();
		int diaLunes = Calendar.MONDAY;
		int diaActual = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		return !(placa.charAt(0)=='A'&&(diaActual!=diaLunes));
		
	}
	

}
