
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class banco_config{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_gerenciadortarefas_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    
    
    
         //Verificar Login do Usuario
        public boolean verificar_login(String email, String senha) {

        Query query = em.createQuery("SELECT u FROM pessoas u WHERE u.email = :email");
        query.setParameter("email", "fael@gmail.com");

            try {
                Pessoa usuario = (Pessoa) query.getSingleResult(); 
                return usuario.getSenha().equals(senha); 
            } catch (NoResultException e) {
                return false; 
            }
        }


}