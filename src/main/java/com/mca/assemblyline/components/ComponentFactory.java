package com.mca.assemblyline.components;

import com.mca.assemblyline.assembly.AssemblyLine;

/**
 * This is the factory for the components
 * @author Lubabalo Nazo
 */
public class ComponentFactory
{
    /**
     * This represents an engine for 1 car
     * @return The assemblyline instance
     */
    public static Engine getEngine()
    {
        return Engine.getInstance();
    }

    /**
     * This represents a frame for 1 car
     * @return The assemblyline instance
     */
    public static Frame getFrame()
    {
        return Frame.getInstance();
    }

    /**
     * This represents the work for 1 car on an assembly line
     * @return The assemblyline instance
     */
    public static AssemblyLine getAssemblyLine()
    {
        return AssemblyLine.getInstance();
    }

    /**
     * This represents a seat
     * @return A seat
     */
    public static Seat getSeat()
    {
        return new Seat();
    }

    /**
     * This represents a tire
     * @return A tire
     */
    public static Tire getTire()
    {
        return new Tire();
    }
}
