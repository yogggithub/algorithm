package Princeton.i.week_4.lecture.simulation;

import edu.princeton.cs.algs4.StdDraw;

public class BouncingBalls {
    public static void main(String[] args) {
        int N = 100;
        Ball[] balls = new Ball[N];
        for (int i = 0; i < N; i++) {
            balls[i] = new Ball();
        }
        // using an infinite loop to simulate
        // every 50 ms, clear the screen
        // move the balls a little then re-draw
        while (true) {
            StdDraw.clear();
            for (int i = 0; i < N; i++) {
                balls[i].move(0.5);
                balls[i].draw();
            }
            StdDraw.show(50);
        }
    }
}
