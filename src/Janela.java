import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @brief Classe Janela
 * @author Leonam Teixeira de Vasconcelos
 * @date   24/03/2018
 */
public class Janela{
    private JFrame frame;
    private JPanel panel;
    private JPanel right;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double width = screenSize.getWidth();
    private double height = screenSize.getHeight();
    
    public Janela(DesenhoPanel dp){
        initGUI(dp);
    }

    private void initGUI(DesenhoPanel dp) {
        frame = new JFrame("Janela");
        frame.setSize((int) width, (int) height);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        frame.setLocationRelativeTo(null);
        
        panel = new JPanel(new BorderLayout());
        right = new DesenhoPanel();
        right = dp;
        
        panel.add(right, BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
