package dominio;

import java.util.Calendar;

public class Factura {
	private int numeroDeFactura;
	private Vehiculo vehiculo;
	private Calendar fechaDeIngreso;
	private Calendar fechaDeSalida;
	private boolean estadoDeFactura;
	private int valorACobrar;

	public Factura(Vehiculo vehiculo, Calendar fechaDeIngreso) {
		this.vehiculo = vehiculo;
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public Factura(int numeroDeFactura, Vehiculo vehiculo, Calendar fechaDeIngreso, Calendar fechaDeSalida,
			boolean estadoDeFactura) {
		this.numeroDeFactura = numeroDeFactura;
		this.vehiculo = vehiculo;
		this.fechaDeIngreso = fechaDeIngreso;
		this.fechaDeSalida = fechaDeSalida;
		this.estadoDeFactura = estadoDeFactura;
	}

	public int getNumeroDeFactura() {
		return numeroDeFactura;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Calendar getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public Calendar getFechaDeSalida() {
		return fechaDeSalida;
	}

	public boolean isEstadoDeFactura() {
		return estadoDeFactura;
	}

	private int getValorACobrar() {
		return valorACobrar;
	}

	public void setValorACobrar(int valorACobrar) {
		this.valorACobrar = valorACobrar;
	}

}
