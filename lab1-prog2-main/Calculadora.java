/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Yalle Carvalho - 119210523
 */
import java.util.Scanner;

public class Calculadora {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String operacao = sc.nextLine();

        if (operacao.equals("+")) {
            float num1 = sc.nextFloat();
            float num2 = sc.nextFloat();
            float soma = num1 + num2;
            System.out.println("RESULTADO: " + soma);
            } else if (operacao.equals("-")) {
                    float num1 = sc.nextFloat();
                    float num2 = sc.nextFloat();
                    float sub = num1 - num2;
                    System.out.println("RESULTADO: " + sub);
            } else if (operacao.equals("*")) {
                float num1 = sc.nextFloat();
                float num2 = sc.nextFloat();
                float mult = num1 * num2;
                System.out.println("RESULTADO: " + mult);
            } else if (operacao.equals("/")) {
                float num1 = sc.nextFloat();
                float num2 = sc.nextFloat();
                if (num2 == 0){
                    System.out.println("ERRO");
                    } else {
                        float div = num1 / num2;
                        System.out.println("RESULTADO: " + div);
                }
        } else {
            System.out.println("ENTRADA INVALIDA");

                        }
                    }
                }