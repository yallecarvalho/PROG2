package ufcg.ccc.domino;

//import java.util.ArrayList;
import java.util.Comparator;
//import java.util.List;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivelComparadora;
//import ufcg.ccc.domino.estrategia.JogaTrancando;
//import ufcg.ccc.domino.estrategia.EstrategiaDeJogoComposta;


/**
 * Exemplo de como fazer uma disputa entre duas estratégias em uma UI.
 */
public class DominoBrutal {

	public static void main(String[] args) {
		
		//List<EstrategiaDeJogo> estrategias = new ArrayList<>();

		//estrategias.add(new JogaPrimeiraPossivel());

		//estrategias.add(new JogaTrancando());

		//EstrategiaDeJogo estrategiaComposta = new EstrategiaDeJogoComposta(estrategias);
		
		Comparator<Peca> comparador = new PecaPadraoComparator();
		EstrategiaDeJogo estrategiaCmp = new JogaPrimeiraPossivelComparadora(comparador);
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(),  "J2", estrategiaCmp, 12);
		
		
		HistoricoDeJogo historico;
		
		try {
			historico = j.jogaJogoCompleto();
			System.out.println(historico.toString());
		} catch (EstrategiaInvalidaException e) {
			e.printStackTrace();
		} catch (JogadaInvalidaException e) {
			e.printStackTrace();
		}
		
	}

}
