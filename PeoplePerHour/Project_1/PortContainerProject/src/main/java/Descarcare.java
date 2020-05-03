package main.java;

import main.java.models.containers.PortContainer;
import main.java.models.macarale.Macara;

public interface Descarcare {

    static int DescarcaContainer(PortContainer portContainer, Macara macara){

        switch (macara.getTipContainer()){
            case Mic_10mc:
                return portContainer.getNrContainere()[0];
            case Mediu_25mc:
                return portContainer.getNrContainere()[1];
            case Mare_50mc:
                return portContainer.getNrContainere()[2];
            case Jumbo_100mc:
                return portContainer.getNrContainere()[3];
            default:
                return -1;
        }
    }
}
