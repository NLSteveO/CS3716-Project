package game.character;

public class Happiness{

    private int power;
    private int wealth;
    private int solitude;
    private int total;
    
    public Happiness(int pwr, int wel, int sol){
        power = pwr;
        wealth = wel;
        solitude = sol;
        total = 0;
    }

    public int getTotal(){
        return total;
    }

    public void updateTotal(int pwr, int wel, int sol){
        total += pwr*(power/100) + wel*(wealth/100) + sol*(solitude/100);
    }
    
    public int getPow(){
        return power;
    }
    
    public int getWel(){
        return wealth;
    }
    
    public int getSol(){
        return solitude;
    }

}
