package business;

public class GeradorSenhaForte extends GeradorSenha {
    private final int tamanho;
    public GeradorSenhaForte(int tamanho) {
        if (tamanho < 12) {
            throw new IllegalArgumentException(
                "A senha precisa ter pelo menos 12 caracteres."
            );
        }

        this.tamanho = tamanho;
    }

    @Override
    public String gerarSenha() {
	StringBuilder senha = new StringBuilder(tamanho);

	senha.append(sortearCaractere(MAIUSCULAS));
        senha.append(sortearCaractere(MINUSCULAS));
        senha.append(sortearCaractere(NUMEROS));
        senha.append(sortearCaractere(ESPECIAIS));

	String todosCaracteres =
	    MAIUSCULAS + MINUSCULAS + NUMEROS + ESPECIAIS;

	while (senha.length() < tamanho) {
	    senha.append(sortearCaractere(todosCaracteres));
        }
    
	return embaralhar(senha.toString());
    }
}
