package com.mca.assemblyline.components;

import com.mca.assemblyline.assembly.AssemblyLine;

/**
 * This class builds the seats for a car
 * @author Lubabalo Nazo
 */
public class Seat implements Component, Runnable
{
    // count for the number of seats
    private volatile static int seatCount = 1;
    // boolean to check if a seat has been built
    private boolean isComponentBuilt;
    // assemblyline instance
    private static AssemblyLine assemblyLine = ComponentFactory.getAssemblyLine();

    /**
     * The constructor adds the component to be built to the
     * assembly line
     */
    public Seat()
    {
        assemblyLine.addComponentToBuild(this);
    }

    @Override
    public void buildComponent()
    {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public boolean isComponentBuilt()
    {
        return isComponentBuilt;
    }

    @Override
    public String getComponentBuilt()
    {
        return this.getClass().getSimpleName();
    }

    private synchronized void incrementCount()
    {
        seatCount++;
    }

    @Override
    public void run()
    {
        System.out.println(getComponentBuilt() + " " + seatCount + " is currently being built.");

        try
        {
            Thread.sleep(3000);
        }

        catch (InterruptedException ex)
        {
            System.out.println("We had the following problem: " + ex);
            Thread.currentThread().interrupt();
        }

        System.out.println(getComponentBuilt() + " " + seatCount + " has been successfully built.");
        incrementCount();
        isComponentBuilt = true;
        assemblyLine.componentCompleteNotifier(this);
    }
}
