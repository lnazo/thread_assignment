package com.mca.assemblyline.assembly;

import com.mca.assemblyline.components.Component;
import java.util.*;

/**
 * This class represents the assembly line that
 * builds the cars
 * @author Lubabalo Nazo
 */
public class AssemblyLine implements Runnable
{
    // instance of this class
    private volatile static AssemblyLine instance;
    // max capacity to ensure only 3 components are built at a time
    private static final int MAX_CAPACITY = 3;
    // list of components that are being built
    private List<Component> componentsUnderConstruction = new ArrayList<>();
    // queue of components to be built
    private Queue<Component> neededComponents = new LinkedList<>();

    private AssemblyLine()
    {
        // nothing to construct
    }

    /**
     * This returns the instance of this class i.e. a single assembly line
     * in operation
     * @return The instance of this class i.e. 1 assembly line to build cars
     */
    public static AssemblyLine getInstance()
    {
        if (instance == null)
        {
            synchronized (AssemblyLine.class)
            {
                instance = new AssemblyLine();
            }
        }
        return instance;
    }

    /**
     * This starts the assembly line
     */
    public void buildCar()
    {
        Thread thread = new Thread(AssemblyLine.getInstance());
        thread.start();
    }

    /**
     * This notifies the assembly line that a new component is to be built, therefore
     * its added to the list of components under construction
     * @param component The component to add to the list
     */
    public synchronized void addComponentToBuild(Component component)
    {
        if (component != null)
        {
            if (componentsUnderConstruction.size() < MAX_CAPACITY)
            {
                componentsUnderConstruction.add(component);
                component.buildComponent();
            }

            else
                neededComponents.add(component);
        }

        else
            System.out.println("An empty object is being added. Let's sort this out.");
    }

    /**
     * This notifies the assembly line that a component has been completed, therefore its
     * removed from the list of components under construction and adds the next component
     * needed to the queue of needed components
     * @param component The component to remove from the list and the next one to add
     * to the queue
     */
    public synchronized void componentCompleteNotifier(Component component)
    {
        componentsUnderConstruction.remove(component);
        Component nextComponent = neededComponents.poll();
        if (nextComponent != null)
            addComponentToBuild(nextComponent);
        if (componentsUnderConstruction.size() == 0 && neededComponents.size() == 0)
        {
            System.out.println("The assembly line is done.");
        }
    }

    @Override
    public void run()
    {
        long startTime = System.currentTimeMillis();
        System.out.println("The process of building a car has begun.");
        Car car = new Car();

        while (!car.isComponentBuilt())
        {
            // components are being added to the car in the buildCar() method
        }

        System.out.println("Your new Nazo motor is ready!.");
        long deltaTime = System.currentTimeMillis() - startTime;
        System.out.println("The time taken to build the car is: " + (deltaTime * 0.001) + " seconds.");
    }
}
