package student;

import edu.rice.comp440.rovers.model.Action;
import edu.rice.comp440.rovers.model.percepts.SmartPercepts;
import edu.rice.comp440.rovers.model.percepts.SmartPercepts.SmartRoverMemory;
import edu.rice.comp440.rovers.model.Position;
import edu.rice.comp440.rovers.model.rovers.AbstractSmartRover;
import edu.rice.comp440.rovers.view.DebugDrawer.DebugAssistant;

import java.util.List;
import java.util.ArrayList;

public class RandomRover extends AbstractSmartRover {

    private List<Position> debugRoute;

    public RandomRover() {
        super();

        debugRoute = new ArrayList<Position>();
    }

	@Override
	protected Action nextAction(SmartPercepts percepts) {
    	SmartRoverMemory memory = percepts.getMemory();

        int timer = memory.getState();

        /* Time to choose a new direction and distance! */
        if (0 == timer) {
            /* First, let's choose a distance. */
            float fdistance = 1.5f;
            while (percepts.coinToss()) {
                fdistance *= 1.5f;
            }

            int distance = (int) fdistance;
            memory.setState(distance);

            /* Now let's choose a direction. */
            Action direction;
            if (percepts.coinToss()) {
                if (percepts.coinToss()) {
                    direction = Action.NORTH;
                } else {
                    direction = Action.SOUTH;
                }
            } else {
                if (percepts.coinToss()) {
                    direction = Action.EAST;
                } else {
                    direction = Action.WEST;
                }
            }
            memory.setCachedAction(0, direction);

            /* We'll make a path to show the user where we're going. */
            debugRoute.clear();
            Position next = percepts.myPosition();
            for (int i = 0; i < distance; i++) {
                next = getPositionAfterMove(next, direction);
                debugRoute.add(next);
            }
        }

        debugRoute.remove(0);
        memory.setState(memory.getState() - 1);
        return memory.getCachedAction(0);
    }

    private Position getPositionAfterMove(Position position, Action move) {
        if (move == Action.NORTH) {
            return position.translate(new Position(0, 1));
        }

        if (move == Action.SOUTH) {
            return position.translate(new Position(0, -1));
        }

        if (move == Action.EAST) {
            return position.translate(new Position(1, 0));
        }

        if (move == Action.WEST) {
            return position.translate(new Position(-1, 0));
        }

        /* Idle */
        return position;
    }

	@Override
	public void debugDraw(DebugAssistant debugAssistant) {
	    debugAssistant.clear();
        debugAssistant.drawPath(debugRoute);
    }
}
