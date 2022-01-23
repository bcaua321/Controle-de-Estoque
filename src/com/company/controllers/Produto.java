package com.company.controllers;

public abstract class Produto {
    private int id;
    private int codigo;
    private String produto;
    private String fornecedor;
    private String categoria;
    private String produtoEh;

    public Produto(){}

    public Produto(int id, int codigo, String produto, String fornecedor, String categoria){
        this.id = id;
        this.codigo = codigo;
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
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

    public String getProdutoEh() { return produtoEh; }
}
