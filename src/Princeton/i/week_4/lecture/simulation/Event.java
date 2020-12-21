package Princeton.i.week_4.lecture.simulation;

public class Event implements Comparable<Event> {
    double time; // time of event
    Particle a, b; // particles involved in event
    private int countA, countB; // collision counts for a and b

    public Event(double t, Particle a, Particle b) {
    }

    public int compareTo(Event that) {
        return (int) (this.time - that.time);
    }

    public boolean isValid() {
        return true;
    }
}
