package main.decorators.shapes;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import main.decorators.DecoratorGraphics2D;
import svg.element.shape.Polyline;
import svg.element.shape.Shape;

public class DecoratorGraphics2DPolyline extends DecoratorGraphics2D
{
	public DecoratorGraphics2DPolyline(final Shape base, final Graphics2D g2d)
	{
		super((Polyline) base, null, g2d);
	}

	@Override
	public void render()
	{
		final GeneralPath path = new GeneralPath();
		for (int n = 0; n < ((Polyline)component).points().size(); n++)
		{
			final Point2D.Double pt = ((Polyline)component).points().get(n);
			if (n == 0)
				path.moveTo((float)pt.x, (float)pt.y);
			else
				path.lineTo((float)pt.x, (float)pt.y);
		}
		
		if (((Shape)component).strokeColour() != null)
		{
			super.render();  // set shape styles
			graphics2D.setPaint(((Shape)component).strokeColour());
			graphics2D.draw(path);
		}
	}

	@Override
	public DecoratorGraphics2D newInstance(Shape base, Graphics2D g2d){
		return new DecoratorGraphics2DCircle(base, g2d);
	}

}
