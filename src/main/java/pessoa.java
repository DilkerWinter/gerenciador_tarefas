import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    private Long id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "senha")
    private String senha;

    public String getSenha() {
        return senha;
    }

    
}
