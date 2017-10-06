package dominio;

import java.util.Calendar;
import java.util.List;

import dominio.excepcion.IngresoException;
import dominio.repositorio.RepositorioRecibo;
import dominio.repositorio.RepositorioVehiculo;
import reglas.ReglasParqueo;

public class Vigilante {

	private RepositorioVehiculo repositorioVehiculo;
	private RepositorioRecibo repositorioRecibo;
	private Parqueadero parqueadero;
	private List<ReglasParqueo> reglasParqueo;
	private static final String NO_PUEDE_INGRESAR = "este vehiculo tiene un recibo sin cobrar";

	public Vigilante(Parqueadero parqueadero, List<ReglasParqueo> reglasParqueo,
			RepositorioVehiculo repositorioVehiculo, RepositorioRecibo repositorioRecibo) {
		this.parqueadero = parqueadero;
		this.reglasParqueo = reglasParqueo;
		this.repositorioVehiculo = repositorioVehiculo;
		this.repositorioRecibo = repositorioRecibo;
	}

	public Recibo validarIngresoVehiculo(Vehiculo vehiculo) {
		validarReglasDeIngreso(vehiculo);
		elVehivuloYaHabiaIngreado(vehiculo);
		if (!existeReciboSinCobrar(vehiculo.getPlaca())) {
			Recibo recibo = new Recibo(vehiculo, Calendar.getInstance());
			repositorioRecibo.agregarRecibo(recibo);
			return recibo;
		}
		throw new IngresoException(NO_PUEDE_INGRESAR);

	}

	public void elVehivuloYaHabiaIngreado(Vehiculo vehiculo) {
		if (!existeVehiculo(vehiculo.getPlaca())) {
			repositorioVehiculo.agregarVehiculo(vehiculo);			
		}
	}

	public void validarReglasDeIngreso(Vehiculo vehiculo) {
		for (ReglasParqueo regla : reglasParqueo) {
			regla.validar(vehiculo, parqueadero);
		}
	}

	public boolean existeVehiculo(String placa) {
		return repositorioVehiculo.obtenerVehiculo(placa) != null;
	}

	public boolean existeReciboSinCobrar(String placa) {
		return repositorioRecibo.obtenerRecibo(placa) != null;
	}

}
