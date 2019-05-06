public class World {
//    Sky sky;
//    Hero hero;
//    Bullet bullet1;
//    Bullet bullet2;
    Airpline airpline1;
    Airpline airpline2;
    Bee bee1;
    Bee bee2;
    BigAirpline bigAirpline1;
    BigAirpline bigAirpline2;
    public void action(){
        airpline1 = new Airpline();
        airpline1.step();
        bee1  = new Bee();
        bee1.step();
        bigAirpline1=new BigAirpline();
        bigAirpline1.step();
    }
    public static void main(String[] args) {
          World w = new World();
          w.action();
    }

}
