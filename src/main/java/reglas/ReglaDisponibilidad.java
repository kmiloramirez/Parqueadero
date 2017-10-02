package reglas;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.Parqueadero;
import dominio.Vehiculo;

public class ReglaDisponibilidad implements Reglas {

	@Autowired
	Parqueadero parqueadero;

	@Override
	public boolean validar(Vehiculo vehiculo) {
		return ((vehiculo.getTipo().equals("carro") && parqueadero.getCeldaCarros() > 0)
				|| (vehiculo.getTipo().equals("moto") && parqueadero.getCeldaMotos() > 0));
	}

}
