public class Airpline extends FlyingOject {

    int speed;
    Airpline(){
        super();
        this.speed=1;
    }
    public void step(){
        System.out.println("小敌机移动了"+speed);
    }
}
