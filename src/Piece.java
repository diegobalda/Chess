/**
 * Created by nicurat on 3/22/16.
 */
public class Piece {

    private Position position;

    public Piece(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isValid(Position start, Position end){
        if(start.getX() == end.getX() && start.getY() == end.getY()){
            return false;
        }
        if(end.getX() < 0 || end.getX() > 7 || end.getY() < 0 || end.getY() > 7){
            return false;
        }
        return true;
    }
}
