package code.chap1;

import java.util.Objects;

/**
 * Any class overwrites the equals method, 
 * need to overwrite the hashCode method
 * Without overwritten hashCode method, it will increase the hash collission, and under performance the hash related lookup
 */
public class item11_hashcode {
    private static class ColorPoint {
        private int x;
        private int y;
        private String color;

        public ColorPoint(int x, int y, String color){
            this.x = x;
            this.y = y;
            this.color = Objects.requireNonNull(color);;
        }

        @Override
        public boolean equals(Object o){
            if (!(o instanceof ColorPoint)){
                return false;
            }

            ColorPoint target = (ColorPoint)o;
            return target.x == this.x && target.y == this.y && target.color.equals(this.color);
        }

        @Override
        public int hashCode(){
            // standard method to generate the hash code
            int result = 0;
            result = Integer.hashCode(x);
            result = result * 31 + Integer.hashCode(y);
            result = result * 31 + color.hashCode();

            return result;
        }
    }
}
