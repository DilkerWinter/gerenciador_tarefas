import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class app extends JFrame {
    JButton btn_cadastro;
    
    public app() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setTitle("Organizador de Tarefas");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);

        try {
            File iconFile = new File("src/main/java/icon_img/task_icon.png");
            Image iconImage = ImageIO.read(iconFile);
            setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        btn_cadastro = new JButton("Cadastrar");
        btn_cadastro.setBounds(25 ,200, 125, 25);
        this.add(btn_cadastro);
        
        btn_cadastro.addActionListener(new ActionListener() {
        @Override
         public void actionPerformed(ActionEvent e) {
        Pessoa pessoaLogada = UsuarioLogado.getPessoa();
        System.out.println(pessoaLogada.getEmail());
    }
});

        
        
        
        
        
        
        
        
        
        
        
    }

    public void iniciarApp() {
        this.setVisible(true);
    }
}