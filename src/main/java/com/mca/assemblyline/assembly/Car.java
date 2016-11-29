package com.mca.assemblyline.assembly;

import com.mca.assemblyline.components.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the components
 * of a car
 * @author Lubabalo Nazo
 */
public class Car
{
    private Component engine;
    private Component frame;
    private List<Seat> seats = new ArrayList<>();
    private List<Tire> tires = new ArrayList<>();

    /**
     * Constructor method which calls the buildCar method
     */
    public Car()
    {
        buildCar();
    }

    /**
     * This creates a car along with its various components
     */
    public void buildCar()
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
    public boolean isComponentBuilt()
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
}