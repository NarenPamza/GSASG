import java.util.*;
import java.text.SimpleDateFormat;

public class MovieNight {
	
	public static Boolean canViewAll(List<Movie> movies) {

		try {

			for (int i = 0; i < movies.size(); i++) {

				for (int j = i + 1; j < movies.size(); j++) {

					Movie movie1 = movies.get(i);
					Movie movie2 = movies.get(j);
					if (compare(movie1, movie2)) {
						return false;
					} else {
						continue;
					}
				}

			}
		} catch (Exception e) {

			throw new UnsupportedOperationException(
					"Waiting to be implemented.");
		}

		return true;
	}
    
    
		public static boolean compare(Movie o1, Movie o2) {
			Date start1 = o1.getStart();
			Date end1 = o1.getEnd();
			Date start2 = o2.getStart();
			Date End2 = o2.getEnd();
			
			
			return  start1.before(End2) && start2.before(end1);
		}
    	
    

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));

        System.out.println(MovieNight.canViewAll(movies));
    }
}

class Movie {
    private Date start, end;
    
    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    } 
}