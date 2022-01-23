public class Main {

    public static void main(String[] args) {

        World w = new World ("D:/ENSEA/2021-2022/Tp_java_3D/data/airport-codes_no_comma.csv");

        System.out.println("");
        System.out.println("Found "+w.getList().size()+" airports."); // donne les larges aeroport

        Aeroport paris = w.findNearestAirport(2.316,48.866); //un localistion à Paris
        Aeroport cdg = w.findByCode("CDG");

        double distance = w.distance(2.316,48.866,paris.getLongitude(),paris.getLatitude());
        System.out.println(paris);
        System.out.println(distance);

        double distanceCDG = w.distance(2.316,48.866,cdg.getLongitude(),cdg.getLatitude());
        System.out.println(cdg);
        System.out.println(distanceCDG);

    }
}
