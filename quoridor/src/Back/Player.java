package Back;

public class Player {
    private int name;
    private String color;
    private Node location;

    public Node getLocation() {
        return location;
    }

    public void move(Node n) {
        location = n;
    } //we will use move method instead of setlocation

    public Player(int name, String color, Node location) {
        this.name = name;
        this.color = color;
        this.location = location;
    }

    public Node Moveupwards() {
        location = new Node(location.getX(), location.getY() + 1);
        return location;
    }
}

