import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class component_Tarefas extends JPanel {
    JLabel titulo, desc, data_entrega, dataentrega_label, criador, prioridade_text;
    JCheckBox concluida;
    boolean prioridade;

    public component_Tarefas(Tarefas tarefa) {
        this.setSize(1035, 500); 
        this.setBackground(new Color(0x352F44));
        this.setLayout(null);
        this.setVisible(true);
        
        
        titulo = new JLabel(tarefa.getTitulo());
        titulo.setBounds(5, 20, 1000, 25);
        titulo.setVisible(true);
        titulo.setForeground(new Color(0xFAF0E6));
        titulo.setFont(new Font("JetBrainsMono", Font.BOLD, 26));
        this.add(titulo);
        
        desc = new JLabel(tarefa.getDescricao());
        desc.setBounds(5, 50, 1000, 25);
        desc.setFont(new Font("JetBrainsMono", Font.BOLD, 16));
        desc.setVisible(true);
        desc.setForeground(new Color(0xFAF0E6));
        this.add(desc);
        
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntregaSQL = tarefa.getDataEntrega();
        String dataEntregaFormatada = formatoData.format(dataEntregaSQL);
        data_entrega = new JLabel(dataEntregaFormatada);
        data_entrega.setBounds(940, 10, 100, 25);
        data_entrega.setVisible(true);
        data_entrega.setForeground(new Color(0xB9B4C7));
        this.add(data_entrega);
        
        dataentrega_label = new JLabel("Data de Entrega:");
        dataentrega_label.setBounds(843, 9, 100, 25);
        dataentrega_label.setVisible(true);
        dataentrega_label.setForeground(new Color(0xB9B4C7));
        this.add(dataentrega_label);
        
        if(tarefa.getPrioridade() == true){
            prioridade_text = new JLabel("Importante!");
            prioridade_text.setForeground(Color.red);
            prioridade_text.setBounds(5, 0, 100, 25);
            prioridade_text.setVisible(true);
            this.add(prioridade_text);
        }
    }
}
