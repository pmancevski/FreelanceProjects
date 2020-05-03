package main.java.utility;

import main.java.models.containers.PortContainer;
import main.java.models.macarale.Macara;

public class UnloadTask implements Runnable {

    private PortContainer portContainer;
    private Macara macara;

    public UnloadTask(PortContainer portContainer, Macara macara){
        this.portContainer = portContainer;
        this.macara = macara;
    }

    @Override
    public void run() {
        try {
            portContainer.unloadContainer(macara);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
