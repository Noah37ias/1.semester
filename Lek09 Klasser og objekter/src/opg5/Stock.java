package opg5;

public class Stock {
    private double currentPrice = 34.35;
    private String name;
    private String symbol;
    private double previousClosingPrice = 34.5;

    public Stock(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
    }
    public double getCurrentPrice(){
        return currentPrice;
    }
    public void setCurrentPrice(double currentPrice){
        this.currentPrice = currentPrice;
    }
    public String getName(){
        return name;
    }
    public double getChangePercent(){
        return ((this.currentPrice - this.previousClosingPrice)/this.previousClosingPrice)*100;
    }
    public void setPreviousClosingPrice(double previousClosingPrice){
        this.previousClosingPrice = previousClosingPrice;
    }
    public String toString(){
        return "Name: " + this.name + ", Symbol: " + this.symbol + "\n" +
                "Current Price: " + this.currentPrice+ "$"  +"\n" +
                "Previous Closing Price: " + this.previousClosingPrice + "$" +"\n" +
                "Change: " + this.getChangePercent() +"%";
    }
}
