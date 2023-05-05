package ufcg.ccc.domino.estrategia;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.PecaPadraoComparator;

/**
 * Estratégia que recebe um comparador de peças e que ordena a mão do jogador antes de decidir a jogada. 
 * A jogada usada é a da superclasse, a estratégia JogaPrimeiraPossível.
 * 
 * @author yalle carvalho
 */

public class JogaPrimeiraPossivelComparadora extends JogaPrimeiraPossivel {
	
	public JogaPrimeiraPossivelComparadora(Comparator<Peca> comparador) {
		 new PecaPadraoComparator();
	}
	
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		Jogada jogada = null;
		Collections.sort(mao, new PecaPadraoComparator());
		
		jogada = super.decideJogada(mao, mesa);
		
		return jogada;
		
	}
	@Override
	public String toString() {
		return "Joga Primeira Possível Comparadora";
	}

}


