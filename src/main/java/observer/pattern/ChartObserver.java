package observer.pattern;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JPanel;


import observer.CourseRecord;
import observer.LayoutConstants;

public abstract class ChartObserver extends JPanel implements Observer {

	protected Vector<CourseRecord> CourseData;
	
	public ChartObserver(CourseData data) {
		data.attach(this);
		this.CourseData = data.getUpdate();
		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.CourseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.setBackground(Color.white);
	}

	public void update(Observable o) {
		CourseData data = (CourseData) o;
		this.CourseData = data.getUpdate();
		
		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.CourseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));
		this.revalidate();
		this.repaint();
	}

}
