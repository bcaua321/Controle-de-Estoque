package com.company.Produtos;

import com.company.controllers.Produto;

import java.util.ArrayList;
import java.util.Scanner;


public class Lista {
    private static ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();

    public void addElemento(Produto produto){
        Arquivo arq = new Arquivo();
        Lista.listaDeProdutos.add(produto);
        arq.criaArquivo();
    }

    public void removeElemento(int index){
        Arquivo arq = new Arquivo();
        Lista.listaDeProdutos.remove(index);
        arq.criaArquivo();
    }

    public void editaElemento(int index){
        Arquivo arq = new Arquivo();
        Lista.listaDeProdutos.get(index);
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return Lista.listaDeProdutos;
    }
}
