
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    // Get id
    int getID() {
        return ID;
    }
    
    
    //Get e Setter Nome
    void setNome(String nome) {
        this.nome = nome;
    }
    
    String getNome() {
        return nome;
    }
    
    
    //Get e Setter Email
    void setEmail(String email){
        this.email = email;
    }
    
    String getEmail() {
        return email;
    }
    
    
    
    //Get e Setter Senha
    void setSenha(String senha){
        this.senha = senha;
    }
    String getSenha() {
        return senha;
    }
}