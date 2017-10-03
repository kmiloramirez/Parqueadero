package persistencia.repositorio;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import dominio.Carro;
import dominio.Moto;
import dominio.repositorio.RepositorioVehiculo;
import persistencia.builder.VehiculoBuilder;

@Repository
public class RepositorioVehiculosPersistente implements RepositorioVehiculo {

	private EntityManager entityManager;

	public RepositorioVehiculosPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void agregarCarro(Carro carro) {
		entityManager.persist(VehiculoBuilder.convertirCarroAEntity(carro));

	}

	@Override
	public void agregarMoto(Moto moto) {
		entityManager.persist(VehiculoBuilder.convertirMotoAEntity(moto));

	}

}
