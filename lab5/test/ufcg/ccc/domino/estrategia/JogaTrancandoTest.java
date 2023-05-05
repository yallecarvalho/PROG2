package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.JogadaInvalidaException;

/*
 * Classe pra testar a implementação da estratégia de jogar primeiro a peça mais alta e depois continuar o jogo ao tentar sempre trancá-lo.
 */

class JogaTrancandoTest {
	
	private Mesa mesa;
	
	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
	}
	
	@Test
	void testPrimeiraJogadaComMaiorPeca() {
		JogaTrancando estrategia = new JogaTrancando();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 4), new Peca(0, 2), new Peca(1, 3)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	}
	@Test
	void testPassa() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 0));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		JogaTrancando estrategia = new JogaTrancando();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 5), new Peca(1, 2), new Peca(1, 1)), mesa);
		
		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	@Test
	void testTrancamentoNaDireitaComCarroca() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		
		JogaTrancando estrategia = new JogaTrancando();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 2), new Peca(2, 2), new Peca(2, 4)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	@Test
	void testTrancamentoNaDireitaNormal() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		
		JogaTrancando estrategia = new JogaTrancando();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 2), new Peca(5, 2), new Peca(2, 4)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	}
	@Test
	void testTrancamentoNaEsquerdaComCarroca() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		
		JogaTrancando estrategia = new JogaTrancando();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 2), new Peca(5, 6), new Peca(4, 4)), mesa);
		
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	}
	@Test
	void testJogaNormalNaDireita() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		
		JogaTrancando estrategia = new JogaTrancando();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 2), new Peca(5, 6), new Peca(3, 4)), mesa);
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	@Test
	void testJogaNormalNaEsquerda() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 4));
		
		JogaTrancando estrategia = new JogaTrancando();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(5, 6), new Peca(3, 4)), mesa);
		
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
	}
	
	
	
	

}
