package dominio;

import java.util.Calendar;

public class Factura {
	private Vehiculo vehiculo;
	private Calendar fechaDeIngreso;
	private Calendar fechaDeSalida;
	private boolean estado;
	private double valor;
	public Factura(Vehiculo vehiculo, Calendar fechaDeIngreso) {
		this.vehiculo = vehiculo;
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	public Factura(Vehiculo vehiculo, Calendar fechaDeIngreso, Calendar fechaDeSalida, boolean estado, double valor) {
		this.vehiculo = vehiculo;
		this.fechaDeIngreso = fechaDeIngreso;
		this.fechaDeSalida = fechaDeSalida;
		this.estado = estado;
		this.valor = valor;
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
	public boolean isEstado() {
		return estado;
	}
	public double getValor() {
		return valor;
	}	
}
