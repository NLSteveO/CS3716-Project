package game.character;
import game.map.Territory;

public class Character{

    private Happiness happy;
    private Territory location;
    private String name;
        private boolean president;
        private boolean dictator;
        private boolean civilian;
        private boolean councilMem;
    
    public Character(String aName, Happiness h){
        civilian = true;//status civilian by default
        president = false;
                dictator = false;
                councilMem = false;
        name = aName;
        happy = h;
    }

    public Territory getLocation(){
            return location;
    }
    
    public void setLocation(Territory t){
            location = t;
    }
    //public void move(Teritory t){
      
    //}
 
        //could be more options added later

        public void updateStatus(String newStat){
                if(newStat == "pres"){
                        president = true;
                        civilian = false;
                        dictator = false;
                        councilMem = false;
                }
                else if(newStat == "dict"){
                        dictator = true;
                        president = false;
                        civilian = false;
                        councilMem = false;
                }
                else if(newStat == "civ"){
                        civilian = true;
                        president = false;
                        dictator = false;
                        councilMem = false;
                }
                else if(newStat == "coun"){
                        councilMem = true;
                        civilian = false;
                        president = false;
                        dictator = false;
                }
        }
        
        public boolean isPres(){
                return president;
        }

        public boolean isCiv(){
                return civilian;
        }

        public boolean isDict(){
                return dictator;
        }
        
        public boolean isCoun(){
                return councilMem;
        }
        
        public String getStatus(){
                if(isPres()){
                    return "President";
            }
            else if(isCoun()){
                    return "Council Member";
            }
            else if(isDict()){
                    return "Dictator";
            }
            else{
                    return "Civilian";
            }
        }
    
    public Happiness getHappiness(){
        return happy;
    }
    
    public int getPow(){
            return happy.getPow();
    }
    
    public int getWel(){
            return happy.getWel();
    }
    
    public int getSol(){
            return happy.getSol();
    }
    
    public String getName(){
            return name;
    }

    public void startCountry(){

    }

    public void joinCountry(){

    }
}