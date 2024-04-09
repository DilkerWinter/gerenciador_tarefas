import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class component_Tarefas extends JPanel {
    JLabel titulo, desc, data_entrega, dataentrega_label, criador, prioridade_text, criador_text;
    JButton concluida;

    public component_Tarefas(Tarefas tarefa) {
        this.setSize(1035, 500); 
        this.setBackground(new Color(0x352F44));
        this.setLayout(null);
        this.setVisible(true);
        
        //Titulo da tarefa
        titulo = new JLabel(tarefa.getTitulo());
        titulo.setBounds(5, 20, 1000, 25);
        titulo.setVisible(true);
        titulo.setForeground(new Color(0xFAF0E6));
        titulo.setFont(new Font("JetBrainsMono", Font.BOLD, 26));
        this.add(titulo);
        
        //Descricao da tarefa
        desc = new JLabel(tarefa.getDescricao());
        desc.setBounds(5, 50, 1000, 25);
        desc.setFont(new Font("JetBrainsMono", Font.BOLD, 16));
        desc.setVisible(true);
        desc.setForeground(new Color(0xFAF0E6));
        this.add(desc);
        
        //Data de entrega final
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
        
        concluida = new JButton("Concluir Tarefa");
        concluida.setVisible(true);
        concluida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        concluida.setForeground(new Color(0xFAF0E6));
        concluida.setBackground(new Color(0xB9B4C7));
        concluida.setBounds(865, 70, 135, 30);
        this.add(concluida);
        
        //Prioridade para Tarefa
        if(tarefa.getPrioridade() == true){
            prioridade_text = new JLabel("Urgente:");
            prioridade_text.setForeground(Color.red);
            prioridade_text.setBounds(5, 0, 100, 25);
            prioridade_text.setVisible(true);
            this.add(prioridade_text);
        }
        
        //Criador diferente
        if(tarefa.getCriador() != tarefa.getResponsavel()){
            criador_text = new JLabel("Criado Por:");
            criador_text.setForeground(new Color(0xB9B4C7));
            criador_text.setBounds(874, 25, 100, 25);
            criador_text.setVisible(true);
            this.add(criador_text);
            criador = new JLabel(tarefa.getCriador().getNome());
            criador.setForeground(new Color(0xB9B4C7));
            criador.setBounds(941, 25, 100, 25);
            criador.setVisible(true);
            this.add(criador);
        }
        
    }
}
