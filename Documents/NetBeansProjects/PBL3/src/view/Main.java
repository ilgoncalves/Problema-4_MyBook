package view;

import controller.Controller;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import model.*;
import util.Console;
import java.io.IOException;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        Controller ctr = new Controller();
//        ctr.inicia("C:\\Users\\1513 IRON\\Documents\\a");

        System.out.println("----------------Entre com o diretório dos arquivos----------------");
        String diretorio = Console.readString();
        ctr.inicia(diretorio);

        boolean repeteMenuPrincipal = false;
        do {
            System.out.println("__________________________________________________________________");
            System.out.println("|                             Menu                               |");
            System.out.println("__________________________________________________________________");
            System.out.println("|                                                                |");
            System.out.println("|    [1]- Buscar Pagínas                                         |");
            System.out.println("|    [2]- Top5 palavras mais buscadas                            |");
            System.out.println("|    [3]- Top5 palavras menos buscadas                           |");
            System.out.println("|    [4]- Sair                                                   |");
            System.out.println("|________________________________________________________________|");
            int opcao = Console.readInt();
            switch (opcao) {
                case 1:
                    boolean repeteSubMenu = false;
                    System.out.println("Digite a palavra a ser buscada:");
                    String palavra = Console.readString();
                    LinkedList listaPaginas = ctr.buscarPalavra(palavra);
                    do {
                        System.out.println("");
                        System.out.println("__________________________________________________________________");
                        System.out.println("|                             Menu                               |");
                        System.out.println("__________________________________________________________________");
                        System.out.println("|                                                                |");
                        System.out.println("|    [1]- Ordenar resultados em ordem crescente de ocorrencias   |");
                        System.out.println("|    [2]- Ordenar resultados em ordem decrescente de ocorrencias |");
                        System.out.println("|    [3]- Voltar ao menu Principal                               |");
                        System.out.println("|    [4]- Sair                                                   |");
                        System.out.println("|________________________________________________________________|");
                        int lerSubMenu = Console.readInt();
                        switch (lerSubMenu) {
                            case 1:
                                LinkedList newListC = ctr.OrdenaPaginasRelevanciaCrescente(listaPaginas);
                                System.out.println("A palavra " + palavra + ", foi encontrada:");
                                Iterator itr = newListC.iterator();
                                while (itr.hasNext()) {
                                    Pagina p = (Pagina) itr.next();

                                    System.out.println(p.getOcorenciaDaPalavras() + " vezes " + p.toString());

                                }
                                repeteSubMenu = true;
                                break;
                            case 2:
                                LinkedList newListD = ctr.OrdenaPaginasRelevanciaDecrescente(listaPaginas);
                                System.out.println("A palavra " + palavra + ", foi encontrada:");
                                Iterator itr2 = newListD.iterator();
                                while (itr2.hasNext()) {
                                    Pagina p = (Pagina) itr2.next();

                                    System.out.println(p.getOcorenciaDaPalavras() + " vezes " + p.toString());
                                }
                                repeteSubMenu = true;

                                break;
                            case 3:
                                repeteSubMenu = false;
                                repeteMenuPrincipal = true;
                                break;
                            case 4:
                                repeteSubMenu = false;
                                repeteMenuPrincipal = false;
                                break;
                            default:
                                System.out.println("Opção inválida");
                                System.out.println("Digite Novamente:");
                                repeteSubMenu = true;
                        }
                    } while (repeteSubMenu);

                    break;
                case 2:
                    LinkedList topMais = ctr.getTopMaisBuscadas();
                    if (topMais.size() < 5) {
                        System.out.println("É necessario mais de 5 palavras buscadas para exibir essa opção");
                    } else {
                        System.out.println("As palavras Mais buscadas foram:");
                        int cont = 1;
                        for (Object p : topMais) {
                            Palavra pal = (Palavra) p;
                            System.out.println(cont + "º- " + pal.toString() + " com " + pal.getQntBuscas() + " vezes buscadas");
                            cont++;
                        }
                    }
                    repeteMenuPrincipal = true;
                    break;
                case 3:
                    LinkedList topMenos = ctr.getTopMenosBuscadas();
                    Collections.reverse(topMenos);
                    if (topMenos.size() < 5) {
                        System.out.println("É necessario mais de 5 palavras buscadas para exibir essa opção");
                    } else {
                        System.out.println("As palavras Menos buscadas foram:");
                        int cont = 1;
                        for (Object p : topMenos) {
                            Palavra pal = (Palavra) p;
                            System.out.println(cont + "º- " + pal.toString() + " com " + pal.getQntBuscas() + " vezes buscadas");
                            cont++;
                        }
                    }
                    repeteMenuPrincipal = true;
                    break;
                case 4:
                    repeteMenuPrincipal = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("Digite Novamente:");
                    repeteMenuPrincipal = true;
                    break;
            }
        } while (repeteMenuPrincipal);
    }

}
