package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 * 
 */
public class DominoBrutalRepetido {
	
	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		float vitoriasJ1 = 0, vitoriasJ2 = 0, empates = 0;
		int vitoriaNormalJ1 = 0, vitoriaLaELoJ1 = 0, vitoriaCarrocaJ1 = 0, vitoriaCruzadaJ1 = 0, vitoriaNormalJ2 = 0, vitoriaLaELoJ2 = 0, vitoriaCarrocaJ2 = 0, vitoriaCruzadaJ2 = 0;

		EstrategiaDeJogo estrategia1 = new JogaPrimeiraPossivel(), estrategia2 = new JogaPrimeiraPossivel(); 
		
		for (int i = 0; i < REPETICOES; i++) {
			
			Jogo j;
			
			// Cada estratégia comeca jogando metade das partidas.
			if( i < REPETICOES / 2) {
				j = new Jogo("J1", estrategia1, "J2", estrategia2, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia2, "J1", estrategia1, NUM_PECAS_INICIAL);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1 ++;
				vitoriaNormalJ1 += historico.getVitoriasNormais();
				vitoriaLaELoJ1 += historico.getVitoriasLaELo();
				vitoriaCarrocaJ1 += historico.getVitoriasCarroca();
				vitoriaCruzadaJ1 += historico.getVitoriasCruzada();

			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2 ++;;
				vitoriaNormalJ2 += historico.getVitoriasNormais();
				vitoriaLaELoJ2 += historico.getVitoriasLaELo();
				vitoriaCarrocaJ2 += historico.getVitoriasCarroca();
				vitoriaCruzadaJ2 += historico.getVitoriasCruzada();
			}
		}

		System.out.println(
				"E1: " + estrategia1.toString() 
				+ "\nE2: " + estrategia2.toString()
				+ "\nJogos:\t" + (REPETICOES) 
				+ "\n \n- Vitórias E1:\t" + vitoriasJ1 + " vitórias (" + Math.round(vitoriasJ1 / REPETICOES * 100) + "%)" + "\n- Tipos de vitórias:"
				+ "\n1. Vitórias Normais E1: " + vitoriaNormalJ1 + "\n2. Vitórias por Carroca E1: " + vitoriaCarrocaJ1 + "\n3. Vitórias por Lá e Lô E1: " + vitoriaLaELoJ1
				+ "\n4. Vitórias por Cruzada E1: " + vitoriaCruzadaJ1
				+ "\n \n- Vitórias E2:\t" + vitoriasJ2 + " vitórias (" + Math.round(vitoriasJ2 / REPETICOES * 100) + "%)" + "\n- Tipos de vitórias:"
				+ "\n1. Vitórias Normais E2: " + vitoriaNormalJ2 + "\n2. Vitórias por Carroca E2: " + vitoriaCarrocaJ2 + "\n3. Vitórias por Lá e Lô E2: " + vitoriaLaELoJ2
				+ "\n4. Vitórias por Cruzada E2: " + vitoriaCruzadaJ2
				+ "\n- Empates:\t" + empates + "\t\t(" + Math.round(empates / REPETICOES * 100) + "%)");
	}

}
