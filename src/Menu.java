import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @brief Classe Menu
 * @author Leonam Teixeira de Vasconcelos
 * @date   31/03/2018
 */
public class Menu extends JFrame{
    public static int lv;
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static double widht = screenSize.getWidth();
    public static double height = screenSize.getHeight();
    JPanel mainPanel = new JPanel();
    JPanel buttonP = new JPanel();
    JTextField tf = new JTextField();
    JButton jb_c = new JButton();
    JButton jb_r = new JButton();
    JButton jb_rp = new JButton();
    public Menu() throws HeadlessException{
        this.setTitle("Menu inicial");
        this.setSize(400,95);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.mainPanel.setLayout(new BorderLayout());
        this.buttonP.setLayout(new BorderLayout());
        this.jb_c.setText("Calcular");
        this.jb_r.setText("Renderizar");
        this.jb_rp.setText("Renderizar e Imprimir");
        this.jb_r.setEnabled(false);
        this.jb_rp.setEnabled(false);
        this.jb_c.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if(tf.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Campo em branco");
                }else{
                    int nv = Integer.parseInt(tf.getText());
                    lv = nv;
                    jb_r.setEnabled(true);
                    jb_rp.setEnabled(true);
                    jb_r.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Calcula_Fractal cf = new Calcula_Fractal(lv);
                        }
                    });
                    jb_rp.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Calcula_Fractal cf = new Calcula_Fractal(lv, true);
                        }
                    });
                }
            }
        });
        this.buttonP.add(jb_r, BorderLayout.WEST);
        this.buttonP.add(jb_rp, BorderLayout.CENTER);
        this.mainPanel.add(tf, BorderLayout.CENTER);
        this.mainPanel.add(jb_c, BorderLayout.EAST);
        this.mainPanel.add(buttonP, BorderLayout.SOUTH);
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
}
