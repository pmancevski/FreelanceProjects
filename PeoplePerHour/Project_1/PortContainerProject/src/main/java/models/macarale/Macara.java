package main.java.models.macarale;

import main.java.constants.Tip_Containers;

public class Macara {

    private Tip_Containers tipContainer;
    private int timpManipulare;

    public Macara(Tip_Containers tip_container, int timpManipulare){
        this.tipContainer = tip_container;
        this.timpManipulare = timpManipulare;
    }

    public int getTimpManipulare() {
        return timpManipulare;
    }

    public Tip_Containers getTipContainer() {
        return tipContainer;
    }
}
