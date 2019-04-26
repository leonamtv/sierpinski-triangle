/**
 * @brief Classe Triangulo
 * @author Leonam Teixeira de Vasconcelos
 * @date   21/03/2018
 */
public class Triangulo implements Comparable<Triangulo> {
    int nv;
    Ponto p1;
    Ponto p2;
    Ponto p3;
    
    public Triangulo(){
        
    }
    
    public Triangulo(int nv, Ponto p1, Ponto p2, Ponto p3){
        this.nv = nv;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public int compareTo(Triangulo o) {
        if(this.nv>o.nv){
            return 1;
        }else if(this.nv<o.nv){
            return -1;
        }else
            return 0;
    }
}
