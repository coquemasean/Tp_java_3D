public class Main {

    public static void main(String[] args) {

        Aeroport CharlesDeGaulle = new Aeroport ("CDG", "Charles de Gaulle", "France", 49.1, 2.1);
        World w = new World ("D:/ENSEA/2021-2022/Tp_java_3D/data/airport-codes_no_comma.csv");

        System.out.println(CharlesDeGaulle);
    }
}
