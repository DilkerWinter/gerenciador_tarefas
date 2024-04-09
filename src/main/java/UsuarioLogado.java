public class UsuarioLogado {
    private static Pessoa pessoaLogada;
    
    public static void setPessoa(Pessoa pessoa) {
        pessoaLogada = pessoa;
    }
    
    public static Pessoa getPessoa() {
        return pessoaLogada;
    }
}