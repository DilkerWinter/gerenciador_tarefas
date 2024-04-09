

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class tela_app extends JFrame {
    app_Header app_header;
    app_Body app_body;
    public tela_app(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200 , 650);
        this.setTitle("Organizador de Tarefas");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        try {
            File iconFile = new File("src/main/java/icon_img/task_icon.png");
            Image iconImage = ImageIO.read(iconFile);
            setIconImage(iconImage);
        } catch (IOException e) {
        }
        
        //Header
        app_header = new app_Header();
        app_header.setBounds(0, 0, 1200, 90);
        this.add(app_header);
        
        //Body
        app_body = new app_Body();
        app_body.setBounds(0, 90, 1200, 560);
        this.add(app_body);
    }

    public void iniciarApp() {
        this.setVisible(true);
        this.repaint();
    }
}