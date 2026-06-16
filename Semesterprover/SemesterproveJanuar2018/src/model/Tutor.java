package model;

import java.util.ArrayList;

public class Tutor {
    private String email;
    private String navn;
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private Hold hold;

    public Tutor(String email, String navn) {
        this.email = email;
        this.navn = navn;
    }
    public void setHold(Hold hold){
        this.hold = hold;
    }
}