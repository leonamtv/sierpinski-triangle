import javax.swing.SwingUtilities;

/**
 * @brief Classe Sistema
 * @author Leonam Teixeira de Vasconcelos
 * @date   30/03/2018
 */
public class Sistema {
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Menu().setVisible(true);
            }
        });
    }
}
