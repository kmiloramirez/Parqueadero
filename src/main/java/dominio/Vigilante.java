package dominio;

import java.util.Calendar;
import java.util.List;

import dominio.excepcion.ParqueoException;
import dominio.repositorio.RepositorioRecibo;
import dominio.repositorio.RepositorioVehiculo;

import reglas.ReglasCobro;
import reglas.ReglasParqueo;

public class Vigilante {

	private RepositorioVehiculo repositorioVehiculo;
	private RepositorioRecibo repositorioRecibo;
	private Parqueadero parqueadero;
	private List<ReglasParqueo> reglasParqueo;
	private List<ReglasCobro> reglasCobro;
	private static final String NO_PUEDE_INGRESAR = "este vehiculo tiene un recibo sin cobrar";
	private static final String NO_SE_TIENE_COMO_COBRAR = "este vehiculo no es soportado por el sistema";
	private static final String ESTE_VEHICULO_NO_ESTA = "este vehiculo no esta en el sistema";

	public Vigilante(Parqueadero parqueadero, List<ReglasParqueo> reglasParqueo,
			RepositorioVehiculo repositorioVehiculo, RepositorioRecibo repositorioRecibo,
			List<ReglasCobro> reglasCobro) {
		this.parqueadero = parqueadero;
		this.reglasParqueo = reglasParqueo;
		this.repositorioVehiculo = repositorioVehiculo;
		this.repositorioRecibo = repositorioRecibo;
		this.reglasCobro = reglasCobro;
	}

	public Recibo validarIngresoVehiculo(Vehiculo vehiculo) {
		validarReglasDeIngreso(vehiculo);
		elVehivuloYaHabiaIngreado(vehiculo);
		if (!existeReciboSinCobrar(vehiculo.getPlaca())) {
			Recibo recibo = new Recibo(vehiculo, Calendar.getInstance());
			repositorioRecibo.agregarRecibo(recibo);
			return recibo;
		}
		throw new ParqueoException(NO_PUEDE_INGRESAR);

	}

	public Recibo darSalidaVehiculo(String placa) {
		Recibo recibo = obtenerReciboDeEntrada(placa);
		Calendar fechaDeSalida = Calendar.getInstance();
		Vehiculo vehiculo = recibo.getVehiculo();
		ReglasCobro reglaCobro = seleccionarRegla(vehiculo);
		int valorACobrar = reglaCobro.cobrar(recibo, fechaDeSalida);
		recibo.setFechaDeSalida(fechaDeSalida);
		recibo.setValor(valorACobrar);
		guardarReciboDeSalida(placa, fechaDeSalida, valorACobrar);
		return recibo;

	}

	private void guardarReciboDeSalida(String placa, Calendar fechaDeSalida, int valorACobrar) {
		repositorioRecibo.actualizarRecibo(placa, fechaDeSalida, valorACobrar);

	}

	private ReglasCobro seleccionarRegla(Vehiculo vehiculo) {
		for (ReglasCobro regla : reglasCobro) {
			if (regla.tipoDeCobro().equals(vehiculo.getTipo())) {
				return regla;
			}
		}
		throw new ParqueoException(NO_SE_TIENE_COMO_COBRAR);
	}

	private Recibo obtenerReciboDeEntrada(String placa) {
		Recibo recibo=repositorioRecibo.obtenerRecibo(placa);
		if(recibo !=null){
			return recibo;
		}
		throw new ParqueoException(ESTE_VEHICULO_NO_ESTA);
		
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
