package com.mca.assemblyline.components;

import com.mca.assemblyline.assembly.BuilderFactory;

/**
 * This class builds the tires for a car
 * @author Lubabalo Nazo
 */
public class Tire implements Component, Runnable
{
    // count for the number of tires
    private volatile static int tireCount = 1;
    // boolean to check if a tire has been built
    private boolean isComponentBuilt;
    // assemblyline instance
    private static BuilderFactory builderFactory = ComponentFactory.getBuilderFactory();

    /**
     * The constructor adds the component to be built to the
     * assembly line
     */
    public Tire()
    {
        builderFactory.addComponentToBuild(this);
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
        tireCount++;
    }

    @Override
    public void run()
    {
        System.out.println(getComponentBuilt() + " " + tireCount + " is currently being built.");

        try
        {
            Thread.sleep(2000);
        }

        catch (InterruptedException ex)
        {
            System.out.println("We had the following problem: " + ex);
            Thread.currentThread().interrupt();
        }

        System.out.println(getComponentBuilt() + " " + tireCount + " has been successfully built.");
        incrementCount();
        isComponentBuilt = true;
        builderFactory.componentCompleteNotifier(this);
    }
}
