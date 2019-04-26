import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @brief Classe Calcula_Fractal
 * @author Leonam Teixeira de Vasconcelos
 * @date   21/03/2018
 */

public class Calcula_Fractal {
    public static int l = 1;
    private static List<Triangulo> tList = new ArrayList<>();
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static double width = screenSize.getWidth();
    private static double height = screenSize.getHeight();
    public static Janela j;
    
    public Calcula_Fractal(int lv){
        Ponto p1 = new Ponto((int) (width/2), (int) ((height*0.05)));
        Ponto p2 = new Ponto((int) (width/2) + 380, (int) sqrt(760*760 - 380*380));
        Ponto p3 = new Ponto((int) (width/2) - 380, (int) sqrt(760*760 - 380*380));
        Triangulo t = new Triangulo(1, p1, p2, p3);
        tList.add(t);
        calculaTriangulo(t, lv);
        DesenhoPanel dp = new DesenhoPanel();
        dp.getArray((ArrayList<Triangulo>) tList);
        ordena();
        j = new Janela(dp);
    }
    public Calcula_Fractal(int lv, boolean b){
        Ponto p1 = new Ponto((int) (width/2), (int) ((height*0.05)));
        Ponto p2 = new Ponto((int) (width/2) + 380, (int) sqrt(760*760 - 380*380));
        Ponto p3 = new Ponto((int) (width/2) - 380, (int) sqrt(760*760 - 380*380));
        Triangulo t = new Triangulo(1, p1, p2, p3);
        tList.add(t);
        calculaTriangulo(t, lv);
        DesenhoPanel dp = new DesenhoPanel();
        dp.getArray((ArrayList<Triangulo>) tList);
        ordena();
        imprime();
        j = new Janela(dp);
    }
    public void start(int lv){
        Ponto p1 = new Ponto((int) (width/2), (int) ((height*0.05)));
        Ponto p2 = new Ponto((int) (width/2) + 380, (int) sqrt(760*760 - 380*380));
        Ponto p3 = new Ponto((int) (width/2) - 380, (int) sqrt(760*760 - 380*380));
        Triangulo t = new Triangulo(1, p1, p2, p3);
        tList.add(t);
        calculaTriangulo(t, lv);
        ordena();
        imprime();
    }
    
    public DesenhoPanel setarPanel() {
        DesenhoPanel dp = new DesenhoPanel();
        return dp;
    }
    
    public static void calculaTriangulo(Triangulo t, int nv){
        if(t.nv <= nv){
            l++;
            Ponto pa1 = new Ponto(t.p1.x, t.p1.y);
            Ponto pa2 = new Ponto(ptMed(t.p1.x, t.p2.x), ptMed(t.p1.y, t.p2.y));
            Ponto pa3 = new Ponto(ptMed(t.p1.x, t.p3.x), ptMed(t.p1.y, t.p3.y));
            Triangulo t1 = new Triangulo(t.nv+1, pa1, pa2, pa3);
            tList.add(t1);
            Ponto pb1 = new Ponto(t1.p2.x,t1.p2.y);
            Ponto pb2 = new Ponto(t.p2.x, t.p2.y);
            Ponto pb3 = new Ponto(ptMed(t.p2.x, t.p3.x), ptMed(t.p2.y, t.p3.y));
            Triangulo t2 = new Triangulo(t.nv+1, pb1, pb2, pb3);
            tList.add(t2);
            Ponto pc1 = new Ponto(t1.p3.x, t1.p3.y);
            Ponto pc2 = new Ponto(t2.p3.x, t2.p3.y);
            Ponto pc3 = new Ponto(t.p3.x, t.p3.y);
            Triangulo t3 = new Triangulo(t.nv+1, pc1, pc2, pc3);
            tList.add(t3);
            calculaTriangulo(t1, nv);
            calculaTriangulo(t2, nv);
            calculaTriangulo(t3, nv);
        }
    }

        
    public static ArrayList getTriangulos(){
        ordena();
        return (ArrayList) tList;
    }
    
    private static int ptMed(int a, int b){
        return (a+b)/2;
    }
    
    private static void imprime(){
        int i = 1;
        for(Triangulo t:tList){
            System.out.println(i +":::nv:"+ t.nv + ":P1:" + t.p1.toString() +":P2:"+ t.p2.toString()+":P3:"+t.p3.toString());
            i++;
        }
    }

    private static void ordena() {
        Collections.sort(tList);
    }
}
