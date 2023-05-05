package controle.de.alunos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe para realizar testes da Classe Grupo de Estudo.
 * @author Yalle Carvalho - 119210523
 */


class GrupoDeEstudoTest {
	
	private GrupoDeEstudo grupo1;
	private GrupoDeEstudo grupo2;
	@Test
	void testaGrupoCompleto() {
		new GrupoDeEstudo("Listas", "Computação");
	}
	@Test
	void testaGrupoSemRestrição() {
			new GrupoDeEstudo("Gatos", "");
	}
	@Test
	void testaGrupoComNomeInvalido() {
		try {
			new GrupoDeEstudo("", "Relações Internacionais");
			fail("Espera-se uma exceção");
		} catch (IllegalArgumentException iae) {
			
		}
	}

	@BeforeEach
	void preparaGrupos() {
		this.grupo1 = new GrupoDeEstudo("Listas", "Computação");
		this.grupo2 = new GrupoDeEstudo("Gatos", "");
	}
	
	@Test
	void exibirNome() {
		assertEquals("Listas", grupo1.getNome());
		assertEquals("Gatos", grupo2.getNome());
	}

	@Test
	void exibirRestrição() {
		assertEquals("Computação", grupo1.getRestricao());
	}


	@Test
	void tesatHashCodeGruposIguais() {
		assertEquals(this.grupo1.hashCode(), new GrupoDeEstudo("Listas", "Medicina").hashCode());
	}
	@Test
	void tesatHashCodeGruposDiferentes() {
		assertNotEquals(this.grupo1.hashCode(), this.grupo2.hashCode());
	}

	@Test
	void testEqualsObject() {
		assertFalse(this.grupo1.equals(grupo2));
		assertTrue(this.grupo2.equals(new GrupoDeEstudo("Gatos", "Literatura")));
	}

}
