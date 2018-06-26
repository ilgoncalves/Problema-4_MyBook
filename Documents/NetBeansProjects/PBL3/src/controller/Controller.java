package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import model.*;
import util.*;

public class Controller {

    private ArvoreAvl arvorePalavras;
    private LinkedList listaPaginas;

    public Controller() {
        arvorePalavras = new ArvoreAvl();
        listaPaginas = new LinkedList();
    }

    public void lerArquivos(String url) {
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

                while (lines != null) {
                    String[] arrayPalavras = lines.split("[,.!:;?] *| +");
                    for (String s : arrayPalavras) {
                        arvorePalavras.inserir(new Palavra(pagina, s));
                    }
                    lines = lerArq.readLine();
                }

                arq.close();
            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                        e.getMessage());
            }
        }
    }

    public void buscador() {

    }

    public ArvoreAvl getArvorePalavras() {
        return arvorePalavras;
    }
}
