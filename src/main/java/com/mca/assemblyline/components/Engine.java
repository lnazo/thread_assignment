package com.mca.assemblyline.components;

import com.mca.assemblyline.assembly.BuilderFactory;

/**
 * This class builds the engine for a car
 * @author Lubabalo Nazo
 */
public class Engine implements Component, Runnable
{
    // boolean to check if an engine has been built
    private boolean isComponentBuilt;
    // instance of this class
    private volatile static Engine instance;
    // assemblyline instance
    private static BuilderFactory builderFactory = ComponentFactory.getBuilderFactory();

    /**
     * The constructor adds the component to be built to the
     * assembly line
     */
    public Engine()
    {
        builderFactory.addComponentToBuild(this);
    }

    /**
     * This returns the instance of this class i.e. a single engine
     * @return The instance of this class i.e. the engine for 1 car
     */
    public static Engine getInstance()
    {
        if (instance == null)
        {
            synchronized (Engine.class)
            {
                if (instance == null)
                {
                    instance = new Engine();
                }
            }
        }
        return instance;
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

    @Override
    public void run()
    {
        System.out.println("The " + getComponentBuilt() + " is currently being built.");

        try
        {
            Thread.sleep(7000);
        }

        catch (InterruptedException ex)
        {
            System.out.println("We had the following problem: " + ex);
            Thread.currentThread().interrupt();
        }

        System.out.println("The " + getComponentBuilt() + " has been successfully built.");
        isComponentBuilt = true;
        builderFactory.componentCompleteNotifier(this);
    }
}
