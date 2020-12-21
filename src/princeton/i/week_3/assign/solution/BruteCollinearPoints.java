package princeton.i.week_3.assign.solution;

import princeton.i.week_3.assign.LineSegment;
import princeton.i.week_3.assign.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> segments;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException();
            }
            if (i > 0 && points[i] == points[i - 1]) {
                throw new IllegalArgumentException();
            }
        }
        segments = new ArrayList<>();
        Point[] copy = Arrays.copyOf(points, points.length);
        Arrays.sort(copy);

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

    // the number of line segments
    public int numberOfSegments() {
        return this.segments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

}
