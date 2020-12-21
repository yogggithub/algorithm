package princeton.i.week_3.assign;

import java.util.Arrays;

public class BruteCollinearPoints {
    private Point[][] segmentPoints;
    private LineSegment[] segments;

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

        this.segmentPoints = new Point[0][2];
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
                                addToSegments(copy, i, j, k, n);
                                segments();
                            }
                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return this.segments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        this.segments = new LineSegment[segmentPoints.length];
        int i = 0;
        for (Point[] point : segmentPoints) {
            segments[i++] = new LineSegment(point[0], point[1]);
        }
        return Arrays.copyOf(segments, segments.length);
    }

    private void addToSegments(Point[] points, int i, int j, int k, int n) {
        Point[] p = {points[i], points[j], points[k], points[n]};
        Point min = p[0];
        Point max = p[0];
        for (Point value : p) {
            if (value.compareTo(min) < 0) {
                min = value;
            } else if (value.compareTo(max) > 0) {
                max = value;
            }
        }
        boolean flag = true;
        if (segmentPoints != null && segmentPoints.length != 0) {
            for (Point[] line : segmentPoints) {
                for (Point point : line) {
                    if (Double.compare(min.slopeTo(point), min.slopeTo(max)) == 0 ||
                        Double.compare(max.slopeTo(point), min.slopeTo(max)) == 0 ||
                        Double.compare(point.slopeTo(min), min.slopeTo(max)) == 0 ||
                        Double.compare(point.slopeTo(max), min.slopeTo(max)) == 0) {
                        flag = false;
                        if (point.compareTo(min) < 0) {
                            min = point;
                            flag = true;
                        } else if (point.compareTo(max) > 0) {
                            max = point;
                            flag = true;
                        }
                        line[0] = min;
                        line[1] = max;
                    }
                }
            }
        }
        if (flag) {
            // extend the points collection
            Point[][] temp;
            int index = 0;
            if (segmentPoints != null && segmentPoints.length != 0) {
                temp = Arrays.copyOf(segmentPoints, segmentPoints.length + 1);
                index = this.segmentPoints.length;
            } else {
                temp = new Point[1][2];
            }
            temp[index] = new Point[]{min, max};
            this.segmentPoints = Arrays.copyOf(temp, temp.length);
            temp = null;
        }
    }

}
