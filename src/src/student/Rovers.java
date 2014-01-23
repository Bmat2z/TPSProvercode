package student;

import java.util.ArrayList;
import java.util.List;

import edu.rice.comp440.rovers.model.rovers.AbstractRover;
import edu.rice.comp440.rovers.model.rovers.RoverFactory;
import edu.rice.comp440.rovers.model.rovers.RoverProvider;

public class Rovers implements RoverProvider {

	@Override
	public List<RoverFactory> getFactories() {
		/*
		 * TODO: If you make other rovers, add other factories to the list
		 * below, and you'll be able to run your rovers in the simulator.
         *
         * NOTE: Avoid spaces in the string returned by getName()!.
		 */
		
		List<RoverFactory> factories = new ArrayList<RoverFactory>();
		
		factories.add(new RoverFactory() {
			
			@Override
			public AbstractRover<?> make() {
				return new SmartRover();
			}
			
			@Override
			public String getName() {
				return "SmartRover";
			}
		});
		
		factories.add(new RoverFactory() {
			
			@Override
			public AbstractRover<?> make() {
				return new AntRover();
			}
			
			@Override
			public String getName() {
				return "AntRover";
			}
		});
		
		factories.add(new RoverFactory() {
			
			@Override
			public AbstractRover<?> make() {
				return new RandomRover();
			}
			
			@Override
			public String getName() {
				return "RandomRover";
			}
		});
		
		return factories;
	}
}
