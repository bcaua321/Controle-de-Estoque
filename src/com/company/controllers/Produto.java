package com.company.controllers;

import java.util.Date;

public class Produto {
    private int id;
    private int codigo;
    private String produto;
    private double preco;
    private String fornecedor;
    private String categoria;
    private String dataDeCompra;
    private long dataComparar;

    public Produto(){}

    public Produto(int id, int codigo, String produto, double preco, String fornecedor, String categoria, String dataDeCompra){
        this.id = id;
        this.codigo = codigo;
        this.produto = produto;
        this.preco = preco;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.dataDeCompra = dataDeCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return this.produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(String dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    public long getDataComparar() {
        return dataComparar;
    }

    public void setDataComparar(long dataComparar) {
        this.dataComparar = dataComparar;
    }

    @Override
    public String toString() {
        return  "id:" +this.getId() + "\n"+ "Código: " + this.getCodigo() + "\n" + "Produto: " +
                this.getProduto() + "\n" + "Fornecedor: "
                + this.getFornecedor() + "\n" + "Categoria: " + this.getCategoria()
                + "\n" + "Data de Validade: " + this.getDataDeCompra();
    }
}
