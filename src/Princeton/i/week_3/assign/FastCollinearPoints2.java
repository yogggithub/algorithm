package Princeton.i.week_3.assign;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints2 {
    private final ArrayList<LineSegment> segments;

    public FastCollinearPoints2(Point[] points) {
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
        Point[] temp = Arrays.copyOf(copy, copy.length);
        int count;
        for (int i = 0; i < copy.length; i++) {
            count = 0;
            Arrays.sort(temp, copy[i].slopeOrder());
            Point min = temp[0];
            Point max = temp[0];
            for (int j = 1; j < copy.length - 1; j++) {
                double s1 = copy[i].slopeTo(temp[j]);
                double s2 = copy[i].slopeTo(temp[j + 1]);
                if (Double.compare(s1, s2) == 0) {
                    count++;
                    if (temp[j + 1].compareTo(min) < 0) {
                        min = temp[j + 1];
                    } else if (temp[j + 1].compareTo(max) > 0) {
                        max = temp[j + 1];
                    }
                    continue;
                } else {
                    if (count > 2) {
                        segments.add(new LineSegment(min, max));
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
