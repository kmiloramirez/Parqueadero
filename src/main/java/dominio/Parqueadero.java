package dominio;

public class Parqueadero {
	private int celdaCarros;
	private int celdaMotos;
	
	
	public Parqueadero(int celdaCarros,int celdaMotos){
		this.celdaCarros=celdaCarros;
		this.celdaMotos=celdaMotos;
	}

	public int getCeldaCarros() {
		return celdaCarros;
	}

	public int getCeldaMotos() {
		return celdaMotos;
	}

	public void setCeldaCarros(int celdaCarros) {
		this.celdaCarros = celdaCarros;
	}

	public void setCeldaMotos(int celdaMotos) {
		this.celdaMotos = celdaMotos;
	}
	

}
