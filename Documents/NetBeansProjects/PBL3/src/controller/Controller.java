package controller;

import java.io.BufferedReader;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import util.*;

/**
 * Classe que instacia um objeto Controller
 *
 * @author Igor Gonçalves
 */
public class Controller {

    private ArvoreAvl arvorePalavras;
    private LinkedList listaPaginas;
    private ArvoreAvl rankingPalavras;
    private LinkedList topMaisBuscadas;

    private LinkedList topMenosBuscadas;
    private Quicksort qSort;

    public Controller() {
        qSort = new Quicksort();
        topMenosBuscadas = new LinkedList();
        topMaisBuscadas = new LinkedList();
        rankingPalavras = new ArvoreAvl();
        arvorePalavras = new ArvoreAvl();
        listaPaginas = new LinkedList();
    }

    /**
     * Método que inicia o programa. Abre os arquivos e armazena todas as
     * palavras em uma arvore AVL.
     *
     * @param url caminho da pasta onde estão os arquivos a serem lidos.
     */
    public void inicia(String url) {
        int cont = 0;
        File folder = new File(url);
        File[] listaArquivos = folder.listFiles();
        for (File nomeArq : listaArquivos) {
            cont++;

            System.out.println("Abrindo arquivo: " + cont);
            Pagina pagina = new Pagina();
            pagina.setNomeArquivo(nomeArq.getName());
            listaPaginas.add(pagina);
            try {
                FileReader arq = new FileReader(nomeArq);
                BufferedReader lerArq = new BufferedReader(arq);

                String lines = lerArq.readLine();

                while (lines != null) { //lendo todas as linhas do arquivo
                    String[] arrayPalavras = lines.split("[,.!:;?] *| +");
                    for (String s : arrayPalavras) {
                        Palavra pal = arvorePalavras.busca(s);
                        Pagina paginaClone = pagina.clone();
                        paginaClone.setOcorenciaDaPalavras(1);
                        if (pal != null) {//A palavra ja existe
                            if (this.jaExiste(pal.getPaginas(), paginaClone) == false) {
                                pal.insereArquivo(paginaClone);
                            }
                        } else {//Só entra com palavras novas
                            Palavra p = new Palavra(s, paginaClone);
                            arvorePalavras.inserir(p);
                        }

                    }
                    lines = lerArq.readLine();
                }

                arq.close();

            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                        e.getMessage());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * Método auxilir para verificar se ja existe uma página(Passada por
     * parâmetro),em uma lista de páginas(também passada por parametro).
     *
     * @param paginas lista de páginas
     * @param pagina página
     * @return true se existe a lista e false caso não exista
     */
    public boolean jaExiste(LinkedList paginas, Pagina pagina) {
        if (paginas.contains(pagina)) {
            int index = paginas.indexOf(pagina);
            Pagina pag = (Pagina) paginas.get(index);
            pag.incrementaOcorrecia();
            return true;
        }
        return false;
    }

    /**
     * Busca uma palavra na arvore e informa a quantidade de vezes que ela
     * aparece em uma página
     *
     * @param palavra Uma String a ser buscada
     * @return a lista de paginas da palavra buscada
     */
    public LinkedList buscarPalavra(String palavra) {
        Palavra palavraBuscada = this.getArvorePalavras().busca(palavra);
        if (palavraBuscada != null) {
            palavrasMaisBuscadas(palavraBuscada);
            LinkedList listaPagina = palavraBuscada.getPaginas();
            listaPagina = OrdenaPaginasRelevanciaDecrescente(listaPagina);
            System.out.println("A palavra " + palavraBuscada.toString() + ", foi encontrada:");
            Iterator itr = listaPagina.iterator();
            while (itr.hasNext()) {
                Pagina p = (Pagina) itr.next();

                System.out.println(p.getOcorenciaDaPalavras() + " vezes " + p.toString());
            }
            return listaPagina;
        } else {
            System.out.println("Palavra não encontrada!");
        }
        return null;
    }

    /**
     * Ordena uma lista de páginas em ordem Crescente de ocorrências de uma
     * palavra buscada
     *
     * @param paginas uma lista de páginas
     * @return uma lista de páginas ordenadas
     */
    public LinkedList OrdenaPaginasRelevanciaCrescente(LinkedList paginas) {
        MergeSort mSort = new MergeSort();
        Pagina[] p = new Pagina[paginas.size()];

        for (int i = 0; i < p.length; i++) {
            p[i] = (Pagina) paginas.get(i);
        }
        mSort.mergeSort(p);
        LinkedList newList = new LinkedList();
        newList.addAll(Arrays.asList(p));
        Collections.reverse(newList);
        return newList;
    }

    /**
     * Ordena uma paginas de páginas em ordem Decrescente de ocorrências de uma
     * palavra buscada
     *
     * @param paginas uma paginas de páginas
     * @return uma paginas de páginas ordenadas
     */
    public LinkedList OrdenaPaginasRelevanciaDecrescente(LinkedList paginas) {
        MergeSort mSort = new MergeSort();
        Pagina[] p = new Pagina[paginas.size()];

        for (int i = 0; i < p.length; i++) {
            p[i] = (Pagina) paginas.get(i);
        }
        mSort.mergeSort(p);
        LinkedList newList = new LinkedList();
        newList.addAll(Arrays.asList(p));
        return newList;
    }

    /**
     * Método auxiliar usado para incrementar a quantidade de vezes que uma
     * palavra foi buscada, adicionando-as numa lista
     *
     * @param palavra uma palavra a ser incrementada
     */
    public void palavrasMaisBuscadas(Palavra palavra) {
        rankingPalavras.inserir(palavra);
        Palavra pRepetida = rankingPalavras.busca(palavra.getPalavra());
        if (pRepetida != null) {
            pRepetida.incrementaQntdBusca();
        }
    }

    /**
     * Joga numa lista as 5 palavras mais buscadas
     */
    public void top5MaisBuscadas() {
        LinkedList listaMaisBuscadas = rankingPalavras.inorder();
        Palavra[] p = this.passaParaArray(listaMaisBuscadas);

        qSort.quickSort(p);

        for (int i = 0; i < 5; i++) {
            topMaisBuscadas.add(p[i]);
        }
        Collections.reverse(topMaisBuscadas);
    }

    /**
     * Joga numa lista as 5 palavras menos buscadas
     */
    public void top5MenosBuscadas() {
        LinkedList listaMenosBuscadas = rankingPalavras.inorder();
        Palavra[] p = this.passaParaArray(listaMenosBuscadas);
        qSort.quickSort(p);
        for (int i = 0; i < 5; i++) {
            topMenosBuscadas.add(p[i]);
        }
    }

    /**
     * Recebe uma lista de palavras e a transforma em um array de palavras
     *
     * @param lista recebe uma lista
     * @return retorna um array de palavras
     */
    private Palavra[] passaParaArray(LinkedList lista) {
        Palavra[] p = new Palavra[lista.size()];
        for (int i = 0; i < p.length; i++) {
            p[i] = (Palavra) lista.get(i);
        }
        return p;
    }

    public LinkedList getTopMaisBuscadas() {
        return topMaisBuscadas;
    }

    public LinkedList getTopMenosBuscadas() {
        return topMenosBuscadas;
    }

    /**
     * Método getter da arvore de palavras
     *
     * @return arvore de palavras
     */
    public ArvoreAvl getArvorePalavras() {
        return arvorePalavras;
    }
}
