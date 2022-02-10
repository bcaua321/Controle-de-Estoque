package com.company;
import com.company.dados.Arquivo;
import com.company.menus.MenuPrincipal;
import java.io.IOException;

public class Main {

    // Irá iniciar o app e ler o arquivo txt que contém os dados
    public static void main(String[] args) throws IOException, InterruptedException {
        Arquivo arq = new Arquivo();
        arq.lerArquivo();
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenuPrincipal();
    }
}
