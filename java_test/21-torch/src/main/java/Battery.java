public class Battery {
    public double electronic;
    public double c_cRate;
    public double r_rRate;

    public Battery(){
        c_cRate = 0.2;
        r_rRate = 0.1;
    }

    public Battery(double cRate,double rRate){
        c_cRate = cRate;
        r_rRate = rRate;
    }

    public void chargeBattery(double p){
        electronic = electronic + p > 1 ? 1 : electronic + p;
    }

    public boolean useBattery(double p){
        if (electronic - p >= 0) {
            electronic = electronic - p;
            return true;
        }
        return false;
    }

}
