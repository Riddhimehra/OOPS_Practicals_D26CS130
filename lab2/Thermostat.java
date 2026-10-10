class ThermoStatDemo{
	private String location;
	private int temperature;
	private static final int MIN = 16;
	private static final int MAX = 30;
	private static int activeCount = 0;

    ThermoStatDemo(String  location, int startTemp){
        activeCount++;
        this.location = location;
        if(startTemp > MAX || startTemp < MIN){
            temperature = 22;
        }
        else {
            temperature = startTemp;
        }
    }

    ThermoStatDemo(String location){
        this(location , 22);
    }

    public void raise(){
        if(temperature < MAX)
            temperature++;
        else
            System.out.println("Already at Maximum");
    }

    public void lower(){
        if(temperature > MIN)
            temperature--;
        else
            System.out.println("Already at Minimum");
    }

    public int getTemperature(){
        return temperature;
    }

    public static int getActiveCount(){
        return activeCount;
    }
}

class ThermoStat{
	public static void main(String[] args0){
		System.out.println("Variable Intialized");

        ThermoStatDemo t1 = new ThermoStatDemo("abc");
        ThermoStatDemo t2 = new ThermoStatDemo("xyz" , 32);

        for(int i=0 ; i<=10 ; i++){
            t1.raise();
            System.out.println(t1.getTemperature());
        }

        for(int i=0 ; i<=20 ; i++){
            t1.lower();
            System.out.println(t1.getTemperature());
        }

        System.out.println(ThermoStatDemo.getActiveCount());
	}
}
