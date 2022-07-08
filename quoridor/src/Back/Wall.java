package Back;

import java.util.ArrayList;

public class Wall {
    private Node start;
    private String allign;
    public ArrayList<Wall> wallsplaced = new ArrayList<>();

    public Wall(Node start, String allign) {
        this.start = start;
        this.allign = allign;
    }

    public Node getStart() {
        return start;
    }

    public String getAllign() {
        return allign;
    }
    public static boolean islegal(Wall wall){
        return true;
    }

    public void removeEdge(Wall wall) {
        if (allign.equals("h")) {
            Node topnode = Node.getNodeByCoordinates(getStart().getX(), getStart().getY() + 1);
            try {
                wall.start.neighbors.remove(topnode);
                topnode.neighbors.remove(wall.start);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }
            Node rightnode = Node.getNodeByCoordinates(getStart().getX() + 1, getStart().getY());
            Node topnode2 = Node.getNodeByCoordinates(rightnode.getX(), rightnode.getY() + 1);
            try {
                rightnode.neighbors.remove(topnode2);
                topnode2.neighbors.remove(rightnode);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }
        } else if (allign.equals("v")) {
            Node Rightnode = Node.getNodeByCoordinates(getStart().getX() + 1, getStart().getY());
            try {
                wall.start.neighbors.remove(Rightnode);
                Rightnode.neighbors.remove(wall.start);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }
            Node topnode = Node.getNodeByCoordinates(getStart().getX(), getStart().getY() + 1);
            Node Rightnode2 = Node.getNodeByCoordinates(topnode.getX() + 1, topnode.getY());
            try {
                topnode.neighbors.remove(Rightnode2);
                Rightnode2.neighbors.remove(topnode);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }


        }


    }
}
