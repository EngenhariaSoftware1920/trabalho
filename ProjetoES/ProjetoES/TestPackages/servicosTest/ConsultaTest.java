package servicosTest;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import animais.*;
import servicos.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConsultaTest {
	private GestaoServico manager;
	private Animal a;
	private TipoConsulta tp;
	@BeforeAll
	void globalSetup() {
		Genero g = new Genero(desRandom());
		Especie e = new Especie(nomeRandom(), g);
		tp = new TipoConsulta(desRandom());
		a = new Animal(nomeRandom(), e, "Macho", LocalDate.of(2016, Month.APRIL, 4));
	}
	@BeforeEach
	void setup() {
		manager = new GestaoServico();
	}
	@Test
	void insertSearchConsultaTest() {
		for(int i = 1; i <= 5; i++) {
			manager.insertConsulta(tp, a, LocalDate.of(2020, Month.APRIL, 4), LocalTime.of(16,00));
			assertNotNull(manager.searchConsultaByCod(i));
		}
	}
	private String nomeRandom() {
		return "Nome" + ThreadLocalRandom.current().nextInt(0,1000);
	}
	private String desRandom() {
		return "Des" + ThreadLocalRandom.current().nextInt(0,1000);
	}
}
