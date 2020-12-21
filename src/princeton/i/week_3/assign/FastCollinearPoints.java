package princeton.i.week_3.assign;

import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] segments;
    private Point[][] segmentPoints;

    // finds all line segments containing 4 points
    public FastCollinearPoints(Point[] points) {
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

        for (int i = 0; i < copy.length; i++) {
            // reset the points array
            Arrays.sort(copy);

            // re-sort the array based on the ith element
            Arrays.sort(copy, i, copy.length, copy[i].slopeOrder());

            int count = 0;
            Point start = copy[i], end = null;

            for (int j = i + 1; j < copy.length - 1; j++) {
                if (Double.compare(copy[i].slopeTo(copy[j]),
                                   copy[i].slopeTo(copy[j + 1])) == 0) {
                    count++;
                    end = copy[j + 1];
                } else {
                    count = 0;
                }

                if (count >= 2) {
                    count = 0;
                    addToSegments(start, end);
                    segments();
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

    private void addToSegments(Point start, Point end) {
        boolean flag = true;
        if (segmentPoints != null && segmentPoints.length != 0) {
            for (Point[] line : segmentPoints) {
                for (Point point : line) {
                    if (Double.compare(start.slopeTo(point), start.slopeTo(end)) == 0 ||
                        Double.compare(end.slopeTo(point), start.slopeTo(end)) == 0 ||
                        Double.compare(point.slopeTo(start), start.slopeTo(end)) == 0 ||
                        Double.compare(point.slopeTo(end), start.slopeTo(end)) == 0) {
                        flag = false;
                        if (point.compareTo(start) < 0) {
                            start = point;
                            flag = true;
                        } else if (point.compareTo(end) > 0) {
                            end = point;
                            flag = true;
                        }
                        line[0] = start;
                        line[1] = end;
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
            temp[index] = new Point[]{start, end};
            this.segmentPoints = Arrays.copyOf(temp, temp.length);
            temp = null;
        }
    }
}
