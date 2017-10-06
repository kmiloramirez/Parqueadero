package persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import dominio.Recibo;
import dominio.repositorio.RepositorioRecibo;
import persistencia.builder.ReciboBuilder;
import persistencia.entidad.ReciboEntity;

@Repository
public class RepositorioReciboPersistente implements RepositorioRecibo {
	private static final String PLACA = "placa";
	private static final String TIPO = "tipo";
	private static final String RECIBO_FIND_BY_PLACA = "Recibo.findByPlaca";
	private static final String RECIBOS_ACTIVOS = "Recibo.findRecibosActivos";

	private EntityManager entityManager;

	public RepositorioReciboPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void agregarRecibo(Recibo recibo) {
		entityManager.persist(ReciboBuilder.convertirReciboAEntity(recibo));

	}

	@Override
	public Recibo obtenerRecibo(String placa) {
		
		ReciboEntity reciboEntity = obtenerReciboEntity(placa);
		Recibo recibo = null;
		if(reciboEntity != null){
			recibo = ReciboBuilder.convertirADominio(reciboEntity);
		}
		
		return recibo;			
		
	}

	@SuppressWarnings("rawtypes")
	private ReciboEntity obtenerReciboEntity(String placa) {
		Query query = entityManager.createNamedQuery(RECIBO_FIND_BY_PLACA);
		query.setParameter(PLACA, placa);
		List resultList = query.getResultList();
		return !resultList.isEmpty() ? (ReciboEntity) resultList.get(0) : null;

	}
	
	@Override	
	public Long obtenerCantidadDeCeldasOcupadas(String tipo){
		Query query = entityManager.createNamedQuery(RECIBOS_ACTIVOS);
		query.setParameter(TIPO, tipo);
		return (Long) query.getSingleResult();
		 
	}

}
