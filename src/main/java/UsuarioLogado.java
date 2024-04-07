public class UsuarioLogado {
    private static Pessoa pessoaLogada;

    // Método para definir a pessoa logada
    public static void setPessoa(Pessoa pessoa) {
        pessoaLogada = pessoa;
    }

    // Método para obter a pessoa logada
    public static Pessoa getPessoa() {
        return pessoaLogada;
    }
}