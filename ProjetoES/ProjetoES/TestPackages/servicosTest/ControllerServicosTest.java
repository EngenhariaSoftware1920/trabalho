package servicosTest;
import static org.junit.Assert.assertNotNull;
import java.time.LocalDate;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import animais.Animal;
import animais.Especie;
import animais.Genero;
import main.ReadOperation;
import servicos.ControllerServicos;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerServicosTest {
	private ControllerServicos controller;
	private ReadOperation rO;
	@BeforeAll
	void globalSetup() {
		Scanner sc = new Scanner(System.in);
		rO = new ReadOperation(sc);
	}
	@BeforeEach
	void global() {
		controller = new ControllerServicos(rO);
	}
	@Test
	void insertSearchTipoConsultaTest() {
		System.out.println("// Tipo de Consulta Test //");
		for(int i = 0; i < 5; i++) {
			controller.insertTipoConsulta();
		}
		controller.printAllTipo();
		assertNotNull(controller.searchTipoByDesignacao());
	}
	@Test
	void insertSearchOperacaoTest() {
		System.out.println("// Operação Test //");
		for(int i = 0; i < 5; i++) {	
			controller.insertOperacao();
		}
		controller.printAllOperacao();
		assertNotNull(controller.searchOperacaoByDesignacao());
	}
	@Test
	void insertSearchConsultaTest() {
		System.out.println("// Consulta Test //");
		Animal aux = new Animal("Nome", new Especie("Esp", new Genero("Des")), "Macho", LocalDate.of(2018, 04, 01));
		controller.insertTipoConsulta();
		for(int i = 0; i < 5; i++) {
			controller.insertConsulta(aux);
		}
		controller.printAllConsulta();
		assertNotNull(controller.searchConsultaByCod());
	}	
}
