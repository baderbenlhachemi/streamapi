public class Movie {
    private String title;
    private int rating;
    private Genre genre;

    public Movie(String title, int rating, Genre genre) {
        this.title = title;
        this.rating = rating;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return this.getTitle() + ", " + this.getGenre() + ", " + this.getRating() + " stars";
    }
}

