package Princeton.i.week_3.assign.solution;

import Princeton.i.week_3.assign.LineSegment;
import Princeton.i.week_3.assign.Point;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] lines;
    private int linenum = 0;

    public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
    {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        int len = points.length;
        Point[] copy1 = new Point[len];
        Point[] copy2 = new Point[len];
        LineSegment[] lineset = new LineSegment[len * len];//申请一个大数组暂时存放结果
        copy(points, copy1);
        Arrays.sort(copy1);
        copy(copy1, copy2);
        if (isduplicate(copy1))//有重复的
        {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < len; i++) {
            Arrays.sort(copy2, copy1[i].slopeOrder());//根据斜率排序
            Point min = copy2[0];
            Point max = copy2[0];
            int count = 1;
            for (int j = 1; j < len; j++) {
                if (Double.compare(copy1[i].slopeTo(copy2[j]), copy1[i].slopeTo(copy2[j - 1])) == 0) {
                    if (copy2[j].compareTo(min) < 0) {
                        min = copy2[j];
                    } else if (copy2[j].compareTo(max) > 0) {
                        max = copy2[j];
                    }
                    count++;
                    if (j == (len - 1) && count >= 3 && min.compareTo(copy1[i]) > 0) {
                        lineset[linenum++] = new LineSegment(copy1[i], max);
                    }
                } else {
                    if (count >= 3 && min.compareTo(copy1[i]) > 0) {
                        lineset[linenum++] = new LineSegment(copy1[i], max);
                    }
                    min = copy2[j];
                    max = copy2[j];
                    count = 1;
                }
            }
        }
        lines = Arrays.copyOf(lineset, linenum);
    }

    public int numberOfSegments()        // the number of line segments
    {
        return linenum;
    }

    public LineSegment[] segments()                // the line segments
    {
        LineSegment[] result = new LineSegment[linenum];
        for (int i = 0; i < linenum; i++) {
            result[i] = lines[i];
        }
        return result;
    }

    private void copy(Point[] origin, Point[] newarray) {
        int len = origin.length;
        for (int i = 0; i < len; i++) //复制一份辅助数组
        {
            if (origin[i] == null) {
                throw new IllegalArgumentException();
            }
            newarray[i] = origin[i];
        }
    }

    private boolean isduplicate(Point[] items) {
        for (int i = 1; i < items.length; i++) {
            if (items[i].compareTo(items[i - 1]) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        princeton.i.week_3.assign.FastCollinearPoints collinear = new princeton.i.week_3.assign.FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
