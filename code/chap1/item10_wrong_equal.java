package code.chap1;

class Point {
    protected int x;
    protected int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Point)){
            return false;
        }

        Point target = (Point)o;
        return target.x == this.x && target.y == this.y;
    }
}

class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y, String color){
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof ColorPoint)){
            return false;
        }

        ColorPoint target = (ColorPoint)o;

        return super.equals(target) && (this.color.equals(target.color));
    }
}

public class item10_wrong_equal {
    public static void main(String[] arg) throws Exception {
        Point p = new Point(1, 1);
        ColorPoint p1 = new ColorPoint(1, 1, "red");

        // this implementation violate the symmetry
        System.out.println(p.equals(p1));
        System.out.println(p1.equals(p));
    }
}
