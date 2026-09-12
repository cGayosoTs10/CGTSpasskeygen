package view;

import business.GeradorPin;
import business.GeradorSenhaForte;
import business.IGeradorSenha;

// Feito por Cauê Gayoso Tavares da Silva, sem Dupla.

public class Principal {

    public static void main(String[] args) {

        IGeradorSenha gerador;

        gerador = new GeradorSenhaForte(12);

        System.out.println("Senha forte 1: " + gerador.gerarSenha());
        System.out.println("Senha forte 2: " + gerador.gerarSenha());

        gerador = new GeradorPin();
	System.out.println("Feito por Cauê Gayoso Tavares da Silva.");
        System.out.println("PIN 1: " + gerador.gerarSenha());
        System.out.println("PIN 2: " + gerador.gerarSenha()); // Debug basicão.
    }
}

