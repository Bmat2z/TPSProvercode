package student;

import edu.rice.comp440.rovers.model.Action;
import edu.rice.comp440.rovers.model.percepts.SmartPercepts;
import edu.rice.comp440.rovers.model.rovers.AbstractSmartRover;
import edu.rice.comp440.rovers.view.DebugDrawer.DebugAssistant;

public class SmartRover extends AbstractSmartRover {

	@Override
	protected Action nextAction(SmartPercepts percepts) {
		/*
		 * TODO: Your code here!
		 */
		return Action.IDLE;
	}

	@Override
	public void debugDraw(DebugAssistant debugAssistant) {
		/*
		 * TODO: Do debug drawing here!
		 */
	}
}
