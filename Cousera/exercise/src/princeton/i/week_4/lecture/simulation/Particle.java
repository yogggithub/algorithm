package princeton.i.week_4.lecture.simulation;

import edu.princeton.cs.algs4.StdRandom;

public class Particle {
    private double rx, ry; // position
    private double vx, vy; // velocity
    private final double radius; // radius
    private final double mass; // mass
    private int count; // number of collisions

    public Particle() {
        rx = StdRandom.uniform(-1.99999, 1.9999);
        ry = StdRandom.uniform(-1.99999, 1.9999 );
        vx = StdRandom.uniform(-0.03, 0.03);
        vy = StdRandom.uniform(-0.03, 0.03);
        this.radius = 0.01;
        this.mass = 0.01;
    }

    public void move(double dt) {
    }

    public void draw() {
    }

    public double timeToHit(Particle that) {
        if (this == that) {
            return Double.NEGATIVE_INFINITY;
        }
        double dx = that.rx - this.rx, dy = that.ry - this.ry;
        double dvx = that.vx - this.vx;
        double dvy = that.vy - this.vy;
        double dvdr = dx * dvx + dy * dvy;
        if (dvdr > 0) {
            return Double.POSITIVE_INFINITY;
        }
        double dvdv = dvx * dvx + dvy * dvy;
        double drdr = dx * dx + dy * dy;
        double sigma = this.radius + that.radius;
        double d = (dvdr * dvdr) - dvdv * (drdr - sigma * sigma);
        if (d < 0) {
            return Double.NEGATIVE_INFINITY;
        }
        return -(dvdr + Math.sqrt(d)) / dvdv;
    }

    public double timeToHitVerticalWall() {
        return 0;
    }

    public double timeToHitHorizontalWall() {
        return 0;
    }

    public void bounceOff(Particle that) {
        double dx = that.rx - this.rx, dy = that.ry - this.ry;
        double dvx = that.vx - this.vx, dvy = that.vy - this.vy;
        double dvdr = dx * dvx + dy * dvy;
        double dist = this.radius + that.radius;
        double J = 2 * this.mass * that.mass * dvdr / ((this.mass + that.mass) * dist);
        double Jx = J * dx / dist;
        double Jy = J * dy / dist;
        this.vx += Jx / this.mass;
        this.vy += Jy / this.mass;
        that.vx -= Jx / that.mass;
        that.vy -= Jy / that.mass;
        this.count++;
        that.count++;
    }

    public void bounceOffVerticalWall() {
    }

    public void bounceOffHorizontalWall() {
    }
}
