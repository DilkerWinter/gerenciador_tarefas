
import java.awt.Color;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class app_Body extends JPanel{
    JLabel title_tarefas;
    JScrollPane scroll_tarefas;
    
    public app_Body(){
        this.setSize(1200, 560);
        this.setVisible(true);
        this.setBackground(new Color(0xB9B4C7));
        this.setLayout(null);
        
        title_tarefas = new JLabel("Minhas Tarefas");
        title_tarefas.setForeground(new Color(0x352F44));
        title_tarefas.setFont(new java.awt.Font("Segoe UI", 1, 36));
        title_tarefas.setBounds(165, 10, 300, 35);
        this.add(title_tarefas);
        
         
        banco_config iniciarBanco = new banco_config();
        Pessoa pessoalogada = UsuarioLogado.getPessoa();
        List<Tarefas> listatarefas = iniciarBanco.tarefaUsuario(pessoalogada);
        
        JList listTarefas = new JList();
        
        
        for (Tarefas tarefa : listatarefas) {
        component_Tarefas componenteTarefas = new component_Tarefas(tarefa);
        
        listTarefas.add(componenteTarefas);
        }
        listTarefas.setLayout(new BoxLayout(listTarefas, BoxLayout.Y_AXIS));
        scroll_tarefas = new JScrollPane();
        scroll_tarefas.setViewportView(listTarefas);
        scroll_tarefas.setBackground(new Color(0xFAF0E6));
        scroll_tarefas.setBounds(165, 60, 1025, 500);
        
        this.add(scroll_tarefas);
        scroll_tarefas.revalidate();
        scroll_tarefas.repaint();
    }
    
}
