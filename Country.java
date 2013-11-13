package game.country;

public class Country{
    
    private Government gov;
    private Territory ter;
    
    private Country(Government g, Teritory t){
        gov = g;
        ter = t;
    }

    public void createCountry(Government g, Teritory t){
        Country c = new Country(g, t);
    }

    
}
