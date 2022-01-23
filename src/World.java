import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import static java.lang.Math.*;

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
                    Aeroport large_a;
                    list.add(large_a = new Aeroport(fields[9], fields[2], fields[5], Double.parseDouble(fields[12]),
                            Double.parseDouble(fields[11])));
                }
                s = buf.readLine();
            }
        } catch (Exception e) {
            System.out.println("Maybe the file isn't there ?");
            System.out.println(list.get(list.size() - 1));
            e.printStackTrace();
        }
    }

    public double distance(double lo1, double la1, double lo2, double la2) {
        double norme = pow(la2 - la1, 2) + pow((lo2 - lo1) * cos(toRadians((la2 + la1) / 2)), 2);
        return norme;
    }

    public Aeroport findNearestAirport(double lon_pos, double lat_pos) {
        //Calcul la distance entre notre position le premier aeroport de la liste
        double dist = distance(lon_pos, lat_pos, list.get(0).getLongitude(), list.get(0).getLatitude());
        //Aeroport tampon
        Aeroport b = null;
        double index = 0;

        for (Aeroport a : list) {
            //Prend la latitude et longitude ne l'aeroport de la liste
            double lat1 = a.getLatitude();
            double lon1 = a.getLongitude();
            //Calcul la distance entre notre position et un aeroport de la liste
            double d = distance(lon_pos, lat_pos, lon1, lat1);
            if (d < dist) {
                b = a;
                dist = d;
            }
        }
        return b;
    }

    //Recupere le code IATA
    public Aeroport findByCode(String code) {
        for (Aeroport aero : list) {
            if (aero.getIATA().equals(code)) {
                return aero;
            }
        }
        System.out.println("Le code IATA ne correspond à aucun aeroport");
        return null;    }
}


