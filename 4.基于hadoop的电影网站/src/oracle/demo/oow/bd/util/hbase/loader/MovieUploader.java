package oracle.demo.oow.bd.util.hbase.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import oracle.demo.oow.bd.constant.Constant;
import oracle.demo.oow.bd.constant.KeyConstant;
import oracle.demo.oow.bd.dao.hbase.CastDAO;
import oracle.demo.oow.bd.dao.hbase.CrewDAO;
import oracle.demo.oow.bd.dao.hbase.MovieDao;
import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.CrewTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;

public class MovieUploader
{
	public static void uploadMovieInfo(
            ) throws IOException {
FileReader fr = null;
try {
fr = new FileReader(Constant.WIKI_MOVIE_INFO_FILE_NAME);
BufferedReader br = new BufferedReader(fr);
String jsonTxt = null;
MovieTO movieTO = null;
MovieDao movieDAO = new MovieDao();
int count = 1;

//Each line in the file is the JSON string

//Construct MovieTO from JSON object
while ((jsonTxt = br.readLine()) != null) {

try {
    movieTO = new MovieTO(jsonTxt.trim());
} catch (Exception e) {
    System.out.println("ERROR: Not able to parse the json string: \t" +
                       jsonTxt);
}

if (movieTO != null && !movieTO.isAdult()) {
    
    System.out.println(count++ + " " +
                       movieTO.getMovieJsonTxt());
    
   ArrayList<GenreTO> genreList = movieTO.getGenres();
    ArrayList<GenreTO> genreList2 = new ArrayList<GenreTO>();
    Iterator<GenreTO> iter = genreList.iterator();
    while (iter.hasNext()) {
        GenreTO genreTO = iter.next();
        genreTO.setCid(KeyConstant.GENRE_TABLE);
        genreList2.add(genreTO);
        
    }
    movieTO.setGenres(genreList2);
    /**
 * Save the movie into the kv-store or rdbms
 */

    
        movieDAO.insertMovie(movieTO);


} //EOF if
} //if(maxMovies>0 && count < maxMovies)



} catch (FileNotFoundException e) {
e.printStackTrace();
} finally {
fr.close();
}


} //uploadMovies

/**
* This method reads the file with MOVIE-CAST records and load it into kv-store
* one movie at a time
* @throws IOException
*/
public static void uploadMovieCast() throws IOException {
FileReader fr = null;
try {
fr = new FileReader(Constant.WIKI_MOVIE_CAST_FILE_NAME);
BufferedReader br = new BufferedReader(fr);
String jsonTxt = null;
CastTO castTO = null;
int count = 1;

//Each line in the file is the JSON string

//Construct MovieTO from JSON object
while ((jsonTxt = br.readLine()) != null) {
try {
castTO = new CastTO(jsonTxt.trim());
} catch (Exception e) {
System.out.println("ERROR: Not able to parse the json string: \t" +
                   jsonTxt);
}

if (castTO != null) {
System.out.println(count++ + " " + castTO.getJsonTxt());
/**
 * Save the movie into the kv-store
 */
CastDAO castDAO = new CastDAO();


    castDAO.insertCastInfo(castTO);


} //EOF if

} //EOF while
} catch (FileNotFoundException e) {
e.printStackTrace();
} finally {
fr.close();
}


} //uploadMovies

/**
* This method reads the file with movie Crew records and load it into kv-store
* one movie at a time
* @throws IOException
*/
public static void uploadMovieCrew() throws IOException {
FileReader fr = null;
try {
fr = new FileReader(Constant.WIKI_MOVIE_CREW_FILE_NAME);
BufferedReader br = new BufferedReader(fr);
String jsonTxt = null;
CrewTO crewTO = null;
int count = 1;

//Each line in the file is the JSON string

//Construct MovieTO from JSON object
while ((jsonTxt = br.readLine()) != null) {
try {
crewTO = new CrewTO(jsonTxt.trim());
} catch (Exception e) {
System.out.println("ERROR: Not able to parse the json string: \t" +
                   jsonTxt);
}

if (crewTO != null) {
System.out.println(count++ + " " + crewTO.getJsonTxt());
/**
 * Save the movie into the kv-store
 */
CrewDAO crewDAO = new CrewDAO();


    crewDAO.insertCrewInfo(crewTO);



} //EOF if

} //EOF while
} catch (FileNotFoundException e) {
e.printStackTrace();
} finally 
{
	
fr.close();
}


} //uploadMovieCrew
	public static void main(String[] args)
	{
		try
		{
			uploadMovieInfo();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
