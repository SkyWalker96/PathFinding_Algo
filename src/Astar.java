import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Pavith Buddhima on 3/31/2017.
 */
public class Astar {

    static ArrayList<Node> openList = new ArrayList<Node>();
    static ArrayList<Node> closedList = new ArrayList<Node>();

    Node current ;
    Node temp;
    Node start ;
    Node end;
    Node[][] nodeGrid;


    double diagonalDistance=1.4 ;
    double normalDistance =1.0;



    public void ShortestPath(boolean[][] matrix, int si, int sj, int ei, int ej){


        int size = matrix.length;

        start = new Node(si, sj);
        end = new Node(ei, ej);

        // The grid that is used to store nodes

        nodeGrid = new Node[size][size];

        // Creating nodes and finding blocked cells in matrix and mapping accordingly to our grid

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {


                nodeGrid[i][j] = new Node(i, j);
                if (matrix[i][j] == false) {
                    nodeGrid[i][j].setBlocked(true);
                    //calculate the f value and set hvalue
//                    int di = i - end.getI();
//                    int dj = j - end.getJ();
//                    double heuristic = 1 * (di+dj);
//
//                    nodeGrid[i][j].sethValue(heuristic);


                }

            }
        }




        // setting start distance to 0.
        // All other nodes will have infinity distance at the beginning
        start.setfValue(0);
        start.setgValue(0);
        start.sethValue(0);

        // a comparator object to deal with Priority Queue
        Comparator<Node> adjacencyComparator = (left, right) -> {
            if (left.getfValue() > (right.getfValue())) {
                return 1;
            }
            return -1;
        };

        // Queue to store visiting nodes
        Queue<Node> openList = new PriorityQueue<>(size, adjacencyComparator);

        openList.add(start);

        while (openList.size() > 0) {





            Node current = openList.remove();
            Node temp;




            // Top
            if (current.getI() - 1 >= 0) {

                // Top Top
                temp = nodeGrid[current.getI() - 1][current.getJ()];
                if (!temp.visited && !temp.blocked && temp.fValue > current.getfValue() + normalDistance) {

                    double tempg = current.getgValue() + normalDistance;

                    temp.setgValue(tempg);

                    int di = temp.getI() - end.getI();
                    int dj = temp.getJ() - end.getJ();

                    double temph = 1 * (di+dj);

                    temp.sethValue(temph);
                    temp.setfValue(tempg+temph);
                    temp.parent = current;

                    openList.add(temp);
                }

                // Top Left
                if (current.getJ() - 1 > 0) {
                    temp = nodeGrid[current.getI() - 1][current.getJ() - 1];
                    if (!temp.visited && !temp.blocked && temp.fValue > current.getfValue() + diagonalDistance) {

                        double tempg = current.getgValue() + diagonalDistance;

                        temp.setgValue(tempg);

                        int di = temp.getI() - end.getI();
                        int dj = temp.getJ() - end.getJ();

                        double temph = 1 * (di+dj);

                        temp.sethValue(temph);
                        temp.setfValue(tempg+temph);

                        temp.parent = current;
                        openList.add(temp);
                    }
                }

                // Top Right
                if (current.getJ() + 1 < size) {
                    temp = nodeGrid[current.getI() - 1][current.getJ() + 1];
                    if (!temp.visited && !temp.blocked && temp.fValue > current.getfValue() + diagonalDistance) {

                        double tempg = current.getgValue() + diagonalDistance;

                        temp.setgValue(tempg);

                        int di = temp.getI() - end.getI();
                        int dj = temp.getJ() - end.getJ();

                        double temph = 1 * (di+dj);

                        temp.sethValue(temph);
                        temp.setfValue(tempg+temph);

                        temp.parent = current;
                        openList.add(temp);
                    }
                }
            }

            // Left
            if (current.getJ() - 1 > 0) {
                temp = nodeGrid[current.getI()][current.getJ() - 1];
                if (!temp.visited && !temp.blocked && temp.fValue > current.getfValue() + normalDistance) {

                    double tempg = current.getgValue() + diagonalDistance;

                    temp.setgValue(tempg);

                    int di = temp.getI() - end.getI();
                    int dj = temp.getJ() - end.getJ();

                    double temph = 1 * (di+dj);

                    temp.sethValue(temph);
                    temp.setfValue(tempg+temph);

                    temp.parent = current;
                    openList.add(temp);
                }
            }

            // Right
            if (current.getJ() + 1 < size) {
                temp = nodeGrid[current.getI()][current.getJ() + 1];
                if (!temp.visited && !temp.blocked && temp.fValue > current.getfValue() + normalDistance) {

                    double tempg = current.getgValue() + diagonalDistance;

                    temp.setgValue(tempg);

                    int di = temp.getI() - end.getI();
                    int dj = temp.getJ() - end.getJ();

                    double temph = 1 * (di+dj);

                    temp.sethValue(temph);
                    temp.setfValue(tempg+temph);

                    temp.parent = current;
                    openList.add(temp);
                }
            }
            // Down
            if (current.getI() + 1 < size) {

                // Down Down
                temp = nodeGrid[current.getI() + 1][current.getJ()];
                if (!temp.visited && !temp.blocked && temp.fValue > current.getfValue() + normalDistance) {

                    double tempg = current.getgValue() + diagonalDistance;

                    temp.setgValue(tempg);

                    int di = temp.getI() - end.getI();
                    int dj = temp.getJ() - end.getJ();

                    double temph = 1 * (di+dj);

                    temp.sethValue(temph);
                    temp.setfValue(tempg+temph);

                    temp.parent = current;
                    openList.add(temp);
                }

                // Down Left
                if (current.getJ() - 1 >= 0) {
                    temp = nodeGrid[current.getI() + 1][current.getJ() - 1];
                    if (!temp.visited && !temp.blocked && temp.fValue > current.getfValue() + diagonalDistance) {

                        double tempg = current.getgValue() + diagonalDistance;

                        temp.setgValue(tempg);

                        int di = temp.getI() - end.getI();
                        int dj = temp.getJ() - end.getJ();

                        double temph = 1 * (di+dj);

                        temp.sethValue(temph);
                        temp.setfValue(tempg+temph);

                        temp.parent = current;
                        openList.add(temp);
                    }
                }

                // Down Right
                if (current.getJ() + 1 < size) {
                    temp = nodeGrid[current.getI() + 1][current.getJ()+ 1];
                    if (!temp.visited && !temp.blocked && temp.fValue > current.getfValue() + diagonalDistance) {

                        double tempg = current.getgValue() + diagonalDistance;

                        temp.setgValue(tempg);

                        int di = temp.getI() - end.getI();
                        int dj = temp.getJ() - end.getJ();

                        double temph = 1 * (di+dj);

                        temp.sethValue(temph);
                        temp.setfValue(tempg+temph);

                        temp.parent = current;
                        openList.add(temp);
                    }
                }
            }

             closedList.add(current);
            current.visited = true;
        }



    }



}