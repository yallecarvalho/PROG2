package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogo.TipoDeVitoria;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

class JogoTest {

	@Test
	void testRodadaInicial() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 14);

		assertEquals(0, j.getNumRodadas());
		assertEquals(14, j.getNumPecasJ1());
		assertEquals(14, j.getNumPecasJ2());

		j.rodada();

		assertEquals(1, j.getNumRodadas());
		assertEquals(13, j.getNumPecasJ1());
		assertEquals(13, j.getNumPecasJ2());
	}
	
	@Test
	void testJogoAleatorio() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 10, new Random(1));

		HistoricoDeJogo historico = j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		
		System.out.println(historico.toString());
	}

	@Test
	void testVencedorJ1Simples() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}
	
	@Test
	void testEmpate() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertNull(j.getVencedor());
	}
	@Test
	void testDesempatePorNumPecas() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6), new Peca(2, 3));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}
	@Test
	void testDesempatePorPontos() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(3, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}
	@Test
	void testVitoriaJ2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	}
	
	@Test
	void testVitoriaCruzada() throws Exception {
		List<Peca> mao1 = List.of(new Peca(3, 2), new Peca(1, 2), new Peca(1, 1));
		List<Peca> mao2 = List.of(new Peca(3, 3), new Peca(3, 1),  new Peca(6, 5));
		
		Jogo j = new Jogo("J2", new JogaPrimeiraPossivel(), "J1", new JogaPrimeiraPossivel(), mao2, mao1);
		
		j.jogaJogoCompleto();
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals(TipoDeVitoria.CRUZADA, j.getVitoria());
		assertEquals(6, j.getPontuacaoDaVitoria());	
		
	}
	@Test
	void testVitoriaLaELo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(3, 2), new Peca(4, 2), new Peca(1, 4));
		List<Peca> mao2 = List.of(new Peca(3, 3), new Peca(3, 1),  new Peca(6, 5));
		
		Jogo j = new Jogo("J2", new JogaPrimeiraPossivel(), "J1", new JogaPrimeiraPossivel(), mao2, mao1);
		
		j.jogaJogoCompleto();
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals(TipoDeVitoria.LA_E_LO, j.getVitoria());
		assertEquals(3, j.getPontuacaoDaVitoria());	
		
	}
	@Test
	void testVitoriaLaELoComDuasPecas() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 1), new Peca(2, 1));
		List<Peca> mao2 = List.of(new Peca(1, 3), new Peca(3, 0));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		j.jogaJogoCompleto();
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals(TipoDeVitoria.LA_E_LO, j.getVitoria());
		assertEquals(3, j.getPontuacaoDaVitoria());	
		
	}
	@Test
	void testVitoriaNormal() throws Exception {
		List<Peca> mao1 = List.of(new Peca(2, 2), new Peca(2, 1), new Peca(4, 2));
		List<Peca> mao2 = List.of(new Peca(3, 3), new Peca(3, 1),  new Peca(6, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		j.jogaJogoCompleto();
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		assertEquals(TipoDeVitoria.NORMAL, j.getVitoria());
		assertEquals(1, j.getPontuacaoDaVitoria());	
		
	}
	
	@Test
	void testVitoriaCarroca() throws Exception {
		List<Peca> mao1 = List.of(new Peca(2, 2), new Peca(2, 1), new Peca(4, 2));
		List<Peca> mao2 = List.of(new Peca(2, 3), new Peca(3, 5),  new Peca(1, 1));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);
		
		j.jogaJogoCompleto();
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
		assertEquals(TipoDeVitoria.CARROCA, j.getVitoria());
		assertEquals(2, j.getPontuacaoDaVitoria());	
		
	}
	
}
