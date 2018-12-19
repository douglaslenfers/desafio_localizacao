package br.com.desafiolocalizacao.main;

/**
 *
 * @author L3nfers
 */
public class Haversine {

    private static final int RAIO_TOTAL_DA_TERRA = 6371;

    public static double distanciaEntreDoisPontos(double latitudeInicial, double longitudeInicial,
            double latitudeFinal, double longitudeFinal) {

        double dLat = Math.toRadians((latitudeFinal - latitudeInicial));
        double dLong = Math.toRadians((longitudeFinal - longitudeInicial));

        latitudeInicial = Math.toRadians(latitudeInicial);
        latitudeFinal = Math.toRadians(latitudeFinal);

        double a = haversin(dLat) + Math.cos(latitudeInicial) * Math.cos(latitudeFinal) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RAIO_TOTAL_DA_TERRA * c;
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
