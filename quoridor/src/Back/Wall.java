package Back;

import java.util.ArrayList;

public class Wall {
    public static ArrayList<Wall> wallsplaced = new ArrayList<>();
    //    default wall:
    public static Wall noWall = new Wall(Node.noNode, "v");
    private String name = this.start.printPosition()+ this.allign;
    private Node start;
    private String allign;

    public Wall(Node start, String allign) {
        this.start = start;
        this.allign = allign;
        if (islegal(this)) this.placeWall(); //places wall as soon as it is built after checking that it is legal
    }
    public Wall(String name){
        this.name = name;
        String[] split = name.split("");
        this.start = Node.getNodeByCoordinates(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        this.allign = split[2];
        if (islegal(this)) this.placeWall(); //places wall as soon as it is built after checking that it is legal
    }

    public static boolean islegal(Wall wall) {
        for (Wall w : wallsplaced)
            if (wall.equals(w)) return false;
        ArrayList<Node> tempnode = new ArrayList<>();
        return true; //has work
    }

    public static Wall getWallByName(String name) {
        for (Wall wall : wallsplaced) {
            if (wall.name.equals(name)) {
                return wall;
            }
        }
        return noWall;
    }

    public Node getStart() {
        return start;
    }

    public String getAllign() {
        return allign;
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
}
