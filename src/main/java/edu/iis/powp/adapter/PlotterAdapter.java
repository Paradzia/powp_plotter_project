package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.appext.ApplicationWithDrawer;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;


/**
 * Plotter adapter to drawer with several bugs. 
 */
public class PlotterAdapter implements IPlotter
{ 
	private int startX = 0, startY = 0;
	private DrawPanelController controller;
	
    public PlotterAdapter(DrawPanelController controller) {
    	this.controller = controller;
    }
    
	@Override
    public void setPosition(int x, int y)
    {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void drawTo(int x, int y)
    {
    	
        ILine line = LineFactory.getBasicLine();
    	line.setStartCoordinates(this.startX, this.startY);
    	this.setPosition(x, y);
        line.setEndCoordinates(x, y);
		controller.drawLine(line);
    }

    @Override
    public String toString()
    {
        return PlotterAdapter.class.getSimpleName();
    }
}
