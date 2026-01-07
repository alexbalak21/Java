package abst;

public class Fan implements Switchable {

    public void turnOn(){
        System.out.println("The fan starts Spinning");
    }

    public void turnOff(){
        System.out.println("The fan stops.");
    }

}
