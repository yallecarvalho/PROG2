/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Yalle Carvalho - 119210523
 */

import java.util.Scanner;

public class AcimaDaMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numeros = sc.nextLine();
        String[] valores = numeros.split(" ");
        int soma = 0;
        double media = 0;
        int div = valores.length;

        for (int i = 0; i < valores.length; i++) {
            soma += Integer.parseInt(valores[i]);
        }
        media = soma / div;
        String saida = "";
        for (int i = 0; i < valores.length; i++) {
            if (Integer.parseInt(valores[i]) > media) {
                saida += valores[i] + " ";
            }
        }
        System.out.println(saida);
    }
}