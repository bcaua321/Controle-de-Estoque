package com.company.produto;

public class Produto {
    private int id;
    private int codigo;
    private String produtoNome;
    private double preco;
    private String fornecedor;
    private String categoria;
    private String dataDeCompra;
    private long dataComparar;

    public Produto(){}

    public Produto(int id, int codigo, String produtoNome, double preco, String fornecedor, String categoria, String dataDeCompra){
        this.id = id;
        this.codigo = codigo;
        this.produtoNome = produtoNome;
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

    public String getProdutoNome() {
        return this.produtoNome;
    }

    public void setProdutoNome(String produto) {
        this.produtoNome = produto;
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
                this.getProdutoNome() + "\n" + "Fornecedor: "
                + this.getFornecedor() + "\n" + "Categoria: " + this.getCategoria()
                + "\n" + "Data de Validade: " + this.getDataDeCompra();
    }
}
