import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-07T17:50:11", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Tarefas.class)
public class Tarefas_ { 

    public static volatile SingularAttribute<Tarefas, Date> dataCriado;
    public static volatile SingularAttribute<Tarefas, Boolean> concluida;
    public static volatile SingularAttribute<Tarefas, Boolean> prioridade;
    public static volatile SingularAttribute<Tarefas, Pessoa> criador;
    public static volatile SingularAttribute<Tarefas, Date> dataEntrega;
    public static volatile SingularAttribute<Tarefas, String> titulo;
    public static volatile SingularAttribute<Tarefas, Integer> id;
    public static volatile SingularAttribute<Tarefas, Pessoa> responsavel;
    public static volatile SingularAttribute<Tarefas, String> descricao;

}