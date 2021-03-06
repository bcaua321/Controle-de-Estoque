package com.company.dados;

import com.company.produto.Produto;

import java.util.*;

// Para criar um novo arraylist para ordenar
public class OrdenaLista{
    Lista listaProdutos = new Lista();
    Date data;

    static class ProdutoItem {
        Produto produto;

        ProdutoItem(Produto produto) {
            this.produto = produto;
        }
    }

    static class SortByDate implements Comparator<ProdutoItem> {
        @Override
        public int compare(ProdutoItem a, ProdutoItem b) {
            return a.produto.getDataDeCompra().compareTo(b.produto.getDataDeCompra());
        }
    }

    public void ordenarLista(){
        ArrayList<ProdutoItem> listaOrdenada = new ArrayList<>();
        for (Produto produto: listaProdutos.getListaDeProdutos()) {
            listaOrdenada.add(new ProdutoItem(produto));
        }
        Collections.sort(listaOrdenada, new SortByDate());
        System.out.println("Lista ordenada: ");

        for (ProdutoItem p: listaOrdenada) {
            System.out.println(p.produto.toString());
            System.out.println();
        }
    }
}


