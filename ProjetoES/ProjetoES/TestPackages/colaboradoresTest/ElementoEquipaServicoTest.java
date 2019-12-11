package colaboradoresTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import animais.*;
import colaboradores.*;
import servicos.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ElementoEquipaServicoTest {
	private Veterinario v;
	private Assistente as;
	private Consulta c;
	private TipoConsulta tp;
	private Operacao op;
	private Animal a;
	@BeforeAll
	void globalSetup() {
		tp = new TipoConsulta(randomNome());
		Genero g = new Genero(randomNome());
		Especie e = new Especie(randomNome(), g);
		a = new Animal(randomNome(), e, "Macho", LocalDate.of(2016, Month.APRIL, 4));
	}
	@BeforeEach
	void setup() {
		v = new Veterinario(randomNome(), "Morada", "911111111", "Sabado", "true");
		as = new Assistente(randomNome(), "Morada", "911111111", "Sabado", "true");
		c = new Consulta(tp, a, LocalDate.of(2020, Month.APRIL, 4), LocalTime.of(16,00));
		op = new Operacao(randomNome());
	}
	// Veterinario
	@Test
	void valuesVeterinarioTest() {
		Veterinario newV = new Veterinario(randomNome(), "Morada", "911111111", "Sabado", "true");
		Servico aux = new Servico(c, op, newV, 2);
		assertFalse(v.insertServico(aux));
		aux = new Servico(c, op, v, 2);
		assertTrue(v.insertServico(aux));
	}
	@RepeatedTest(5)
	void insertVeterinarioTest() {
		Servico aux = new Servico(c, op, v, 2);
		assertTrue(v.insertServico(aux));
	}
	// Assistente
	@Test
	void valuesAssistenteTest() {
		Assistente newA = new Assistente(randomNome(), "Morada", "911111111", "Sabado", "true");
		Servico aux = new Servico(c, op, newA, 2);
		assertFalse(as.insertServico(aux));
		aux = new Servico(c, op, as, 2);
		assertTrue(as.insertServico(aux));
	}
	@RepeatedTest(5)
	void insertAssistenteTest() {
		Servico aux = new Servico(c, op, as, 2);
		assertTrue(as.insertServico(aux));
	}
	private String randomNome() {
		return "Nome" + ThreadLocalRandom.current().nextInt(0, 1000);
	}
}
