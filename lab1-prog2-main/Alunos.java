/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Yalle Carvalho - 119210523
 */
import java.util.Scanner;

public class Alunos {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String lista = sc.nextLine();
        String[] alunoNota = lista.split(" ");
        int cont = 0;
        int acima = 0;
        int total = 0;
        int abaixo = 0;
        int maior = 0;
        int menor = Integer.parseInt(alunoNota[1]);
        while(!alunoNota[0].equals("-")){
            cont += 1;
            total += Integer.parseInt(alunoNota[1]);
            if (Integer.parseInt(alunoNota[1]) > maior) {
                maior = Integer.parseInt(alunoNota[1]);}
            else if (Integer.parseInt(alunoNota[1]) < menor) {
                menor = Integer.parseInt(alunoNota[1]); }

            if (Integer.parseInt(alunoNota[1]) >= 700) {
                acima += 1;
            } else {
                abaixo += 1;
            } lista = sc.nextLine();
            alunoNota = lista.split(" ");
        }
        int media = total/cont;
        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.println("media: " + media);
        System.out.println("acima: " + acima);
        System.out.println("abaixo: " + abaixo);
    }
 }
