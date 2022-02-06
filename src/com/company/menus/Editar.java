package com.company.menus;

import com.company.dados.Lista;
import com.company.produto.Produto;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Editar {
    Lista lista = new Lista();
    MenuPrincipal menu = new MenuPrincipal();
    Mostrar mostrar = new Mostrar();
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static Scanner input = new Scanner(System.in);

    public void continuarEditar() {
        System.out.println("Deseja continuar?\n1 - SIM\t\t2 - NAO");
        int valor = 0;
        try {
            valor = input.nextInt();
        } catch (InputMismatchException ex){
            input.next();
        }

        switch(valor){
            case 1:
                this.editarProduto();
                break;
            case 2:
                mostrar.manipularProdutos();
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
                continuarEditar();
        }

    }

    public void editarProduto(){
        Mostrar.mostrarProdutos(lista.getListaDeProdutos());
        System.out.println("Digite o ID do produto que deseja EDITAR:");
        int valor = input.nextInt();
        if(valor < lista.getListaDeProdutos().size() && valor>= 0){
            this.editarItem(valor);
            return;
        } else {
            while(true){
                System.out.println(ANSI_RED + "Não exite produto com esse ID\n" + ANSI_RESET);
                this.continuarEditar();
            }
        }
    }

    public void editarItem(int n){
        Produto item = lista.getListaDeProdutos().get(n);
        System.out.println("\n" + item.toString());

        Opcoes.menuEditar();
        System.out.println("\nEscolha a opcao");
        int valor = 0;
        try {
            valor = input.nextInt();
        } catch (InputMismatchException ex){
            input.next();
        }
        /*
        ANSI_CYAN + "====================================" + ANSI_RESET,
                ANSI_PURPLE + "1 " + ANSI_RESET + "- Codigo" + "\t\t\t\t\t\t\t|",
                ANSI_PURPLE + "2 " + ANSI_RESET  + "- Produto" + "\t\t\t\t\t\t\t|",
                ANSI_PURPLE + "3 " + ANSI_RESET  + "- Preco" + "\t\t\t\t\t\t\t|",
                ANSI_PURPLE + "4 " + ANSI_RESET + "- Fornecedor" + "\t\t\t\t\t\t|",
                ANSI_PURPLE + "5 " + ANSI_RESET + "- Categoria" + "\t\t\t\t\t\t|",
                ANSI_PURPLE + "6 " + ANSI_RESET + "- Data de Compra" + "\t\t\t\t\t|",
                ANSI_CYAN + "====================================" + ANSI_RESET

         */
        switch(valor){
            case 1:
                EditarOpcao.codigo(item);
                break;
            case 2:
                EditarOpcao.nome(item);
                break;
            case 3:
                 EditarOpcao.preco(item);
                 break;
            case 4:
                 EditarOpcao.fornecedor(item);
                 break;
            case 5:
                 EditarOpcao.categoria(item);
                 break;
            case 6:
                 EditarOpcao.data(item);
                 break;
            case 7:
                mostrar.manipularProdutos();
                break;
            default:
                System.out.println(ANSI_RED + "Opção inválida" + ANSI_RESET);
                continuarEditar();
        }

        lista.salvarAlteracoes();
        editarItem(n);
    }
}

class EditarOpcao {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static Scanner input = new Scanner(System.in);

    public static void codigo(Produto item){
        int valor = 0;
        System.out.print("Insira o novo código: ");
        try {
            valor = input.nextInt();
            item.setCodigo(valor);

            System.out.println(ANSI_CYAN + "Valor editado!" + ANSI_RESET);
        } catch (InputMismatchException ex){
            System.out.println(ANSI_RED + "Valor Inválido!" + ANSI_RESET);
            input.next();
        }
    }

    public static void nome(Produto item){
        try {
            String nome = "";
            System.out.print("Insira o novo nome: ");
            nome = input.nextLine();
            item.setProdutoNome(nome);

            System.out.println(ANSI_CYAN + "Valor editado!" + ANSI_RESET);
        } catch (InputMismatchException ex){
            input.next();
        }
    }

    public static void preco(Produto item){
        try {
            double valor = 0;
            System.out.print("Insira o novo preco: ");
            valor = input.nextDouble();
            item.setPreco(valor);
            System.out.println(ANSI_CYAN + "Valor editado!" + ANSI_RESET);
        } catch (InputMismatchException ex){
            System.out.println(ANSI_RED + "Valor Inválido!" + ANSI_RESET);
            input.next();
        }
    }

    public static void fornecedor(Produto item){
        try {
            String nome;
            System.out.print("Insira o novo nome do fornecedor: ");
            nome = input.nextLine();
            item.setFornecedor(nome);

            System.out.println(ANSI_CYAN + "Valor editado!" + ANSI_RESET);
        } catch (Exception e){
            System.out.println(ANSI_RED + "Erro ao editar" + ANSI_RESET);
            input.next();
        }
    }

   public static void categoria(Produto item){
        try{
            String categoria;
            System.out.print("Insira a nova categoria: ");
            categoria = input.nextLine();
            item.setCategoria(categoria);

            System.out.println(ANSI_CYAN + "Valor editado!" + ANSI_RESET);
        } catch (Exception e){
            System.out.println(ANSI_RED + "Erro ao editar" + ANSI_RESET);
            input.next();
        }
    }
    public static void data(Produto item){
        try{
            String data;
            System.out.print("Insira a nova data: ");
            data = input.nextLine();
            item.setDataDeCompra(data);

            System.out.println(ANSI_CYAN + "Valor editado!" + ANSI_RESET);
        } catch (Exception e){
            System.out.println(ANSI_RED + "Erro ao editar" + ANSI_RESET);
            input.next();
        }
    }
}
