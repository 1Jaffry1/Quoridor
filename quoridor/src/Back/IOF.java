package Back;

import java.io.FileWriter;
import java.io.IOException;

public class IOF {// this is the class to read and write to and from file

    public static Game readFromFile() {
        // read from file
        return null;
    }

    //what are the most important attributes of the game? :
//    the walls and the players name and position. the rest are the same for all games
    public static void writeToFile(String gameName, String p1name, String p2name, Node p1location, Node p2location, int wallsRemaining1, int wallsRemaining2) {
        try {
            FileWriter writer = new FileWriter("save.txt");
            writer.write(gameName + "\n");
            for (Wall wall : Wall.wallsplaced)
                writer.write(wall.toString() + " ");
            writer.write("\n");
            writer.write(p1name + "\n");
            writer.write(p2name + "\n");
            writer.write(p1location.toString() + "\n");
            writer.write(p2location.toString() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("error in writing file");
            e.printStackTrace();
        }


    }
}
