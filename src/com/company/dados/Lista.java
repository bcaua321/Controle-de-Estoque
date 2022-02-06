package com.company.dados;

import com.company.produto.Produto;

import java.util.ArrayList;


public class Lista {
    private static ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();

    public void addElemento(Produto produto){
        Lista.listaDeProdutos.add(produto);
        salvarAlteracoes();
    }

    public void removeElemento(int index){
        Lista.listaDeProdutos.remove(index);
        this.salvarAlteracoes();
    }

    // irá criar um novo "banco de dados"
    public void salvarAlteracoes(){
        int i = 0;
        Arquivo arq = new Arquivo();
        for (Produto produto: this.getListaDeProdutos()) {
            produto.setId(i);
            i++;
        }
        arq.criaArquivo();
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return Lista.listaDeProdutos;
    }
}
