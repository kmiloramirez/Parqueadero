package reglas;

import dominio.Vehiculo;

public class ReglaCobrar implements Reglas {
	private int valorHoraCarro = 1000;
	private int valorHoraMoto = 500;
	private int valorDiaCarro = 8000;
	private int valorDiaMoto = 600;

	@Override
	public boolean validar(Vehiculo vehiculo) {
		
		

		return true;
	}

}
