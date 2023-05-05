package ufcg.ccc.domino.estrategia;

import java.util.LinkedList;
import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Estratégia que recebe uma lista de estrategias. Ao chamar a estratégia composta o jogador vai poder alternar 
 * entre as estrategias da lista de acordo com sua ordem de entrada.
 * @author yalle carvalho
 *
 */
public class EstrategiaDeJogoComposta implements EstrategiaDeJogo {

	private List<EstrategiaDeJogo> estrategias;
	private int estrategiaPosicao;

	public EstrategiaDeJogoComposta(List<EstrategiaDeJogo> estrategias) {
		this.estrategias = new LinkedList<>(estrategias);
		this.estrategiaPosicao = 0;
	}

	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		Jogada jogada = null;
		
		if (mesa.getNumPecas() == 0) {
			EstrategiaDeJogo estrategia = this.estrategias.get(0);
			jogada =  estrategia.decideJogada(mao, mesa);
		}
			
			EstrategiaDeJogo estrategia = this.estrategias.get(estrategiaPosicao);
			jogada =  estrategia.decideJogada(mao, mesa);
			
			if(estrategiaPosicao == this.estrategias.size()-1) {
				estrategiaPosicao = 0;
			} else {
				estrategiaPosicao++;
			}
			

		return jogada;
	} 

}
