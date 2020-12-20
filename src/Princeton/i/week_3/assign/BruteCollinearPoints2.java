package Princeton.i.week_3.assign;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints2 {
    private final ArrayList<LineSegment> segments;

    public BruteCollinearPoints2(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException();
            }
        }
        Point[] copy = Arrays.copyOf(points, points.length);
        Arrays.sort(copy);
        for (int i = 1; i < copy.length; i++) {
            if (copy[i].compareTo(copy[i - 1]) == 0) {
                throw new IllegalArgumentException();
            }
        }

        segments = new ArrayList<>();

        for (int i = 0; i < copy.length; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                double slopeJ = copy[i].slopeTo(copy[j]);
                for (int k = j + 1; k < copy.length; k++) {
                    double slopeK = copy[i].slopeTo(copy[k]);
                    if (Double.compare(slopeJ, slopeK) == 0) {
                        for (int n = k + 1; n < copy.length; n++) {
                            double slopeL = copy[i].slopeTo(copy[n]);
                            if (Double.compare(slopeJ, slopeL) == 0) {
                                segments.add(new LineSegment(copy[i], copy[n]));
                            }
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[0]);
    }
}
