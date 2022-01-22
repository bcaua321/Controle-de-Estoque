package com.company.controllers;

import java.util.Scanner;

public class ProdutoNaoPerecivel extends Produto {
    private String dataDeCompra;
    private String produtoEh = "nPerecivel";

    public ProdutoNaoPerecivel() {}

    public ProdutoNaoPerecivel(int codigo, String produto, String fornecedor, String categoria, String dataDeCompra){
        super(codigo, produto, fornecedor, categoria, dataDeCompra);
    }

    public String getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(String dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    public String getProdutoEh() {
        return produtoEh;
    }
    @Override
    public String toString() {
        return "Código: " + this.getCodigo() + "\n" + "Produto: " +
                this.getProduto() + "\n" + "Fornecedor: "
                + this.getFornecedor() + "\n" + "Categoria: " + this.getCategoria()
                + "\n" + "Data de Compra: " + this.getDataDeCompra();
    }
}
