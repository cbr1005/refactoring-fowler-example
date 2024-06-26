package ubu.gii.dass.refactoring;

/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */
public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public double calculateAmount() {
		double resultados = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			resultados += 2;
			if (getDaysRented() > 2)
				resultados += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			resultados += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			resultados += 1.5;
			if (getDaysRented() > 3)
				resultados += (getDaysRented() - 3) * 1.5;
			break;
		}
		return resultados;
	}

	public int calculateFrequency() {

		int frequentRenterPoints = 1;

		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

}
