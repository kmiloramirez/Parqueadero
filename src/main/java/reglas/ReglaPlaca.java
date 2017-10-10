package reglas;

import java.util.Calendar;

import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ParqueoException;


public class ReglaPlaca implements ReglasParqueo {

	private static final String NO_PUEDE_INGRESAR_HOY ="solo puede ingresar los dias domingos o lunes vuelva pronto";

	@Override
	public boolean validar(Vehiculo vehicuilo, Parqueadero parqueadero) {
		String placa = vehicuilo.getPlaca();
		if(placa.charAt(0)=='A' && !saberSiPuedeIngresar()){
				throw new ParqueoException(NO_PUEDE_INGRESAR_HOY);
		}
		return true;
		
	}

	public boolean saberSiPuedeIngresar() {
		int diaLunes = Calendar.MONDAY;
		int diaDomingo = Calendar.SUNDAY;
		int diaActual = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		return diaActual==diaLunes||diaDomingo==diaActual;
	}
	

}
