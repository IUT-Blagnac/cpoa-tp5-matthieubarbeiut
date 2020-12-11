package observer.pattern;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
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
	
	ArrayList<ObserverType> Types = new ArrayList<>();
	
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

	/**
	 * Informs this observer that the observed CourseData object has changed
	 *
	 * @param o the observed CourseData object that has changed
	 */
	public void update(Object o) {
		CourseRecord record = (CourseRecord) o;

		boolean doContain = false;
		for (CourseRecord courseRecord : CourseData)
			if (courseRecord.getName().equals(record.getName())){
				courseRecord.setNumOfStudents(record.getNumOfStudents());
				doContain = true;
			}

		if (!doContain)
			CourseData.add(record);

		this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
				+ (LayoutConstants.barSpacing + LayoutConstants.barWidth)
				* this.CourseData.size(), LayoutConstants.graphHeight + 2
				* LayoutConstants.yOffset));

		this.revalidate();
		this.repaint();
	}
	



	@Override
	public ArrayList<ObserverType> getTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}