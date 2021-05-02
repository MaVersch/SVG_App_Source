package main.decorators;

import java.awt.Graphics2D;

import main.decorators.shapes.DecoratorGraphics2DCircle;
import svg.element.BaseElement;
import svg.element.Element;
import svg.element.shape.Shape;
import svg.element.style.Style;

public class DecoratorGraphics2D extends Decorator
{
	final protected Graphics2D graphics2D;
	
	public DecoratorGraphics2D(final BaseElement base, final Style style, final Graphics2D g2d)
	{
		super(base, style);
		this.graphics2D = g2d;
	}

	@Override
	public Element newInstance()
	{
		return component.newInstance();
	}

	@Override
	public boolean load(String expr)
	{
		return component.load(expr);
	}

	@Override
	public void render()  //Graphics2D g2d)
	{
		component.render();  //g2d);
	}

	@Override
	public void setBounds()
	{
		component.setBounds();
		
	}

	/** Override this method in subclasses
	 *
	 * @param base
	 * @param g2d
	 * @return
	 */
	public  DecoratorGraphics2D newInstance(Shape base, Graphics2D g2d){ return null;}

}
