package reglas;

import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.IngresoException;

public class ReglaDisponibilidad implements ReglasParqueo {

	public static final String NO_CAPACIDAD_CARROS ="no hay capacidad para carros";
	public static final String NO_CAPACIDAD_MOTOS="no hay capacidad para motos";
	
	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
		if (vehiculo.getTipo().equals("carro") && parqueadero.getCeldaCarros() == 0) {
			throw new IngresoException(NO_CAPACIDAD_CARROS);
		}

		if (vehiculo.getTipo().equals("moto") && parqueadero.getCeldaMotos() == 0) {
			throw new IngresoException(NO_CAPACIDAD_MOTOS);
		}
		return true;

	}

}

