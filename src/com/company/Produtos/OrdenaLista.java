package com.company.Produtos;

import com.company.controllers.Produto;

import java.util.Date;

public class OrdenaLista {
    Lista listaProdutos = new Lista();
    Date data;
    public void convertDate(){
        for (Produto produto: listaProdutos.getListaDeProdutos()) {
            data = new Date();
            data.parse(produto.getDataDeCompra());
            produto.setDataComparar(data.getTime());
        }
    }

    public void ordenarLista(){
        this.convertDate();
        for (Produto produto: listaProdutos.getListaDeProdutos()) {
            System.out.println(produto.getDataComparar());
        }
    }
}
