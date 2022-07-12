package Back;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IOF {// this is the class to read and write to and from file

    public static Game readFromFile(String gamename) {
        try {
            FileInputStream fs = new FileInputStream("someFile.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            boolean isit = false;
            int line = -1;
            while (!isit) {
                line++;
                isit = br.readLine().equals(gamename + ".game");
                if (isit) {
                    break;
                }
            }
            String game = br.readLine();
            ArrayList<String> list = new ArrayList<>();
            String[] list1 = br.readLine().split(" ");
            list.addAll(Arrays.asList(list1)); //this will add all the elements of the array to the list
            String player1 = br.readLine();
            String player2 = br.readLine();
            String player1loc = br.readLine();
            String player2loc = br.readLine();
            int player1walls = Integer.parseInt(br.readLine());
            int player2walls = Integer.parseInt(br.readLine());
            Player one = new Player(player1, "top");
            Player two = new Player(player2, "bottom");
            one.setLocation(Node.getNodeByName(Integer.parseInt(player1loc)));
            two.setLocation(Node.getNodeByName(Integer.parseInt(player2loc)));
            one.setWallsRemaining(player1walls);
            two.setWallsRemaining(player2walls);

            return new Game(gamename, one, two);

        } catch (IOException e) {
            System.out.println("File not found");
        }
        return null;
    }


    //what are the most important attributes of the game? :
//    the walls and the players name and position. the rest are the same for all games
    public static void writeToFile(String gameName, String p1name, String p2name, Node p1location, Node p2location, int wallsRemaining1, int wallsRemaining2) {
        try {
            FileWriter writer = new FileWriter("save.txt", true);
            writer.write(gameName + ".game\n");
            for (Wall wall : Wall.wallsplaced)
                writer.write(wall.toString() + " ");
            writer.write("\n");
            writer.write(p1name + "\n");
            writer.write(p2name + "\n");
            writer.write(p1location.toString() + "\n");
            writer.write(p2location.toString() + "\n");
            writer.write(wallsRemaining1 + "\n");
            writer.write(wallsRemaining2 + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("error in writing file");
            e.printStackTrace();
        }


    }
}
