package observer.pattern;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import observer.CourseRecord;
import observer.LayoutConstants;

/**
 * This class represents a bar chart view of a vector of data. Uses the Observer
 * pattern.
 */
@SuppressWarnings("serial")
public class BarChartObserver extends ChartObserver {
	/**
	 * Creates a BarChartObserver object
	 * 
	 * @param data
	 *            a CourseData object to observe
	 */
	public BarChartObserver(CourseData data) {
		super(data);
	}

	/**
	 * Paint method
	 * 
	 * @param g
	 *            a Graphics object on which to paint
	 */
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < CourseData.size(); i++) {
			CourseRecord record = (CourseRecord) CourseData.elementAt(i);
			g.setColor(Color.blue);
			g.fillRect(
					LayoutConstants.xOffset + (i + 1)
							* LayoutConstants.barSpacing + i
							* LayoutConstants.barWidth, LayoutConstants.yOffset
							+ LayoutConstants.graphHeight
							- LayoutConstants.barHeight
							+ 2
							* (LayoutConstants.maxValue - record
									.getNumOfStudents()),
					LayoutConstants.barWidth, 2 * record.getNumOfStudents());
			g.setColor(Color.red);
			g.drawString(record.getName(),
					LayoutConstants.xOffset + (i + 1)
							* LayoutConstants.barSpacing + i
							* LayoutConstants.barWidth, LayoutConstants.yOffset
							+ LayoutConstants.graphHeight + 20);
		}
	}
}