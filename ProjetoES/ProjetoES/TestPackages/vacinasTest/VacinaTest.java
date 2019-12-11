package vacinasTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import vacinas.GestaoVacina;
import vacinas.Vacina;
import vacinas.Virus;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VacinaTest {

	private GestaoVacina gv;
	
	@BeforeEach
	void setup() {
		gv = new GestaoVacina();
	}
	
	@Test
	@DisplayName("Inserir vacinas")
	void inserirVacina() {
		Vacina v1=new Vacina("nome1",10);
		Vacina v2=new Vacina("nome2",50);
		Vacina v3=new Vacina("nome3",30);
		assertTrue(gv.getVacinas().size()==0);
		gv.adicionarVacina(v1);
		gv.adicionarVacina(v2);
		gv.adicionarVacina(v3);
		assertEquals(gv.getVacinas().size(),3);
	}
	
	@Test
	@DisplayName("Inserir virus na vacina")
	void inserirVirusVacina() {
		Vacina v1=new Vacina("Va1",10);
		Vacina v2=new Vacina("Va2",50);
		Vacina v3=new Vacina("Va3",30);
		assertTrue(gv.getVacinas().size()==0);
		gv.adicionarVacina(v1);
		gv.adicionarVacina(v2);
		gv.adicionarVacina(v3);
		assertEquals(gv.getVacinas().size(),3);
		
		Virus vi1=new Virus("Vi1");
		Virus vi2=new Virus("Vi2");
		assertTrue(gv.getVirus().size()==0);
		gv.adicionarVirus(vi1);
		gv.adicionarVirus(vi2);
		assertEquals(gv.getVirus().size(),2);
		
		gv.adicionarVirusVacina("va1", vi1);
		gv.adicionarVirusVacina("va1", vi2);
		gv.adicionarVirusVacina("va2", vi2);
		assertTrue(v1.getVirus().get(0).getNome().equalsIgnoreCase("vi1"));
		assertTrue(v2.getVirus().get(0).getNome().equalsIgnoreCase("vi2"));
	}
}
