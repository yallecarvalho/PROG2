package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.PecaPadraoComparator;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.JogadaInvalidaException;

/*
 * Classe pra testar a implementação da estratégia Joga Primeira Possível Comparadora, que ordena as peças e depois joga de acordo com a Joga Primeira Possível.
 */

class JogaPrimeiraPossivelComparadoraTest {

	
	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
	}

	@Test
	void testJogaNaDireita() {
		
		Comparator<Peca> comparador = new PecaPadraoComparator();
		
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(comparador);
		
		List<Peca> mao1 = new ArrayList<Peca>();
		
		mao1.add(new Peca(1, 3));
		mao1.add(new Peca(3, 3));
		mao1.add(new Peca(0, 3));
		
		Jogada j1 = estrategia.decideJogada(mao1, mesa);

		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
	}

	@Test
	void testJogaNaEsquerda() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		Comparator<Peca> comparador = new PecaPadraoComparator();
		
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(comparador);
		
		List<Peca> mao1 = new ArrayList<Peca>();
		
		mao1.add(new Peca(1, 3));
		mao1.add(new Peca(3, 3));
		mao1.add(new Peca(0, 3));
		
		Jogada j1 = estrategia.decideJogada(mao1, mesa);

		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		
		
	}
	
	@Test
	void testPassa() throws JogadaInvalidaException {
		mesa.jogaNaDireita(new Peca(1, 2));
		Comparator<Peca> comparador = new PecaPadraoComparator();
		
		JogaPrimeiraPossivelComparadora estrategia = new JogaPrimeiraPossivelComparadora(comparador);
		
		List<Peca> mao1 = new ArrayList<Peca>();
		
		mao1.add(new Peca(5, 3));
		mao1.add(new Peca(3, 3));
		mao1.add(new Peca(0, 3));
		
		Jogada j1 = estrategia.decideJogada(mao1, mesa);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	
}