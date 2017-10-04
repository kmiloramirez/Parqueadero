package dominioTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.vigilante.VigilanteApplication;

import dominio.Carro;
import dominio.Factura;
import dominio.Vehiculo;
import dominio.Vigilante;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={VigilanteApplication.class})
@DataJpaTest
public class VigilanteTest {

	@Autowired
	Vigilante vigilante;
	
	
	private Vehiculo vehiculo;
	
	
	@Test
	public void ingresarTest(){
		vehiculo=new Carro("FGN887");
		Factura factura=vigilante.ingresarVehiculo(vehiculo);
		Assert.assertNotNull(factura);
	}
	
}
