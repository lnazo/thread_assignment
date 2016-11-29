/*
package main.com.mca.assemblyline.assembly;

import main.com.mca.assemblyline.components.Component;

*/
/**
 * This class builds the individual components
 * @author Lubabalo Nazo
 *//*

public class BuilderFactory implements Runnable
{
    private int timeToBuild;

    public String getComponentToBuild(Component component)
    {
        if ("Engine".equals(component.getComponentBuilt()))
        {
            timeToBuild = 7000;
            return component.getComponentBuilt();
        }

        if ("Frame".equals(component.getComponentBuilt()))
        {
            timeToBuild = 5000;
            return component.getComponentBuilt();
        }

        if ("Seat".equals(component.getComponentBuilt()))
        {
            timeToBuild = 3000;
            return component.getComponentBuilt();
        }

        if ("Tire".equals(component.getComponentBuilt()))
        {
            timeToBuild = 2000;
            return component.getComponentBuilt();
        }

        return "";
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
        assemblyLine.componentCompleteNotifier(this);
    }
}*/
