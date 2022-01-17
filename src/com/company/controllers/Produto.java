package com.company.controllers;

public abstract class Produto {
    private int codigo;
    private String produto;
    private String fornecedor;
    private String categoria;

    public Produto(){}

    public Produto(int codigo, String produto, String fornecedor, String categoria){
        this.setCodigo(codigo);
        this.setProduto(produto);
        this.setFornecedor(fornecedor);
        this.setCategoria(categoria);
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
}
