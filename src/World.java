public class World {
    public static void main(String[] args) {
          World w = new World();
          w.action();
    }
    public void action(){
        Airpline a = new Airpline();
        a.step();
        Bee b  = new Bee();
        b.step();
        BigAirpline ba=new BigAirpline();
        ba.step();

    }
}
