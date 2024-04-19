import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class component_Tarefas extends JPanel {
    JLabel titulo, desc, data_entrega, dataentrega_label, criador, prioridade_text, criador_text;
    JButton btn_concluida;

    app_Body parent;

    public component_Tarefas(Tarefas tarefa,app_Body body) {
        this.parent = body;

        this.setBackground(new Color(0x352F44));
        this.setLayout(null);
        this.setVisible(true);

        this.setMaximumSize(new Dimension(this.getMaximumSize().width,160));
        this.setMinimumSize(new Dimension(this.getMinimumSize().width,160));
        this.setPreferredSize(new Dimension(this.getPreferredSize().width,160));

        //Titulo da tarefa
        titulo = new JLabel(tarefa.getTitulo());
        titulo.setBounds(20, 25, 1000, 30);
        titulo.setVisible(true);
        titulo.setForeground(new Color(0xFAF0E6));
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 26));
        this.add(titulo);
        
        //Descricao da tarefa
        desc = new JLabel(tarefa.getDescricao());
        desc.setBounds(20, 55, 1000, 25);
        desc.setFont(new java.awt.Font("Segoe UI", 1, 16));
        desc.setVisible(true);
        desc.setForeground(new Color(0xFAF0E6));
        this.add(desc);
        
        //Data de entrega final
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEntregaSQL = tarefa.getDataEntrega();
        String dataEntregaFormatada = formatoData.format(dataEntregaSQL);
        data_entrega = new JLabel(dataEntregaFormatada);
        data_entrega.setBounds(920, 10, 140, 25);
        data_entrega.setVisible(true);
        data_entrega.setForeground(new Color(0xB9B4C7));
        this.add(data_entrega);
        dataentrega_label = new JLabel("Data de Entrega:");
        dataentrega_label.setBounds(797, 9, 150, 25);
        dataentrega_label.setVisible(true);
        dataentrega_label.setForeground(new Color(0xB9B4C7));
        this.add(dataentrega_label);
        
        btn_concluida = new JButton("Concluir Tarefa");
        btn_concluida.setVisible(true);
        btn_concluida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_concluida.setForeground(new Color(0x352F44));
        btn_concluida.setFocusPainted(false);
        btn_concluida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_concluida.setBackground(new Color(0xB9B4C7));
        btn_concluida.setBounds(865, 70, 135, 30);
        this.add(btn_concluida);

        //Separador
        JSeparator separator = new JSeparator();
        separator.setBounds(40, 150, 920, 10); // Ajuste conforme necessário
        separator.setForeground(new Color(0x5C5470)); // Cor do separador
        this.add(separator);
        
        //Prioridade para Tarefa
        if(tarefa.getPrioridade() == true){
            prioridade_text = new JLabel("Urgente:");
            prioridade_text.setForeground(Color.red);
            prioridade_text.setBounds(20, 0, 100, 25);
            prioridade_text.setVisible(true);
            this.add(prioridade_text);
        }
        
        //Criador diferente
        if(tarefa.getCriador() != tarefa.getResponsavel()){
            criador_text = new JLabel("Criado Por:");
            criador_text.setForeground(new Color(0xB9B4C7));
            criador_text.setBounds(839, 25, 100, 25);
            criador_text.setVisible(true);
            this.add(criador_text);
            criador = new JLabel(tarefa.getCriador().getNome());
            criador.setForeground(new Color(0xB9B4C7));
            criador.setBounds(922, 25, 100, 25);
            criador.setVisible(true);
            this.add(criador);
        }
        btn_concluida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                banco_config bancoConfig = new banco_config();
                bancoConfig.concluirTarefa(tarefa.getID());
                if(parent != null) {
                    parent.update();
                }
            }
        });
        
    }
}
