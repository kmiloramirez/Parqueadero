package persistencia.entidad;

import java.util.Calendar;

import javax.persistence.*;

@Entity(name = "Recibo")
@NamedQueries({
		@NamedQuery(name = "Recibo.findByPlaca", query = "SELECT recibo FROM Recibo recibo WHERE recibo.vehiculoEntity.placa = :placa"),

		@NamedQuery(name = "Recibo.findRecibosActivos", query = "SELECT COUNT(*) from Recibo recibo where recibo.vehiculoEntity.tipo = :tipo AND recibo.fechaDeSalida is null") })

public class ReciboEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_VEHICULO", referencedColumnName = "id")
	private VehiculoEntity vehiculoEntity;

	@Column(nullable = false)
	private Calendar fechaDeIngreso;
	@Column
	private Calendar fechaDeSalida;
	@Column
	private double valor;

	public Calendar getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public Calendar getFechaDeSalida() {
		return fechaDeSalida;
	}

	public double getValor() {
		return valor;
	}

	public void setFechaDeIngreso(Calendar fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public void setFechaDeSalida(Calendar fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public VehiculoEntity getVehiculoEntity() {
		return vehiculoEntity;
	}

	public void setVehiculoEntity(VehiculoEntity vehiculoEntity) {
		this.vehiculoEntity = vehiculoEntity;
	}

}
