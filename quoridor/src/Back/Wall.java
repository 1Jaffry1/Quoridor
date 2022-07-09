package Back;

import java.util.ArrayList;

public class Wall {
    private String name;
    private Node start;
    private String allign;
    public static ArrayList<Wall> wallsplaced = new ArrayList<>();
    //    default wall:
    public static Wall noWall = new Wall(Node.noNode, "v");

    public Wall(Node start, String allign) {
        this.start = start;
        this.allign = allign;
        if (islegal(this)) this.placeWall();
    }

    public Node getStart() {
        return start;
    }

    public String getAllign() {
        return allign;
    }

    public static boolean islegal(Wall wall) {
        return true;
    }

    public void placeWall() {

        if (allign.equals("h")) {
            Node topnode = Node.getNodeByCoordinates(getStart().getX(), getStart().getY() + 1);
            try {
                this.start.neighbors.remove(topnode);
                topnode.neighbors.remove(this.start);
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
                this.start.neighbors.remove(Rightnode);
                Rightnode.neighbors.remove(this.start);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }
            Node topnode = Node.getNodeByCoordinates(getStart().getX(), getStart().getY() + 1);
            Node Rightnode2 = Node.getNodeByCoordinates(topnode.getX() + 1, topnode.getY()); //node that is right to topnode
            try {
                topnode.neighbors.remove(Rightnode2);
                Rightnode2.neighbors.remove(topnode);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }
        }
        wallsplaced.add(this);
    }

    public static Wall getWallByName(String name) {
        for (Wall wall : wallsplaced) {
            if (wall.name.equals(name)) {
                return wall;
            }
        }
        return noWall;
    }
}
