package Back;

public class Player {
    private int name;
    private final String color;
    private Node location;

    public Node getLocation() {
        return location;
    }

    public void setLocation(Node n) {
        location = n;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Player(int name, String color, Node location) {
        this.name = name;
        this.color = color;
        this.location = location;
    }

    public Node Moveupwards() {
        location = new Node(location.getX(), location.getY() + 1);
        return location;
    }
    public String getColor() {
        return color;
    }

    public int getName() {
        return name;
    }
}
