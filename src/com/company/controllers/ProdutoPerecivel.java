package com.company.controllers;

public class ProdutoPerecivel extends Produto{
    private String dataDeValidade;
    private String produtoEh = "perecivel";

    public ProdutoPerecivel() {}

    public ProdutoPerecivel(int codigo, String produto,
                            String fornecedor, String categoria,
                            String dataDeValidade){
        super(codigo, produto, fornecedor, categoria, dataDeValidade);
        this.setDataDeValidade(dataDeValidade);
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public String getProdutoEh() {
        return produtoEh;
    }

    @Override
    public String toString() {
        return "Código: " + this.getCodigo() + "\n" + "Produto: " +
                this.getProduto() + "\n" + "Fornecedor: "
                + this.getFornecedor() + "\n" + "Categoria: " + this.getCategoria()
                 + "\n" + "Data de Validade: " + this.getDataDeValidade();
    }
}
