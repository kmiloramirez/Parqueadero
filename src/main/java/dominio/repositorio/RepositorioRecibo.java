package dominio.repositorio;

import dominio.Recibo;


public interface RepositorioRecibo {
	
	public void agregarRecibo(Recibo  recibo );
	public Recibo obtenerRecibo(String placa);
	public Long obtenerCantidadDeCeldasOcupadas(String tipo);

}
