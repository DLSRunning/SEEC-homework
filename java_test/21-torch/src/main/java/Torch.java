public class Torch extends Battery{
    public Torch(Battery battery){

    }

    public boolean turnOn(int hours){
        if(useBattery(hours * r_rRate)) {
            return true;
        }
        return false;
    }
    public void charge(int hours){
        chargeBattery(hours * c_cRate);
    }

}
