package view;

import business.GeradorPin;
import business.GeradorSenhaForte;
import business.IGeradorSenha;

public class TestesUnitarios {

    public static void main(String[] args) {
        testarSenhaForte();
        testarPin();

        System.out.println("Todos os testes passaram.");
    }

    private static void testarSenhaForte() {
        IGeradorSenha gerador = new GeradorSenhaForte(12);

        for (int i = 0; i < 100; i++) {
            String senha = gerador.gerarSenha();

            verificar(
                senha.length() == 12,
                "A senha forte deve ter 12 caracteres."
            );

            verificar(
                senha.matches(".*[A-Z].*"),
                "A senha deve conter letra maiúscula."
            );

            verificar(
                senha.matches(".*[a-z].*"),
                "A senha deve conter letra minúscula."
            );

            verificar(
                senha.matches(".*[0-9].*"),
                "A senha deve conter número."
            );

            verificar(
                senha.matches(".*[!@#$%&*?].*"),
                "A senha deve conter caractere especial."
            );
        }

        verificarLancaExcecao();
        System.out.println("Testes de senha forte: OK");
    }

    private static void testarPin() {
        IGeradorSenha gerador = new GeradorPin();

        for (int i = 0; i < 100; i++) {
            String pin = gerador.gerarSenha();

            verificar(
                pin.matches("[0-9]{6}"),
                "O PIN deve conter exatamente 6 dígitos."
            );

            verificar(
                !todosDigitosIguais(pin),
                "O PIN não pode ter todos os dígitos iguais."
            );

            verificar(
                !ehSequencia(pin),
                "O PIN não pode ser uma sequência."
            );
        }

        System.out.println("Testes de PIN: OK");
    }

    private static void verificarLancaExcecao() {
        boolean excecaoLancada = false;

        try {
            new GeradorSenhaForte(11);
        } catch (IllegalArgumentException e) {
            excecaoLancada = true;
        }

        verificar(
            excecaoLancada,
            "Deve rejeitar senha com menos de 12 caracteres."
        );
    }

    private static boolean todosDigitosIguais(String valor) {
        for (int i = 1; i < valor.length(); i++) {
            if (valor.charAt(i) != valor.charAt(0)) {
                return false;
            }
        }

        return true;
    }

    private static boolean ehSequencia(String valor) {
        boolean crescente = true;
        boolean decrescente = true;

        for (int i = 1; i < valor.length(); i++) {
            int anterior = valor.charAt(i - 1) - '0';
            int atual = valor.charAt(i) - '0';

            if (atual != anterior + 1) {
                crescente = false;
            }

            if (atual != anterior - 1) {
                decrescente = false;
            }
        }

        return crescente || decrescente;
    }

    private static void verificar(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new AssertionError(mensagem);
        }
    }
}

