package movie;

public class Movie {

    //평가별의 총 갯수
    private double totalRating;

    //평가한 사람의 수
    private int theNumberOfRater;

    public Movie() {
        totalRating = 0;
        theNumberOfRater = 0;
    }

    public double getAverageRating() {
        return theNumberOfRater == 0 ? 0: totalRating / theNumberOfRater;
    }

    public void rate(double rating) throws IllegalArgumentException{
        if(rating < 0 || rating > 5) throw new IllegalArgumentException("평점은 0점에서 5점 사이여야 합니다.");
        totalRating += rating;
        theNumberOfRater++;
    }
}
