import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class tela_login extends JFrame{
    JPasswordField senha_login;
    JTextField email_login;
    JLabel texto_senha, texto_email, title , mensagem;
    JButton btn_cadastro, btn_login;

    tela_login() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(315,300);
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        try {
            File iconFile = new File("src/main/java/icon_img/task_icon.png");
            Image iconImage = ImageIO.read(iconFile);
            setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
          
        }
        
        texto_senha =  new JLabel("Senha:");
        texto_senha.setBounds(25,125, 200, 25);
        this.add(texto_senha);
        senha_login = new JPasswordField();
        this.add(senha_login);
        senha_login.setBounds(25,150, 250, 25);
        
        texto_email =  new JLabel("E-mail:");
        texto_email.setBounds(25, 75, 200, 25);
        this.add(texto_email);
        email_login = new JTextField();
        this.add(email_login);
        email_login.setBounds(25, 100, 250, 25);
        
        
        title = new JLabel("Entre com sua conta");
        title.setBounds(25, 15, 300, 25);
        title.setFont(title.getFont().deriveFont(25f));
        this.add(title);
        
        btn_login = new JButton("Entrar");
        btn_login.setBounds(200 ,200, 75, 25);
        this.add(btn_login);
        
        btn_cadastro = new JButton("Cadastrar");
        btn_cadastro.setBounds(25 ,200, 125, 25);
        this.add(btn_cadastro);
        
        mensagem = new JLabel();
        mensagem.setBounds(25, 50, 300, 25);
        mensagem.setForeground(Color.red);
        this.add(mensagem);
        
        
        
        btn_cadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela_cadastro iniciar_cadastro;
                try {
                    iniciar_cadastro = new tela_cadastro();
                    iniciar_cadastro.iniciarcadastro();
                    dispose();
                } catch (IOException ex) {
                    Logger.getLogger(tela_login.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });

        senha_login.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_login.doClick();
            }
        }
        });
        btn_login.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            banco_config bancoConfig = new banco_config();
            boolean loginvalido = bancoConfig.verificar_login(email_login.getText(), senha_login.getText());
            tela_app app = new tela_app(); 
                if (loginvalido) {
                     dispose();
                     app.iniciarApp();
                } else {
                     mensagem.setText("Email ou Senha Inválida");
                }
            }
        });

    }
    
    public void iniciarlogin(){
        this.setVisible(true);
    }
}
