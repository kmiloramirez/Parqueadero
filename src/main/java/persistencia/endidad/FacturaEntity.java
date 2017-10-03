package persistencia.endidad;

import java.util.Calendar;

import javax.persistence.*;

import dominio.Vehiculo;

@Entity(name="factura")

public class FacturaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private Vehiculo vehiculo;
	@Column(nullable = false)
	private Calendar fechaDeIngreso;
	@Column
	private Calendar fechaDeSalida;
	@Column(nullable = false)
	private boolean estado;
	@Column
	private double valor;
	public Long getId() {
		return id;
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
	public void setId(Long id) {
		this.id = id;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public void setFechaDeIngreso(Calendar fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	public void setFechaDeSalida(Calendar fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
