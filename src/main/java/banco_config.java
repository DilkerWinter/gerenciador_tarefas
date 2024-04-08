
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class banco_config{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_gerenciadortarefas_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    
    
    
        //Verificar Login do Usuario
        public boolean verificar_login(String email, String senha) {
        Query query = em.createQuery("SELECT p FROM Pessoa p WHERE p.email = :email");
        query.setParameter("email", email);

        try {
            Pessoa pessoa = (Pessoa) query.getSingleResult();

            if (pessoa != null) {
                if (pessoa.getSenha().equals(senha)) {
                    UsuarioLogado.setPessoa(pessoa);
                    return true; 
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (NoResultException e) {
            return false; 
        } catch (Exception e) {
            
            return false; 
        }
    }
        
        public String executar_cadastro(String nome, String email, String senha){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        
        if (nome == null || nome.isEmpty() || email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
        return "Preencha todos os campos"; 
        }
        
        
        Query queryEmail = em.createQuery("SELECT COUNT (p) FROM Pessoa p WHERE p.email = :email");
        queryEmail.setParameter("email", email);
        long countEmail = (long) queryEmail.getSingleResult();
        if (countEmail > 0){
            return "Email já registrado";
        }
        Query querynome = em.createQuery("SELECT COUNT (p) FROM Pessoa p WHERE p.nome = :nome");
        querynome.setParameter("nome", nome);
        long countNome = (long) querynome.getSingleResult();
        if (countNome > 0){
            return "Nome já resgistrado";
        }
        
        
        try {
            Pessoa pessoa = new Pessoa();
            pessoa.setNome(nome);
            pessoa.setEmail(email);
            pessoa.setSenha(senha);

            em.persist(pessoa);
            transaction.commit();
            return "ok";
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Erro no Sistema";
        }       
    }
        
    public List<Long> buscarIdsPessoas() {
        Query query = em.createQuery("SELECT p.ID FROM Pessoa p");
        return query.getResultList();
    }
    public List<Long> buscarNomesPessoas() {
        Query query = em.createQuery("SELECT p.nome FROM Pessoa p");
        return query.getResultList();
    }
    
    public List<Pessoa> buscarTodasPessoas() {
        Query query = em.createQuery("SELECT p FROM Pessoa p");
        return query.getResultList();
    }
    
    public Pessoa buscarPessoaPorNome(String nome){
        Query query = em.createQuery("SELECT p FROM Pessoa p WHERE p.nome = :nome");
        query.setParameter("nome", nome);
        return (Pessoa) query.getSingleResult();
    }

    
    public String criarTarefa(String titulo, String descricao, Date data_criada, Date data_finalizada, boolean concluida, Pessoa criador , boolean prioridade , String responsavel) throws ParseException{

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        if(titulo == null || titulo.isEmpty() || descricao == null || descricao.isEmpty() || data_finalizada == null ){
            return "Preencha Todos os Campos";
        }
        
        Pessoa pessoaResponsavel = buscarPessoaPorNome(responsavel);
        
        
        
        
        
        
        
        
        Tarefas tarefa = new Tarefas();
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setDataCriada(data_criada);
        tarefa.setDataEntrega(data_finalizada);
        tarefa.setConcluida(concluida);
        tarefa.setCriador(criador);
        tarefa.setPrioridade(prioridade);
        tarefa.setResponsavel(pessoaResponsavel);

        em.persist(tarefa);
        transaction.commit();
        return "ok";
    }

}
