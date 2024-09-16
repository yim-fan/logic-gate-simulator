/* Simulator.java
 * Support package for discfrete-event simulation
 * author Yimeng Fan, Douglas W. Jones
 * version 2017-12-01
 * Adapted from Logic.java Version 2017-11-25 (the MP5 solution),
 * 
 * Class Simulator taken from RoadNetwork.java Version 2017-10-25
 *
 * Bug notices in the code indicate unsolved problems
 */

import java.util.PriorityQueue;

/** Framework for discrete event simulation
 */
class Simulator {

    /** schedule one new event
     *  @param time when an event will occur
     *  @param act the action that will be triggered at that time
     *  Typically, this is called as follows:
     *  <pre>
     *  Simulator.schedule( someTime, (float time)->aMethodCall( time ... ) );
     *  </pre>
     */
    public static abstract class Event {
	protected final float time; // the time of this event

	public Event( float t ) {
	    time = t;               // initializer
	}

	abstract void trigger();    // what to do at that time	
    }

    private static PriorityQueue<Event> eventSet
	= new PriorityQueue <Event> (
	    (Event e1, Event e2) -> Float.compare( e1.time, e2.time )
    );

    /** Call schedule to make act happen at time.
     */
    public static void schedule( Event e ) {
	eventSet.add( e );
    }

    /** main loop that runs the simulation
     *  This must be called after all initial events are scheduled.
     */
    public static void run() {
	while (!eventSet.isEmpty()) {
	    Event e = eventSet.remove();
	    e.trigger();
	}
    }
}
