package dominio.repositorio;

import java.util.Calendar;

import dominio.Recibo;


public interface RepositorioRecibo {
	
	public void agregarRecibo(Recibo  recibo );
	public Recibo obtenerRecibo(String placa);
	public Long obtenerCantidadDeCeldasOcupadas(String tipo);
	public void actualizarRecibo(String placa,Calendar fechaSalida,int valor);

}
