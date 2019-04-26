/**
 * @brief Classe Ponto
 * @author Leonam Teixeira de Vasconcelos
 * @date   21/03/2018
 */
public class Ponto {
    public int x;
    public int y;
    
    public Ponto(){
        
    }
    public Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "x:"+this.x+"-y:"+this.y;
    }
}
