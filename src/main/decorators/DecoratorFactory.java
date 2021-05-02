package main.decorators.shapes;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import main.decorators.*;
import svg.element.shape.Circle;
import svg.element.shape.Shape;
import svg.element.style.*;

/**
 * Singleton class that holds a factory method for creating decorators for elements
 */
public class DecoratorFactory {



    //List of concrete classes to be instantiated
    private final List<DecoratorGraphics2D> prototypes = new ArrayList<DecoratorGraphics2D>();
    {
        prototypes.add(new DecoratorGraphics2DCircle(null, null));
        prototypes.add(new DecoratorGraphics2DEllipse(null, null));
        prototypes.add(new DecoratorGraphics2DLine(null, null));
        prototypes.add(new DecoratorGraphics2DPath(null, null));
        prototypes.add(new DecoratorGraphics2DPolygon(null, null));
        prototypes.add(new DecoratorGraphics2DPolyline(null, null));
        prototypes.add(new DecoratorGraphics2DRect(null, null));
    }

    // Singleton occurrence of this class
    private static DecoratorFactory singleton = null;

    //-------------------------------------------------------------------------

    /**
     * Private constructor: only this class can construct itself.
     */
    private DecoratorFactory()
    {
        // Nothing to do...
    }

    //-------------------------------------------------------------------------

    public static DecoratorFactory get()
    {
        if (singleton == null)
            singleton = new DecoratorFactory();  // lazy initialisation
        return singleton;
    }

    public List<DecoratorGraphics2D> prototypes()
    {
        return prototypes;
    }

    //-------------------------------------------------------------------------

    /**
     * @param label Symbol type to make.
     * @return New symbol of specified type, with fields unset.
     */
    public Decorator makeDecorator(final Shape base, final Graphics2D g2d)
    {

        for (DecoratorGraphics2D prototype : prototypes)
            if (prototype.component.label().equals((base.label()))){
            return prototype.newInstance(base, g2d);  // return an unset clone
    }


        System.out.println("* Failed to find prototype for Style " + label + ".");
        return null;
    }

    //-------------------------------------------------------------------------

}
