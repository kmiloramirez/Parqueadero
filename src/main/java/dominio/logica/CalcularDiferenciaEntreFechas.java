package dominio.logica;

import java.util.Calendar;

public class CalcularDiferenciaEntreFechas {

	private static final int VALOR_DE_MILISEGUNDOS_A_HORAS = 1000*60*60;
	private long miliSegHoraInicial;
	private long miliSegHoraFinal;

	public long calcular(Calendar fechaDeIngreso, Calendar fechaDeSalida) {
		convertirHorasAMilisegundos(fechaDeIngreso, fechaDeSalida);
		return diferenciaEntreFechas();

	}

	private long diferenciaEntreFechas() {
		
		double diferencia=(double)(miliSegHoraFinal-miliSegHoraInicial)/VALOR_DE_MILISEGUNDOS_A_HORAS;
		return (long) Math.ceil(diferencia);
	}

	private void convertirHorasAMilisegundos(Calendar fechaDeIngreso, Calendar fechaDeSalida) {
		miliSegHoraInicial = fechaDeIngreso.getTimeInMillis();
		miliSegHoraFinal = fechaDeSalida.getTimeInMillis();
	}
}
/*
 * 
	 * public static final String ERROR_INTENTANDO_CALCULAR_TIEMPO_DE_SERVICIO =
	 * "Error intentando calcular tiempo de servicio";  private static final int DIAS_DIVISOR =
	 * HORAS_DIVISOR*9; long miliSegHoraInicial = horaInicial.getTimeInMillis();
	 * 
	 * verificarHorasCorrectas(miliSegHoraInicial,miliSegHoraFinal);
	 *  long diferenciaMiliSeg = miliSegHoraFinal - miliSegHoraInicial;
	 *   return ((double)diferenciaMiliSeg/divisor) long miliSegHoraInicial = horaInicial.getTimeInMillis();
	 *    long miliSegHoraFinal = horaFinal.getTimeInMillis();
	 * verificarHorasCorrectas(miliSegHoraInicial,miliSegHoraFinal); long
	 * diferenciaMiliSeg = miliSegHoraFinal - miliSegHoraInicial; return
	 * ((double)diferenciaMiliSeg/divisor);
 */