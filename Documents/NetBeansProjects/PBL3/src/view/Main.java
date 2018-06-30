package view;

import controller.Controller;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import model.*;

public class Main {

    public static void main(String[] args) {
        Controller ctr = new Controller();
        ctr.inicia("C:\\Users\\1513 IRON\\Documents\\a");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Qual palavra deseja buscar ?");
            String palavra = input.nextLine();
            ctr.buscarPalavra(palavra);
        }
    }

}
