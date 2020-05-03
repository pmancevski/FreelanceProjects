package main.java;

import main.java.constants.Tip_Containers;
import main.java.models.containers.PortContainer;
import main.java.models.macarale.Macara;
import main.java.utility.IOPortContainer;
import main.java.utility.UnloadTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private static int[] firstContainer = {3, 2, 3, 4};
    private static int[] secondContainer = {2, 3, 4, 5};
    private static int[] thirdContainer = {3, 4, 5, 6};

    private static PortContainer portContainerOne =
            new PortContainer("First Container", firstContainer);
    private static PortContainer portContainerTwo =
            new PortContainer("Second Container", secondContainer);
    private static PortContainer portContainerThree =
            new PortContainer("Third Container", thirdContainer);

    private static Macara macaraOne = new Macara(Tip_Containers.Mic_10mc, 100);
    private static Macara macaraTwo= new Macara(Tip_Containers.Mediu_25mc, 200);
    private static Macara macaraThree = new Macara(Tip_Containers.Mare_50mc, 400);
    private static Macara macaraFour = new Macara(Tip_Containers.Jumbo_100mc, 800);

    public static void main(String[] args) {

        List<PortContainer> containerList = new ArrayList<>();

        containerList.add(portContainerOne);
        containerList.add(portContainerTwo);
        containerList.add(portContainerThree);

        //Save PortContainer to file PortContainer.csv
        //IOPortContainer.savePortContainer(containerList);

        //Read PortContainer from file PortContainer.csv
        //List<PortContainer> newList = IOPortContainer.readPortContainer();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new UnloadTask(portContainerOne, macaraOne));
        executorService.execute(new UnloadTask(portContainerOne, macaraTwo));
        executorService.execute(new UnloadTask(portContainerOne, macaraThree));
        executorService.execute(new UnloadTask(portContainerOne, macaraFour));

        executorService.shutdown();
    }

}
