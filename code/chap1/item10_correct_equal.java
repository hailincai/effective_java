package code.chap1;

public class item10_correct_equal {
    private static class Point {
        private int x;
        private int y;

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
            return this.x == target.x && this.y == target.y;
        }
    }

    /**
     * Using compose, instead of inherit
     * So there is no relation between Point and ColorPoint
     * then we don't need to make sure Point.equals(ColorPoint) and ColorPoint.equals(Point)
     */
    private static class ColorPoint {
        private Point point;
        private String color;

        public ColorPoint(int x, int y, String color){
            this.point = new Point(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object o){
            if (!(o instanceof ColorPoint)){
                return false;
            }

            ColorPoint target = (ColorPoint)o;
            return this.point.equals(target.point) && this.color.equals(target.color);
        }
    }

    public static void main(String[] argv) throws Exception {
        ColorPoint p1 = new ColorPoint(1, 1, "Red");
        ColorPoint p2 = new ColorPoint(1, 1, "Red");
        ColorPoint p3 = new ColorPoint(1, 1, "Red");

        System.out.println("p1 == p2 && p2 == p1:" + p1.equals(p2) + "," + p2.equals(p1));
        System.out.println("p1 == p2 && p2 == p3, so p1 == p3:" + p1.equals(p2) + "," + p2.equals(p3) + "," + p1.equals(p3));
        System.out.println("p1 != null:" + p1.equals(null));
    }
}
