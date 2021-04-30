package princeton.ii.week_2.assign;

import edu.princeton.cs.algs4.Picture;


public class SeamCarver {
    private double[][] energy;
    private Picture picture;
    private int height, width;

    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException();
        }
        // this.picture must be mutated
        this.picture = new Picture(picture);
        height = this.picture.height();
        width = this.picture.width();

        energy = new double[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                calculateEnergy(j, i);
            }
        }
    }

    // current picture
    public Picture picture() {
        return this.picture;
    }

    // width of current picture
    public int width() {
        return this.width;
    }

    // height of current picture
    public int height() {
        return this.height;
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IllegalArgumentException();
        }
        return energy[y][x];
    }

    private void calculateEnergy(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return;
        }

        // all cells at the edge should have 1000
        if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
            this.energy[y][x] = 1000;
        } else {
            this.energy[y][x] = Math.sqrt(colorYielding(x - 1, y, x + 1, y)
                                          + colorYielding(x, y - 1, x, y + 1));
        }
    }

    private double colorYielding(int x, int y, int i, int j) {
        double red, green, blue;
        red = Math.pow(this.picture.get(x, y).getRed() - this.picture.get(i, j).getRed(), 2);
        green = Math.pow(this.picture.get(x, y).getGreen() - this.picture.get(i, j).getGreen(), 2);
        blue = Math.pow(this.picture.get(x, y).getBlue() - this.picture.get(i, j).getBlue(), 2);
        return red + green + blue;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        int[] seam = new int[width];

        if (width < 3) {
            for (int i = 1; i < width; i++) {
                seam[i] = i;
            }
            return seam.clone();
        }

        // distTo is an array to store energy of the smallest path, i.e. seam
        double[] distTo = new double[height * width];
        for (int i = 0; i < height; i++) {
            for (int j = 1; j < width; j++) {
                distTo[i * width + j] = Double.POSITIVE_INFINITY;
            }
        }

        // edgeTo is an array to record the parent cell
        int[] edgeTo = new int[width * height];

        // when move right, there are three possible destination: upper, right, and down
        for (int i = 1; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // up-right
                if (j > 0 && distTo[(j - 1) * width + i] > energy[j - 1][i] + distTo[j * width + i - 1]) {
                    distTo[(j - 1) * width + i] = energy[j - 1][i] + distTo[j * width + i - 1];
                    edgeTo[(j - 1) * width + i] = j;
                }
                // right
                if (distTo[j * width + i] > energy[j][i] + distTo[j * width + i - 1]) {
                    distTo[j * width + i] = energy[j][i] + distTo[j * width + i - 1];
                    edgeTo[j * width + i] = j;
                }
                // down-right
                if (j < height - 1 && distTo[(j + 1) * width + i] > energy[j + 1][i] + distTo[j * width + i - 1]) {
                    distTo[(j + 1) * width + i] = energy[j + 1][i] + distTo[j * width + i - 1];
                    edgeTo[(j + 1) * width + i] = j;
                }
            }
        }

        for (int i = 1; i < height - 1; i++) {
            if (distTo[seam[width - 2] * width + width - 2] > distTo[i * width + width - 2]) {
                seam[width - 2] = i;
            }
        }
        seam[width - 1] = seam[width - 2];
        for (int i = width - 3; i >= 0; i--) {
            seam[i] = edgeTo[seam[i + 1] * width + i + 1];
        }

        return seam.clone();
    }


    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        int[] seam = new int[height];
        if (height < 3) {
            for (int i = 1; i < height; i++) {
                seam[i] = 0;
            }
            return seam.clone();
        }

        // distTo is an array to store energy of the smallest path, i.e. seam
        double[] distTo = new double[height * width];
        for (int j = 1; j < height; j++) {
            for (int i = 0; i < width; i++) {
                distTo[j * width + i] = Double.POSITIVE_INFINITY;
            }
        }

        // edgeTo is an array to record the parent cell
        int[] edgeTo = new int[height * width];
        for (int j = 1; j < height; j++) {
            for (int i = 0; i < width; i++) {
                if (i > 0 && distTo[j * width + i - 1] > energy[j][i - 1] + distTo[(j - 1) * width + i]) {
                    distTo[j * width + i - 1] = energy[j][i - 1] + distTo[(j - 1) * width + i];
                    edgeTo[j * width + i - 1] = i;
                }
                if (distTo[j * width + i] > energy[j][i] + distTo[(j - 1) * width + i]) {
                    distTo[j * width + i] = energy[j][i] + distTo[(j - 1) * width + i];
                    edgeTo[j * width + i] = i;
                }
                if (i < width - 1 && distTo[j * width + i + 1] > energy[j][i + 1] + distTo[(j - 1) * width + i]) {
                    distTo[j * width + i + 1] = energy[j][i + 1] + distTo[(j - 1) * width + i];
                    edgeTo[j * width + i + 1] = i;
                }
            }
        }
        for (int i = 1; i < width - 1; i++) {
            if (distTo[(height - 2) * width + seam[height - 2]] > distTo[(height - 2) * width + i]) {
                seam[height - 2] = i;
            }
        }
        seam[height - 1] = seam[height - 2];
        for (int i = height - 3; i >= 0; i--) {
            seam[i] = edgeTo[(i + 1) * width + seam[i + 1]];
        }

        return seam.clone();
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (seam == null) {
            throw new IllegalArgumentException();
        } else if (seam.length != width) {
            throw new IllegalArgumentException();
        }
        if (height <= 1) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < width; i++) {
            if (i > 0 && Math.abs(seam[i] - seam[i - 1]) > 1) {
                throw new IllegalArgumentException();
            }
            if (seam[i] < 0 || seam[i] >= height) {
                throw new IllegalArgumentException();
            }
        }

        Picture newPic = new Picture(width, height - 1);

        for (int i = 0; i < width; i++) {
            // copy image content
            for (int j = 0; j < height; j++) {
                if (j == seam[i]) {
                    continue;
                }
                newPic.set(i, j > seam[i] ? j - 1 : j, this.picture().get(i, j));
            }
        }

        // re-calculate energy
        for (int i = 0; i < width; i++) {
            if (seam[i] == height - 1) {
                energy[height - 2][i] = 1000;
                continue;
            }
            for (int j = seam[i]; j < height - 1; j++) {
                if (j == 0) {
                    energy[j][i] = 1000;
                } else {
                    energy[j][i] = energy[j + 1][i];
                }
            }
        }

        this.picture = newPic;
        this.height = this.picture.height();

        for (int i = 1; i < width - 1; i++) {
            if (seam[i] > 1) {
                calculateEnergy(i, seam[i] - 1);
            }
            if (seam[i] < height - 1) {
                calculateEnergy(i, seam[i]);
            }
            if (i > 1) {
                calculateEnergy(i - 1, seam[i]);
            }
            if (i < width - 2) {
                calculateEnergy(i + 1, seam[i]);
            }
        }
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (seam == null) {
            throw new IllegalArgumentException();
        } else if (seam.length != height) {
            throw new IllegalArgumentException();
        }
        if (width <= 1) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < height; i++) {
            if (i > 0 && Math.abs(seam[i] - seam[i - 1]) > 1) {
                throw new IllegalArgumentException();
            }
            if (seam[i] < 0 || seam[i] >= width) {
                throw new IllegalArgumentException();
            }
        }

        Picture newPic = new Picture(width - 1, height);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == seam[j]) {
                    continue;
                }
                newPic.set(i > seam[j] ? i - 1 : i, j, picture.get(i, j));
            }
        }
        for (int i = 0; i < height; i++) {
            if (seam[i] == width - 1) {
                energy[i][width - 2] = 1000;
                continue;
            }
            System.arraycopy(energy[i], seam[i] + 1, energy[i], seam[i], width - seam[i] - 1);
            if (seam[i] == 0) {
                energy[i][0] = 1000;
            }
        }
        this.picture = newPic;
        this.width = this.picture.width();

        for (int i = 1; i < height - 1; i++) {
            if (seam[i] > 1) {
                calculateEnergy(seam[i] - 1, i);
            }
            if (seam[i] < width - 1) {
                calculateEnergy(seam[i], i);
            }
            if (i > 1) {
                calculateEnergy(seam[i], i - 1);
            }
            if (i < height - 2) {
                calculateEnergy(seam[i], i + 1);
            }
        }
    }

    //  unit testing (optional)
    public static void main(String[] args) {
        Picture picture = new Picture("Princeton/ii/week_2/assign/3x4.png");
        SeamCarver seamCarver = new SeamCarver(picture);
        seamCarver.removeHorizontalSeam(seamCarver.findHorizontalSeam());
        seamCarver.removeVerticalSeam(seamCarver.findVerticalSeam());
    }
}
