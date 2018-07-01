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

public class Controller {

    private ArvoreAvl arvorePalavras;
    private LinkedList listaPaginas;

    public Controller() {
        arvorePalavras = new ArvoreAvl();
        listaPaginas = new LinkedList();
    }

    public void inicia(String url) {
        int cont = 0;
        File folder = new File(url);
        File[] listaArquivos = folder.listFiles();
        for (File nomeArq : listaArquivos) {
            cont++;

            System.out.println(cont);
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
                            arvorePalavras.inserir(p, paginaClone);
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

    public boolean jaExiste(LinkedList paginas, Pagina pagina) {
        if (paginas.contains(pagina)) {
            int index = paginas.indexOf(pagina);
            Pagina pag = (Pagina) paginas.get(index);
            pag.incrementaOcorrecia();
            return true;
        }
        return false;
    }

    public void buscarPalavra(String palavra) {
        Palavra palavraBuscada = this.getArvorePalavras().busca(palavra);
        if (palavraBuscada != null) {
            LinkedList listaPagina = palavraBuscada.getPaginas();
            listaPagina = OrdenaPaginasRelevanciaDecrescente(listaPagina);
            System.out.println("A palavra " + palavraBuscada.toString() + ", foi encontrada:");
            Iterator itr = listaPagina.iterator();
            while (itr.hasNext()) {
                Pagina p = (Pagina) itr.next();

                System.out.println(p.getOcorenciaDaPalavras() + " vezes " + p.toString());
            }
        } else {
            System.out.println("Palavra não encontrada!");
        }
    }

    public LinkedList OrdenaPaginasRelevanciaCrescente(LinkedList lista) {
        MergeSort mSort = new MergeSort();
        Pagina[] p = new Pagina[lista.size()];

        for (int i = 0; i < p.length; i++) {
            p[i] = (Pagina) lista.get(i);
        }
        mSort.mergeSort(p);
        LinkedList newList = new LinkedList();
        newList.addAll(Arrays.asList(p));
        Collections.reverse(newList);
        return newList;
    }

    public LinkedList OrdenaPaginasRelevanciaDecrescente(LinkedList lista) {
        MergeSort mSort = new MergeSort();
        Pagina[] p = new Pagina[lista.size()];

        for (int i = 0; i < p.length; i++) {
            p[i] = (Pagina) lista.get(i);
        }
        mSort.mergeSort(p);
        LinkedList newList = new LinkedList();
        newList.addAll(Arrays.asList(p));
        return newList;
    }

    public ArvoreAvl getArvorePalavras() {
        return arvorePalavras;
    }
}
