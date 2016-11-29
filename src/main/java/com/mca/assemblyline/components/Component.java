package com.mca.assemblyline.components;

/**
 * This interface provides the implementation for the construction of each component
 * @author Lubabalo Nazo
 */
public interface Component
{
    /**
     * Builds a component based on the time specification given
     * Will use Thread.sleep() to simulate the time for building a component
     */
    void buildComponent();

    /**
     * Checks whether a component has been completed or not
     * @return true if a component is completed
     */
    boolean isComponentBuilt();

    /**
     * Returns the name of the component that has been built
     * @return The component that has been built
     */
    String getComponentBuilt();
}
