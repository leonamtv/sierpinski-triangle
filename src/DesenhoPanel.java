import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * @brief Classe DesenhoPanel
 * @author Leonam Teixeira de Vasconcelos
 * @date   24/03/2018
 */
public class DesenhoPanel extends JPanel{
    public int l = 1;

    public List<Triangulo> tList = new ArrayList<>();

    private boolean control = true;

    @Override
    protected void paintComponent(Graphics g) {
        this.setBackground(new Color(11,14,46));
        super.paintComponent(g); 
        tList = getArray();
        for(int i = 0; i<tList.size();i++){
            if(tList.get(i).nv==l){
                GeneralPath gp = dT(tList.get(i));
                this.paint(g, gp);
            }
        }
        if(this.l == Menu.lv){
            control = false;
        }		

        if(this.l == 0){
            control = true;
        }
        limpar();
    }
    
    private void limpar(){
        if(control){
            try {
                Thread.sleep(1000);
                this.repaint();
                l++;
            } catch (InterruptedException ex) {
                Logger.getLogger(DesenhoPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                Thread.sleep(1000);
                this.repaint();
                l--;
            } catch (InterruptedException ex) {
                Logger.getLogger(DesenhoPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private List getArray(){
        return Calcula_Fractal.getTriangulos();
    }
    
    public void paint(Graphics g, GeneralPath gp){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(0,255,127));
        g2d.fill(gp);
    } 
    
    public void getArray(ArrayList<Triangulo> tList){
        this.tList = tList;
    }
    
    private GeneralPath dT(Triangulo t){
        GeneralPath gp = new GeneralPath();
        gp.moveTo(t.p1.x, t.p1.y);
        gp.lineTo(t.p2.x, t.p2.y);
        gp.lineTo(t.p3.x, t.p3.y);
        gp.closePath();
        return gp;
    }
}
