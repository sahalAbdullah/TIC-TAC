
package newtictactoe;



public class NewTicTacToe {

    public static void main(String[] args) {
        
        GUIBoard g = new GUIBoard();
    }   
}
class Point{
    
    int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "{" + "x=" + x + ",y=" + y + '}';
    }
}

