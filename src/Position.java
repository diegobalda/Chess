package Posta;

/**
 * Created by brunodeluca on 3/28/16.
 */
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
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


    public String print(){
        return "|(" + x + "," + y + ")|";
    }

    public static void main(String[] args){
        Position hola = new Position(1,2);
        hola.print();
    }
}
