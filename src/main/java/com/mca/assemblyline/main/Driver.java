package com.mca.assemblyline.main;

import com.mca.assemblyline.assembly.AssemblyLine;
import com.mca.assemblyline.components.ComponentFactory;

/**
 * This is the driver class for the Assembly Line
 * @author Lubabalo Nazo
 */
public class Driver
{
    public static void main(String[] args)
    {
        AssemblyLine assemblyLine = ComponentFactory.getAssemblyLine();

        System.out.println("Welcome to Nazo Motor Factory. \n\n");
        System.out.println("Let's get things started.");
        System.out.println("----------------------------------------");

        assemblyLine.buildCar();
    }
}
