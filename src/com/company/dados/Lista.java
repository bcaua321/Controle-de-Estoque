package com.company.dados;

import com.company.produto.Produto;

import java.util.ArrayList;


public class Lista {
    // Para armazenar todos os produtos
    private static ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();

    public void addElemento(Produto produto){
        Lista.listaDeProdutos.add(produto);
        this.salvarAlteracoes();
    }

    public void removeElemento(int index){
        Lista.listaDeProdutos.remove(index);
        this.salvarAlteracoes();
    }

    // irá setar corretamente o id dos produtos
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
