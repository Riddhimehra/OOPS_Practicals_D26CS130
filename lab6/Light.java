interface Switcheable{
    void off();
    void on();
    boolean isOn();
    String getName();

    default void toggle(){
        if(isOn())
            off();
        else
            on();
    }
}

interface  SwitchOnRule{
    boolean maySwitchOn(int hour, Switcheable device);
    
}

class DayTimeRule implements SwitchOnRule{
    public boolean maySwitchOn(int hour, Switcheable device){
        return (hour >= 6 && hour <= 22);
    }
}

class Light implements Switcheable{

    boolean state=false;

    public void off(){
        state = false;
        System.out.println("LIGHT IS OFF");
    }

    public void on(){
        state = true;
        System.out.println("LIGHT IS ON");
    }

    public boolean isOn(){
        return state;
    }

    public String getName(){
        return "LIGHT";
    }
}

class Fan implements Switcheable{

    boolean state=false;

    public void off(){
        state = false;
        System.out.println("FAN IS OFF");
    }

    public void on(){
        state = true;
        System.out.println("FAN IS ON");
    }

    public boolean isOn(){
        return state;
    }

    public String getName(){
        return "FAN";
    }
}

class RemoteControl{
    public static void main(String[] args) {
        Switcheable[] devices = {new Fan(), new Light()};

        for(Switcheable s : devices){
            s.toggle();
        }

        for(Switcheable s1 : devices){
            s1.toggle();
        }

        SwitchOnRule rule = new DayTimeRule();

        if(rule.maySwitchOn(3, devices[0])){
            devices[0].on();
        }
        else{
            System.out.println(devices[0].getName() + " can't be on at this time");
        }

        if(rule.maySwitchOn(8, devices[1])){
            devices[1].on();
        }
        else{
            System.out.println(devices[1].getName() + " can't be on at this time");
        }
     }
}