package reglas;


import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.RealizarAccion;
import dominio.Vehiculo;
import dominio.excepcion.IngresoException;
import dominio.repositorio.RepositorioRecibo;

public class ReglaDisponibilidad implements ReglasParqueo {

	private static final int LIMITE_MINIMO_DE_CELDAS_PARA_PRESTAR = 0;
	public static final String NO_CAPACIDAD_CARROS = "no hay capacidad para carros";
	public static final String NO_CAPACIDAD_MOTOS = "no hay capacidad para motos";
	private RepositorioRecibo repositorioRecibo;

	public ReglaDisponibilidad(RepositorioRecibo repositorioRecibo) {
		this.repositorioRecibo = repositorioRecibo;

	}

	private long celdasNoDisponibles(Vehiculo vehiculo) {
		return repositorioRecibo.obtenerCantidadDeCeldasOcupadas(vehiculo.getTipo());
	}

	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
		
		RealizarAccion accion = new RealizarAccion();

		accion.executeSiCarro(vehiculo, ()  -> {
			if (celdasDisponibles(vehiculo,parqueadero)==LIMITE_MINIMO_DE_CELDAS_PARA_PRESTAR) {
				throw new IngresoException(NO_CAPACIDAD_CARROS);
			}
		});
		
		accion.executeSiMoto(vehiculo, () -> {
			if (vehiculo instanceof Moto && celdasDisponibles(vehiculo,parqueadero)==LIMITE_MINIMO_DE_CELDAS_PARA_PRESTAR) {
				throw new IngresoException(NO_CAPACIDAD_MOTOS);
			}
		});		
		return true;

	}

	public int celdasDisponibles(Vehiculo vehiculo,Parqueadero parqueadero) {
		Long celdasOcupadas = celdasNoDisponibles(vehiculo);
		
		if (vehiculo instanceof Carro){
			return parqueadero.getCeldaCarros()-celdasOcupadas.intValue();
		}
		if (vehiculo instanceof Moto){
			return parqueadero.getCeldaMotos()-celdasOcupadas.intValue();
		}
		return 0;
		
	}

}
