package dominio;

import java.util.Calendar;

public class Recibo {
	private Vehiculo vehiculo;
	private Calendar fechaDeIngreso;
	private Calendar fechaDeSalida;
	private double valor;
	public Recibo(Vehiculo vehiculo, Calendar fechaDeIngreso) {
		this.vehiculo = vehiculo;
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Recibo(Vehiculo vehiculo, Calendar fechaDeIngreso, Calendar fechaDeSalida, double valor) {
		this.vehiculo = vehiculo;
		this.fechaDeIngreso = fechaDeIngreso;
		this.fechaDeSalida = fechaDeSalida;
		this.valor = valor;
	}

	public void setFechaDeSalida(Calendar fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
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
	public double getValor() {
		return valor;
	}	
}
