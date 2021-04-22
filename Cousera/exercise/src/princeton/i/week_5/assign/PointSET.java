package princeton.i.week_5.assign;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

public class PointSET {
    private final SET<Point2D> points;

    // construct an empty set of points
    public PointSET() {
        points = new SET<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return points.isEmpty();
    }

    // number of points in the set
    public int size() {
        return points.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null
            || p.x() < 0 || p.x() > 1
            || p.y() < 0 || p.y() > 1) {
            throw new IllegalArgumentException();
        }
        if (!this.contains(p)) {
            points.add(p);
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        return points.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        points.forEach(Point2D::draw);
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new IllegalArgumentException();
        }
        SET<Point2D> p = new SET<>();
        for (Point2D point : points) {
            if (rect.contains(point)) {
                p.add(point);
            }
        }
        return p;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty()) {
            return null;
        }
        double min = Double.POSITIVE_INFINITY;
        double distance;
        Point2D nearest = p;
        for (Point2D that : points) {
            distance = p.distanceSquaredTo(that);
            if (min > distance) {
                min = distance;
                nearest = that;
            }
        }
        return nearest;
    }

    public static void main(String[] args) {
        /* unit testing of the methods (optional) */
    }
}
