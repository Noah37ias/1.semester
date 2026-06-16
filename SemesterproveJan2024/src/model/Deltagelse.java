package model;

public class Deltagelse {
    private Boolean isTræner;
    private Boolean isFremmødt;
    private Træning træning;

    public Deltagelse(Boolean isFremmødt, Boolean isTræner,Træning træning) {
        this.isFremmødt = isFremmødt;
        this.isTræner = isTræner;
        this.træning = træning;
    }
    public void setTræning(Træning træning){
        this.træning = træning;
    }

    public Boolean getTræner() {
        return isTræner;
    }

    public Boolean getFremmødt() {
        return isFremmødt;
    }

    public Træning getTræning() {
        return træning;
    }
}
