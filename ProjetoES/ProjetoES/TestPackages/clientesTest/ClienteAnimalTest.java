package clientesTest;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import animais.Animal;
import animais.Especie;
import animais.Genero;
import clientes.Cliente;
import clientes.ClienteAnimal;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClienteAnimalTest {
	private Animal a;
	private Cliente c;
	private Especie auxE;
	@BeforeAll
	void globalSetup() {
		Genero auxG = new Genero(randomNome());
		auxE = new Especie(randomNome(), auxG);	
	}
	@BeforeEach
	void setup() {
		a = new Animal(randomNome(), auxE, "Fêmea", LocalDate.of(2016, Month.APRIL, 4));
		c = new Cliente(randomNome(), "Morada", "911111111");
	}
	@Test
	void valuesTest() {
		Cliente newC = new Cliente(randomNome(), "Morada", "911111111");
		ClienteAnimal aux = new ClienteAnimal(a,newC, LocalDate.of(2016, Month.APRIL, 4));
		assertFalse(c.insertClienteAnimal(aux));
		aux = new ClienteAnimal(a, c, LocalDate.of(2016, Month.APRIL, 4));
		assertTrue(c.insertClienteAnimal(aux));
	}
	@RepeatedTest(5)
	void insertTest() {
		ClienteAnimal aux = new ClienteAnimal(a, c, LocalDate.of(2016, Month.APRIL, 4));
		assertTrue(c.insertClienteAnimal(aux));
	}
	private String randomNome() {
		return "Nome" + ThreadLocalRandom.current().nextInt(0, 1000);
	}
}
