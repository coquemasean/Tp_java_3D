import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class World {
    ArrayList<Aeroport> list;

    public ArrayList<Aeroport> getList() {
        return list;
    }
        public World(String filename) {
            list = new ArrayList<Aeroport>();
            try {
                BufferedReader buf = new BufferedReader(new FileReader(filename));
                String s = buf.readLine();
                while (s != null) {
                    s = s.replaceAll("\"", "");
                    //Enleve les guillemets qui s ́eparent les champs de données GPS.
                    String fields[] = s.split(",");
                    // Une bonne id ́ee : placer un point d'arr^et ici pour du debuggage.
                    if (fields[1].equals("large_airport")) {
                        // A continuer

                    }
                    s = buf.readLine();
                }
            } catch (Exception e) {
                System.out.println("Maybe the file isn't there ?");
                System.out.println(list.get(list.size() - 1));
                e.printStackTrace();
            }
        }
    }

