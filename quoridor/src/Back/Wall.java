package Back;


import java.util.ArrayList;

public class Wall {
    public static ArrayList<Wall> wallsplaced = new ArrayList<>();
    //    default wall:
    private final Node start;
    private final String allign;

    public Wall(Node start, String allign) { // constructor
        this.start = start;
        this.allign = allign;
        if (this.islegal()) this.placeWall(); //places wall as soon as it is built after checking that it is legal
    }

    public Wall(String string) { // constructor
        String[] split = string.split("");
        this.start = Node.getNodeByCoordinates(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        this.allign = split[2];
        if (this.islegal()) this.placeWall(); //places wall as soon as it is built after checking that it is legal

    }


    //
//    public static Wall getWallByNode(Node start, String allign) {
//        for (Wall wall : wallsplaced) {
//            if (wall.equals(new Wall(start, allign))) return wall;
//        }
//        return noWall;
//    }

    @Override
    public String toString() {
        return "" + start.getI() + "" + start.getJ() + allign;
    }

    public boolean islegal() { //needs to check if wall is legal ::: apparently it has issues???
        for (Wall w : wallsplaced)
            if (this.equals(w)) return false; //wall exists already
        this.placeWall();
        for (Player i : Player.players)
            if (!i.hasPath()) {
                this.removeWall();
                return false;
            }
        this.removeWall();
        return true;
    }

    public Node getStart() {
        return start;
    }

    public void placeWall() {

        if (allign.equals("h")) {
            Node topnode = Node.getNodeByCoordinates(getStart().getI() - 1, getStart().getJ());
            if (topnode != null) {
                this.start.neighbors.remove(topnode);
                topnode.neighbors.remove(this.start);
            }
            Node rightnode = Node.getNodeByCoordinates(getStart().getI(), getStart().getJ() + 1);
            assert rightnode != null;
            Node topnode2 = Node.getNodeByCoordinates(rightnode.getI() - 1, rightnode.getJ());
            if (topnode2 != null) {
                rightnode.neighbors.remove(topnode2);
                topnode2.neighbors.remove(rightnode);
            }

        } else if (allign.equals("v")) {
            Node Rightnode = Node.getNodeByCoordinates(getStart().getI(), getStart().getJ() + 1);
            if (Rightnode != null) {
                this.start.neighbors.remove(Rightnode);
                Rightnode.neighbors.remove(this.start);
            }
            Node topnode = Node.getNodeByCoordinates(getStart().getI() - 1, getStart().getJ());
            Node Rightnode2 = Node.getNodeByCoordinates(topnode.getI(), topnode.getJ() + 1); //node that is right to topnode
            if (Rightnode2 != null) {
                topnode.neighbors.remove(Rightnode2);
                Rightnode2.neighbors.remove(topnode);
            }
        }
        wallsplaced.add(this);
    }

    public void removeWall() {
        wallsplaced.remove(this);
        if (this.allign.equals("v")) {
            Node Rightnode = Node.getNodeByCoordinates(getStart().getI(), getStart().getJ() + 1);
            assert Rightnode != null;
            this.start.neighbors.add(Rightnode);
            Node topnode = Node.getNodeByCoordinates(getStart().getI() - 1, getStart().getJ());
            assert topnode != null;
            Node Rightnode2 = Node.getNodeByCoordinates(topnode.getI(), topnode.getJ() + 1); //node that is right to topnode
            topnode.neighbors.add(Rightnode2);
        } else if (this.allign.equals("h")) {
            Node topnode = Node.getNodeByCoordinates(getStart().getI() - 1, getStart().getJ());
            assert topnode != null;
            this.start.neighbors.add(topnode);
            Node rightnode = Node.getNodeByCoordinates(getStart().getI(), getStart().getJ() + 1);
            assert rightnode != null;
            Node topnode2 = Node.getNodeByCoordinates(rightnode.getI() - 1, rightnode.getJ()); //topnode to the rightnode
            rightnode.neighbors.add(topnode2);
        }


    }
}
