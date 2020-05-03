package main.java.utility;

import main.java.models.containers.PortContainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IOPortContainer {

    public static void savePortContainer(List<PortContainer> portContainers){

        try (Formatter output = new Formatter("PortContainer.csv")){
            for (PortContainer portContainer : portContainers){
                output.format("%s", portContainer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PortContainer> readPortContainer(){
        List<PortContainer> portContainers = new ArrayList<>();

        try (Scanner input = new Scanner(new File("PortContainer.csv"))){
            String document = "";
            int count = 0;

            PortContainer portContainer;

            while (input.hasNext()){
                document += input.next();
                count++;

                if (count % 9 == 0){
                    String[] tokens = document.trim().split(",");
                    document = "";
                    count = 0;

                    String eticheta = tokens[0];
                    int[] containers = new int[4];
                    for (int countTok = 1; countTok < tokens.length; countTok++){
                        if (countTok % 2 == 0){
                            containers[count] = Integer.parseInt(tokens[countTok]);
                            count++;
                        }
                    }

                    count = 0;
                    portContainer = new PortContainer(eticheta, containers);
                    portContainers.add(portContainer);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return portContainers;
    }
}