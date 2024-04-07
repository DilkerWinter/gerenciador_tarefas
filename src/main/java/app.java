import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class app extends JFrame {

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
        
        JMenuBar menubar = new JMenuBar();
        JMenu filemenu = new JMenu("File");
        File icon_add_task = new File("src/main/java/icon_img/add_task.png");
        filemenu.setIcon((Icon) icon_add_task);
        
        
        menubar.add(filemenu);
        this.setJMenuBar(menubar); 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    public void iniciarApp() {
        this.setVisible(true);
    }
}