
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
                UsuarioLogado.setPessoa(pessoa);
                if (pessoa.getSenha().equals(senha)) {
                    
                    
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
        
        
        Query query = em.createQuery("SELECT COUNT (p) FROM Pessoa p WHERE p.email = :email");
        query.setParameter("email", email);
        long count = (long) query.getSingleResult();
        if (count > 0){
            return "Email já registrado";
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
    
    /*public String criarTarefa(String titulo, String descricao, Date data_criada, Date data_finalizada, boolean concluida, int criador , boolean prioridade , int responsavel){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(titulo == null || descricao == null || data_criada == null || data_finalizada == null || concluida == null || criador == null || prioridade == null || responsavel){
        return "Preencha Todos os Campos";
    }
        
        
        
        
        return "ok";
    }*/
}
