
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class app_Header_novo extends JPanel{
    JButton btn_criarTarefa;
    JLabel app_title;
    public app_Header_novo(){
        this.setSize(1200,90);
        this.setLayout(null);
        this.setBackground(new Color(0x352F44));
        
        btn_criarTarefa = new JButton("Criar Tarefa");
        btn_criarTarefa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_criarTarefa.setBackground(new Color(0x5C5470));
        btn_criarTarefa.setFont(new java.awt.Font("Segoe UI", 1, 18));
        btn_criarTarefa.setForeground(new Color(0xFAF0E6));
        btn_criarTarefa.setFocusPainted(false);
        btn_criarTarefa.setBounds(0, 0, 165, 90);
        btn_criarTarefa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.add(btn_criarTarefa);
        
        app_title = new JLabel("Criador de Tarefas");
        app_title.setFont(new java.awt.Font("Segoe UI", 1, 48));
        app_title.setForeground(new Color(0xFAF0E6));
        app_title.setBounds(200, 20, 415, 50);
        
        this.add(app_title);
    }
}
