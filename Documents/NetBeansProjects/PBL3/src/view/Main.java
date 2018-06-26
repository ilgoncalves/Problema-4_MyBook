package view;

import controller.Controller;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Controller ctr = new Controller();
        ctr.lerArquivos("C:\\Users\\1513 IRON\\Documents\\arquivos");
        Scanner input = new Scanner(System.in);
        System.out.println("Qual palavra deseja buscar ?");
        String palavra = "Deus";
        if (ctr.getArvorePalavras().busca(palavra)) {
            System.out.println("Entrou");
        }
        System.out.println(ctr.getArvorePalavras().getPalavraEncontrada().toString());

    }

}
