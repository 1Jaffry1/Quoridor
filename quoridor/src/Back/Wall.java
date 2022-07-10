package Back;

import java.util.ArrayList;

public class Wall {
    public static ArrayList<Wall> wallsplaced = new ArrayList<>();
    //    default wall:
    public static Wall noWall = new Wall(Node.noNode, "v");
    private Node start;
    private String allign;
//    private String name = this.start.position() + this.allign;

    public Wall(Node start, String allign) {
        this.start = start;
        this.allign = allign;
        if (this.islegal()) this.placeWall(); //places wall as soon as it is built after checking that it is legal
    }

    public Wall(String string) {
        String[] split = string.split("");
        this.start = Node.getNodeByCoordinates(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        this.allign = split[2];
        if (this.islegal()) this.placeWall(); //places wall as soon as it is built after checking that it is legal

    }

    public static Wall getWallByNode(Node start, String allign) {
        for (Wall wall : wallsplaced) {
            if (wall.equals(new Wall(start, allign))) return wall;
        }
        return noWall;
    }

//    public static Wall getWallByName(String name) {
//        for (Wall wall : wallsplaced) {
//            if (wall.string.equals(name)) {
//                return wall;
//            }
//        }
//        return noWall;
//    }

    public boolean islegal() {
        for (Wall w : wallsplaced)
            if (this.equals(w)) return false; //wall exist
        this.placeWall();
        for (Player i : Player.players)
            if (!i.hasPath()) {
                this.removeWall();
                return false;
            }

        return true;
    }

    public Node getStart() {
        return start;
    }

    public String getAllign() {
        return allign;
    }

    public void placeWall() {

        if (allign.equals("h")) {
            Node topnode = Node.getNodeByCoordinates(getStart().getI()-1, getStart().getJ());
            try {
                this.start.neighbors.remove(topnode);
                topnode.neighbors.remove(this.start);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }

            Node rightnode = Node.getNodeByCoordinates(getStart().getI(), getStart().getJ()+1);
            Node topnode2 = Node.getNodeByCoordinates(rightnode.getI()-1, rightnode.getJ());
            try {
                rightnode.neighbors.remove(topnode2);
                topnode2.neighbors.remove(rightnode);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }

        } else if (allign.equals("v")) {
            Node Rightnode = Node.getNodeByCoordinates(getStart().getI(), getStart().getJ()+1);
            try {
                this.start.neighbors.remove(Rightnode);
                Rightnode.neighbors.remove(this.start);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }
            Node topnode = Node.getNodeByCoordinates(getStart().getI()-1, getStart().getJ());
            Node Rightnode2 = Node.getNodeByCoordinates(topnode.getI(), topnode.getJ()+1); //node that is right to topnode
            try {
                topnode.neighbors.remove(Rightnode2);
                Rightnode2.neighbors.remove(topnode);
            } catch (Exception e) {
                System.out.println("Wall already here");
            }
        }
        wallsplaced.add(this);
    }

    public void removeWall() {
        wallsplaced.removeIf(this::equals);
        if (this.allign.equals("v")) {
            Node Rightnode = Node.getNodeByCoordinates(getStart().getJ() + 1, getStart().getI());
            this.start.neighbors.add(Rightnode);
            Node topnode = Node.getNodeByCoordinates(getStart().getJ(), getStart().getI() + 1);
            Node Rightnode2 = Node.getNodeByCoordinates(topnode.getJ() + 1, topnode.getI()); //node that is right to topnode
            topnode.neighbors.add(Rightnode2);
        }
    }
}
