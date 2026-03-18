package opg2bog;

public class WeatherStation {
    private double temperature = 0;
    private double pressure = 1;

    void main(){
        WeatherStation ws = new WeatherStation();
        IO.println(ws);

        WeatherStation ws2 = new WeatherStation(35,0.5);
        IO.println(ws2);

        WeatherStation ws3 = WeatherStation.imperialUnitValues(68,21);
        IO.println(ws3);

        IO.println("ws");
        IO.println("Metrisk: " + ws.getTemperature() + " °C, " + ws.getPressure() + " bar");
        IO.println("Imperial: " + ws.getTemperatureFahrenheit() + " °F, " + ws.getPressurePSI() + " PSI");

        IO.println("ws2");
        IO.println("Metrisk: " + ws2.getTemperature() + " °C, " + ws2.getPressure() + " bar");
        IO.println("Imperial: " + ws2.getTemperatureFahrenheit() + " °F, " + ws2.getPressurePSI() + " PSI\n");

        IO.println("ws3");
        IO.println("Metrisk: " + ws3.getTemperature() + " °C, " + ws3.getPressure() + " bar");
        IO.println("Imperial: " + ws3.getTemperatureFahrenheit() + " °F, " + ws3.getPressurePSI() + " PSI");
    }

    public WeatherStation() {

    }

    public WeatherStation(double temperature, double pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public static WeatherStation imperialUnitValues(double farhenheit, double psi) {
        double celsius = (farhenheit - 32) / 1.8;
        double bar = psi / 14.503773773;
        return new WeatherStation(celsius, bar);
    }

    @Override
    public String toString() {
        return "WeatherStation{" + "temperature=" + temperature + ", pressure=" + pressure + '}';
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public double getPressure() {
        return this.pressure;
    }

    public double getTemperatureFahrenheit() {
        return (this.temperature * 1.8) + 32;
    }

    public double getPressurePSI() {
        return this.pressure * 14.503773773;
    }

    public void setTemperatureFahrenheit(double temperature) {
        this.temperature = (temperature - 32) / 1.8;
    }

    public void setPressurePSI(double pressure) {
        this.pressure = pressure / 14.503773773;
    }
}
