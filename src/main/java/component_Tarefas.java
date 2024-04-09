import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class component_Tarefas extends JPanel {
    JLabel titulo, desc, data_entrega, data_criada, criador;
    JCheckBox concluida;
    boolean prioridade;

    public component_Tarefas(Tarefas tarefa) {
        this.setSize(300, 100); // Adjust size as needed
        this.setBackground(new Color(0x352F44));
        this.setLayout(null);

       titulo = new JLabel(tarefa.getTitulo());
       titulo.setBounds(5, 5, 100, 25);
       this.add(titulo);
       
       desc = new JLabel(tarefa.getDescricao());
       
       String dataEntregaFormatada = tarefa.getDataEntrega().toString();
       data_entrega = new JLabel(dataEntregaFormatada);
       
       String dataCriadaFormatada = tarefa.getDataCriada().toString();
       data_criada = new JLabel(dataCriadaFormatada);
       
       criador = new JLabel(tarefa.getCriador().getNome());
       
       
    }
    
    public void iniciar_componente_tarefas() {
        this.setVisible(true);
    }
}
