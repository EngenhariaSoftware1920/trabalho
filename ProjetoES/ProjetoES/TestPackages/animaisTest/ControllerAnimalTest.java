package animaisTest;
import static org.junit.Assert.assertNotNull;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import animais.ControllerAnimal;
import main.ReadOperation;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerAnimalTest {
	private ControllerAnimal controller;
	private ReadOperation rO;
	@BeforeAll
	void globalSetup() {
		Scanner sc = new Scanner(System.in);
		rO = new ReadOperation(sc);
	}
	@BeforeEach
	void setup() {
		controller = new ControllerAnimal(rO);
	}
	@Test
	void insertSearchGeneroTest() {
		for(int i = 0; i < 5; i++) {
			System.out.println("// Género Test //");
			controller.insertGenero();
		}
		controller.printAllGenero();
		assertNotNull(controller.searchGeneroByDesignacao());
	}
	@Test
	void insertEspecieTeste() {
		System.out.println("// Espécie Test //");
		controller.insertGenero();
		for(int i = 0; i < 5; i++) {
			controller.insertEspecie();
		}
		controller.printAllEspecie();
		assertNotNull(controller.searchEspecieByNome());
	}
	@Test
	void insertSearchAnimal() {
		System.out.println("// Animal Test //");
		controller.insertGenero();
		controller.insertEspecie();
		for(int i = 0; i < 5; i++) {
			controller.insertAnimal();
		}
		controller.printAllAnimal();
		assertNotNull(controller.searchAnimalByCod());
	}

}
