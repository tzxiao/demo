public class Bee extends FlyingOject{
    int xspeed;
    int yspeed;
    int awardType;
    Bee(){

    }
    public void step(){
        System.out.println("小蜜蜂移动了"+xspeed+yspeed);
    }
}
