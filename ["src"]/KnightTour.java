/**
 * Created by brunodeluca on 3/25/16.
 */
public class KnightTour {
    public static int N = 8;

    /**
     * Funcion que permite checkear si i,j son lugares validos para un
     * ajedrez de i*j
     * @param x
     * @param y
     * @param sol
     * @return
     */

    public static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    /**
     * Function que permite imprimir la solucion
     * @param sol
     */
    public static void printSolution(int sol[][]) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N;j++){
                if(sol[i][j] < 10)
                    System.out.print(sol[i][j] + "  ");
                else
                    System.out.print(sol[i][j] + " ");
            }

            System.out.println();
        }


    }

    /**
     * Funcion que utiliza el metodo de backtracking para
     * resolver el problema de ajedrez. Retorna false si no se
     * llego a ninguna respuesta. De lo contrario se imprime dicho
     * camino
     * @return
     */
    public static boolean answer(){
        int sol[][] = new int[8][8];

        //creamos el board y le asignamos a cada casilla no visitada un -1
        for(int x = 0; x < N; x++)
            for(int y = 0; y < N; y++)
                sol[x][y] = -1;

        //Los movimientos del caballo en x e y
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[0][0] = 0;
        /**
         * empieza del 0,0 y explora todos los caminos posibles
         * usando el metodo solveKnight()
         */
        if(!solveKnight(0,1,1,sol,xMove,yMove)){
            System.out.println("Solution does not exist");
            return false; //no existe camino posible
        }else
            printSolution(sol); //se encontro el camino y se imprime

        return true; //se encontro un camino posible
    }

    /**
     * Funcion resursiva que usa backtraking cada vez que no llega a la solucion
     * Como el caballo se puede mover en 8 direcciones maximo es por eso que le
     * asignamos a K el valor 8 en el for loop. El metodo se fija primero si el siguiente
     * paso es igual a las dimenciones del tablero. En el caso de True -> llegamos a una
     * solucion. En el caso de False -> entramos al loop donde pasamos por el primer posible lugar
     * donde el caballo se pueda mover. Si es seguro ese siguiente lugar entonces nos vamos a mover
     * a uno de los posibles lugares de ese siguiente y asi hasta completar el camino. En el caso de
     * que nos movamos a un lugar en que nos encerramos porque no tiene ningun lugar mas a donde ir
     * entonces la funcion retornara False. Como estamos en el metodo recursivo el hecho de que
     * retorne false en esa casilla hace que en el if statement que esta dentro del for loop
     * salte al else el cual deja ese espacio encerrado como -1 y vuelve un paso para atras pero
     * esta vez tomando el siguiente camino o a.k.a otra opcion.
     * @param x = posicion inicial en x
     * @param y = posicion inicial en y
     * @param movei = siguiente paso (ej: paso 1, paso 2, paso 3... paso 64)
     * @param sol = el array donde vamos a 'pintar' cada espacio con su paso
     * @param xMove = movimiento en x
     * @param yMove = movimiento en y
     * @return
     */
    public static boolean solveKnight(int x, int y, int movei, int sol[][], int xMove[], int yMove[]){
        int k, next_x, next_y;
        if(movei == N*N)
            return  true;

        //intenta todos los movimientos posibles desde el origen x,y
        for(k = 0; k < 8; k++){
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if(isSafe(next_x,next_y,sol)){
                sol[next_x][next_y] = movei;
                if(solveKnight(next_x, next_y, movei+1, sol, xMove,yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1; //backtracking
            }
        }
        return false;
    }

    public static void main(String[] args){
        answer();
    }

}
