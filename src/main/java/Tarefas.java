import java.text.ParseException;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "data_finalizada")
    private Date dataEntrega;
    
    @Column(name = "data_criado")
    private Date dataCriado;
    
    @Column(name = "prioridade")
    private boolean prioridade; 
    
    @Column(name = "concluida")
    private boolean concluida;
    
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Pessoa responsavel;
    
    @ManyToOne
    @JoinColumn(name = "criador_id")
    private Pessoa criador;
    
    //GETTER E SETTER
    
    //ID
    public int getID(){
        return this.id;
    }
    
    //DATA CRIADA    
    public void setDataCriada(Date datacriada){
        this.dataCriado = datacriada; 
    }
    public Date getDataCriada(){
        return this.dataCriado;
    }
    
    //DATA ENTREGA
    public void setDataEntrega(Date dataentrega) throws ParseException {
        this.dataEntrega = dataentrega;
    }
    
    public Date getDataEntrega() {
        return dataEntrega;
    }
    
    //TITULO
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    //DESCRICAO
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    //PRIORIDADE
    public void setPrioridade(Boolean prioridade){
        this.prioridade = prioridade;
    }
    
    public boolean getPrioridade(){
        return prioridade;
    }
    
    // CONCLUIDA
    public void setConcluida(Boolean concluida){
        this.concluida = concluida;
    }
    
    public boolean getConcluida(){
        return concluida;
    }
    
    //RESPONSAVEL    
    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }
    
    // CRIADOR
    public void setCriador(Pessoa criador) {
        this.criador = criador;
    }

    public Pessoa getCriador() {
        return criador;
    }
    
}
