package opg1bog;

public class FanTest {
    void main(){
        Fan fan = new Fan();
        IO.println(fan.toString());

        Fan fan2 = new Fan(3,10,"Yellow",true);
        IO.println(fan2.toString());

        Fan fan3 = new Fan(2,10,"Yellow",true);
        IO.println(fan3.toString());
    }
}
