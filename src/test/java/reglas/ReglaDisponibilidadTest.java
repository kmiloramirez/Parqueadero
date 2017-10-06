package reglas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.vigilante.VigilanteApplication;

import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.IngresoException;
import dominio.repositorio.RepositorioRecibo;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={VigilanteApplication.class})
@DataJpaTest
public class ReglaDisponibilidadTest {
	
	@Autowired
	RepositorioRecibo repositorioRecibo;
	
	Vehiculo vehiculo;
	
	
	ReglaDisponibilidad reglas;
	
	Parqueadero parqueadero;

	@Test
	public void validarDisponibilidadMoto() {
		vehiculo = new Moto("FG823C", 150);
		parqueadero = new Parqueadero(20, 10);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));

	}

	@Test
	public void validarDisponibilidadCarro() {
		vehiculo = new Carro("FGN887");
		parqueadero = new Parqueadero(20, 10);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		Assert.assertTrue(reglas.validar(vehiculo, parqueadero));
	}

	@Test
	public void validarDisponibilidadMotoFalso() {
		vehiculo = new Moto("FG823C", 150);
		parqueadero = new Parqueadero(20, 0);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		try {
			reglas.validar(vehiculo, parqueadero);
			fail();

		} catch (IngresoException e) {
			Assert.assertEquals("no hay capacidad para motos", e.getMessage());
		}

	}

	@Test
	public void validarDisponibilidadCarroFalso() {
		vehiculo = new Carro("FGN887");
		parqueadero = new Parqueadero(0, 10);
		reglas = new ReglaDisponibilidad(repositorioRecibo);
		try {
			reglas.validar(vehiculo, parqueadero);
			fail();

		} catch (IngresoException e) {
			Assert.assertEquals("no hay capacidad para carros", e.getMessage());
		}

	}

}
