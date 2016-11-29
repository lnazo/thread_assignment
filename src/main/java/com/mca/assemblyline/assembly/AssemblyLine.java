package com.mca.assemblyline.assembly;

import com.mca.assemblyline.components.Component;
import com.mca.assemblyline.components.ComponentFactory;
import com.mca.assemblyline.components.Seat;
import com.mca.assemblyline.components.Tire;
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
    // engine and frame components
    private Component engine;
    private Component frame;
    // list to store seats and tires
    private List<Seat> seats = new ArrayList<>();
    private List<Tire> tires = new ArrayList<>();

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
    public void startAssemblyLine()
    {
        Thread thread = new Thread(AssemblyLine.getInstance());
        thread.start();
    }

    /**
     * This creates a car along with its various components
     */
    private void buildCar()
    {
        engine = ComponentFactory.getEngine();
        frame = ComponentFactory.getFrame();

        seats.add(ComponentFactory.getSeat());
        seats.add(ComponentFactory.getSeat());
        seats.add(ComponentFactory.getSeat());
        seats.add(ComponentFactory.getSeat());
        seats.add(ComponentFactory.getSeat());

        tires.add(ComponentFactory.getTire());
        tires.add(ComponentFactory.getTire());
        tires.add(ComponentFactory.getTire());
        tires.add(ComponentFactory.getTire());
    }

    /**
     * This checks if each component has been built
     * @return Whether the components have been built or not
     */
    private boolean isComponentBuilt()
    {
        boolean done = true;
        done &= engine.isComponentBuilt();
        done &= frame.isComponentBuilt();

        for (Seat seat : seats)
        {
            done &= seat.isComponentBuilt();
        }

        for (Tire tire : tires)
        {
            done &= tire.isComponentBuilt();
        }

        return done;
    }

    @Override
    public void run()
    {
        long startTime = System.currentTimeMillis();
        System.out.println("The process of building a car has begun.");
        buildCar();

        while (!isComponentBuilt())
        {
            // components are being added to the car in the buildCar() method
        }

        System.out.println("Your new Nazo motor is ready!.");
        long deltaTime = System.currentTimeMillis() - startTime;
        System.out.println("The time taken to build the car is: " + (deltaTime * 0.001) + " seconds.");
    }
}
