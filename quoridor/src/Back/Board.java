package Back;

public class Board {
    public class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return this.getX() + "" + this.getY();
        }
    }

    public class Edge {
        private Node start;
        private Node end;

        public Edge(Node start, Node end) {
            this.start = start;
            this.end = end;
        }

        public Node getStart() {
            return start;
        }

        public Node getEnd() {
            return end;
        }

        public void setStart(Node start) {
            this.start = start;
        }

        public void setEnd(Node end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return this.start.toString() + " " + this.end.toString();
        }
    }

    public class Wall {
        private Node start;
        private Node end;

        public Wall(Node start, Node end) {
            this.start = start;
            this.end = end;
        }

        public Node getStart() {
            return start;
        }

        public Node getEnd() {
            return end;
        }

        public void setStart(Node start) {
            this.start = start;
        }

        public void setEnd(Node end) {
            this.end = end;
        }
    }

    public class Player {
        private Node position;

        public Player(Node position) {
            this.position = position;
        }

        public Node getPosition() {
            return position;
        }

        public void setPosition(Node position) {
            this.position = position;
        }

    }

    private Node[][] board;
    private Player[] player;
}