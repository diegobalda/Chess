public class Piece {

    private Position currentPosition;
    private Stack<Position> posibleMoves;
    private int[] Xmoves;
    private int[] Ymoves;

    public Piece(Position position, int[] Xmoves, int[] Ymoves) {
        this.currentPosition = position;
        posibleMoves = new Stack<Position>();
        this.Xmoves = Xmoves;
        this.Ymoves = Ymoves;
    }

    public Position getCurrentPosition(){ return this.currentPosition; }

    public void setCurrentPosition(Position position){this.currentPosition = position;}

    public Position getPosition() {
        return currentPosition;
    }

    public void setPosition(Position position) {
        this.currentPosition = position;
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

    public Stack<Position> whereToMove(){
        for(int i=0; i<Xmoves.length; i++){
            Position newPosition = currentPosition;
            newPosition.setX(currentPosition.getX() + Xmoves[i]);
            newPosition.setY(currentPosition.getY() + Ymoves[i]);
            if(!isValid(currentPosition, newPosition))
                continue;
            posibleMoves.push(newPosition);
        }
        return this.posibleMoves;
    }
}
