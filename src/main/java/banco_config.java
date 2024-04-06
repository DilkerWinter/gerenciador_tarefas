import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class banco_config {
    private EntityManagerFactory entityManagerFactory;

    public banco_config(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    
    public boolean verificarCredenciais(String email, String senha) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Pessoa> query = entityManager.createQuery(
            "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.email = :email", Pessoa.class);

            query.setParameter("email", email);
            Pessoa pessoa = query.getSingleResult(); 

            if (pessoa != null && pessoa.getSenha().equals(senha)) {
                return true; 
            }
        } catch (NoResultException e) {
            // Nenhum resultado encontrado para o email fornecido
            e.printStackTrace();
        } catch (Exception e) {
            // Outra exceção ocorreu
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return false; 
    }
}
