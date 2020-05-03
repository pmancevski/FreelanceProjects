package main.java.models.containers;

import main.java.Numarabil;
import main.java.constants.Tip_Containers;
import main.java.models.macarale.Macara;

public class PortContainer implements Cloneable, Numarabil {

    private String eticheta;
    private Tip_Containers[] tip_containers;
    private int[] nrContainere;

    public PortContainer(String eticheta, int[] nrContainere) {
        this.eticheta = eticheta;
        tip_containers = Tip_Containers.values();

        if (nrContainere.length == 4) {
            this.nrContainere = nrContainere;
        }
        else {
            throw new IllegalArgumentException("Array length must be equal to 4!");
        }
    }

    @Override
    public int getCapacitate() {
       int value = 0;

       for (int count = 0; count < nrContainere.length; count++){
           value += nrContainere[count];
       }

       return value;
    }

    public void setNrContainere(int[] nrContainere) {
        this.nrContainere = nrContainere;
    }

    public int getCapacitate(Tip_Containers tip_containers){
        switch (tip_containers){
            case Mic_10mc:
                return nrContainere[0];
            case Mediu_25mc:
                return nrContainere[1];
            case Mare_50mc:
                return nrContainere[2];
            case Jumbo_100mc:
                return nrContainere[3];
                default:
                    return -1;
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %n%s, %d,%n%s, %d,%n%s, %d,%n%s, %d,%n%n",
                getEticheta(), getTip_containers()[0], getNrContainere()[0],
                getTip_containers()[1], getNrContainere()[1],
                getTip_containers()[2], getNrContainere()[2],
                getTip_containers()[3], getNrContainere()[3]);
    }

    public String getEticheta() {
        return eticheta;
    }

    public Tip_Containers[] getTip_containers() {
        return tip_containers;
    }

    public int[] getNrContainere() {
        return nrContainere;
    }

    public synchronized void unloadContainer(Macara macara) throws InterruptedException {
        switch (macara.getTipContainer()){
            case Mic_10mc:
                while (nrContainere[0] > 0) {
                    nrContainere[0]--;
                    Thread.sleep(macara.getTimpManipulare());
                    System.out.printf("Unload one container:%nType: %s%nCurrent number: %d%n%n",
                            macara.getTipContainer(), nrContainere[0]);
                }
                break;
            case Mediu_25mc:
                while (nrContainere[1] > 0) {
                    nrContainere[1]--;
                    Thread.sleep(macara.getTimpManipulare());
                    System.out.printf("\t\tUnload one container:%n" +
                                    "\t\tType: %s%n\t\tCurrent number: %d%n%n",
                            macara.getTipContainer(), nrContainere[1]);
                }
                break;
            case Mare_50mc:
                while (nrContainere[2] > 0) {
                    nrContainere[2]--;
                    Thread.sleep(macara.getTimpManipulare());
                    System.out.printf("\t\t\t\tUnload one container:%n" +
                                    "\t\t\t\tType: %s%n" +
                                    "\t\t\t\tCurrent number: %d%n%n",
                            macara.getTipContainer(), nrContainere[2]);
                }
                break;
            case Jumbo_100mc:
                while (nrContainere[3] > 0) {
                    nrContainere[3]--;
                    Thread.sleep(macara.getTimpManipulare());
                    System.out.printf("\t\t\t\t\t\tUnload one container:%n" +
                                    "\t\t\t\t\t\tType: %s%n" +
                                    "\t\t\t\t\t\tCurrent number: %d%n%n",
                            macara.getTipContainer(), nrContainere[3]);
                }
                break;
        }
    }
}
