package com.dimed.testeBackend.util;

public class DistanciaUtil {

	public static Double distanciaEmKm(Double primeiraLatitude, Double primeiraLongitude, Double segundaLatitude, Double segundaLongitude) {
		int EARTH_RADIUS_KM = 6371;

		// Conversão de graus pra radianos das latitudes
		Double primeiraLatToRadiano = Math.toRadians(primeiraLatitude);
		Double segundaLatToRadiano = Math.toRadians(segundaLatitude);

		// Diferença das longitudes
		Double deltaLongitudeInRadiano = Math.toRadians(segundaLongitude - primeiraLongitude);

		// Cálculo da distância entre os pontos
		return Math
				.acos(Math.cos(primeiraLatToRadiano) * Math.cos(segundaLatToRadiano) * Math.cos(deltaLongitudeInRadiano)
						+ Math.sin(primeiraLatToRadiano) * Math.sin(segundaLatToRadiano))
				* EARTH_RADIUS_KM;
	}

}
