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
import dominio.Recibo;
import dominio.Moto;
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
	public void ingresarCarroTest(){
		vehiculo=new Carro("FGN887");
		Recibo recibo=vigilante.validarIngresoVehiculo(vehiculo);
		Assert.assertNotNull(recibo);
	}
	@Test
	public void ingresarMotoTest(){
		vehiculo=new Moto("FGN887",201);
		Recibo recibo=vigilante.validarIngresoVehiculo(vehiculo);
		Assert.assertNotNull(recibo);
	}
	
	@Test
	public void existeVehiculoTests(){
		vehiculo=new Carro("FGN887");
		Recibo recibo=vigilante.validarIngresoVehiculo(vehiculo);
		Assert.assertNotNull(recibo);
		Assert.assertTrue(vigilante.existeVehiculo(vehiculo.getPlaca()));
	}
	@Test
	public void noExisteVehiculoTests(){
		vehiculo=new Carro("FGN887");
		Recibo recibo=vigilante.validarIngresoVehiculo(vehiculo);
		vehiculo=new Carro("HGN887");
		Assert.assertNotNull(recibo);
		Assert.assertFalse(vigilante.existeVehiculo(vehiculo.getPlaca()));
	}
	@Test
	public void salidaDeCarroTests(){
		vehiculo=new Carro("FGN887");
		vigilante.validarIngresoVehiculo(vehiculo);
		Recibo reciboSalida=vigilante.darSalidaVehiculo("FGN887");
		Assert.assertNotNull(reciboSalida);
		Assert.assertEquals(reciboSalida.getValor(),1000, 0);
	}
	@Test
	public void salidaDeMotoCilindraje499Tests(){
		vehiculo=new Moto("FGN887",499);
		vigilante.validarIngresoVehiculo(vehiculo);
		Recibo reciboSalida=vigilante.darSalidaVehiculo("FGN887");
		Assert.assertNotNull(reciboSalida);
		Assert.assertEquals(reciboSalida.getValor(),500, 0);
	}
	@Test
	public void salidaDeMotoCilindraje500Tests(){
		vehiculo=new Moto("FGN887",500);
		vigilante.validarIngresoVehiculo(vehiculo);
		Recibo reciboSalida=vigilante.darSalidaVehiculo("FGN887");
		Assert.assertNotNull(reciboSalida);
		Assert.assertEquals(reciboSalida.getValor(),2500, 0);
	}
}
