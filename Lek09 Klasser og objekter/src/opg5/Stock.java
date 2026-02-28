package opg5;

public class Stock {
    double currentPrice;
    String name;
    String Symbol;
    double priceChange;

    public Stock(double currentPrice,String name, String symbol){
        this.currentPrice = currentPrice;
        this.name = name;
        this.Symbol = symbol;
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
    public void setCurrentPrice(String name){
        this.currentPrice += currentPrice;
    }
}
