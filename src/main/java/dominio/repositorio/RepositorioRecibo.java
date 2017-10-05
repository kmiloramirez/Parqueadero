package dominio.repositorio;

import dominio.Recibo;


public interface RepositorioRecibo {
	
	public void agregarRecibo(Recibo  recibo );
	public Recibo obtenerRecibo(String placa);

}
