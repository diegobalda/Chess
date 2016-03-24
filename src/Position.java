/**
 * Created by brunodeluca on 3/23/16.
 */
public class Position {
    private int x;
    private int y;
    private boolean available;

    public Position(int x, int y, boolean available) {
        this.x = x;
        this.y = y;
        this.available = available;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void print(){
        System.out.println("(" + x + "," + y + ")");
    }

    public static void main(String[] args){
        Position hola = new Position(1,2,true);
        hola.print();
    }
}
