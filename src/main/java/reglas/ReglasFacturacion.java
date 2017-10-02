package reglas;

import dominio.Factura;
import dominio.Vehiculo;

public interface ReglasFacturacion {
	
	public Factura ingresar(Vehiculo vehiculo);
	public Factura cobrar(Factura factura);

}
