package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SRBC 
{
    private static float[][] genreSimilarityMatrix;
    private static Movie[] movies;
    
    private static List<String> titles;
    private static List<String> actors;
    private static List<String> directors;
    private static List<String> plots;
    
    public static void Init()
    {
        movies = loadMovies("data/movies.csv");
        genreSimilarityMatrix = loadGenresSimilarityMatrix("data/genres.csv");
        
        titles = new ArrayList();
        actors = new ArrayList();
        directors = new ArrayList();
        plots = new ArrayList();
        
        for (Movie m : movies)
        {
            titles.add(m.title);
            
            if (!actors.contains(m.actor))
                actors.add(m.actor);
            
            if (!directors.contains(m.director))
                directors.add(m.director);
            
            for (String plot : m.plots)
                if (!plots.contains(plot))
                    plots.add(plot);
        }
    }
    
    public static List<String> getTitles()
    {
        return titles;
    }
    
    public static List<String> getActors()
    {
        return actors;
    }
    
    public static List<String> getDirectors()
    {
        return directors;
    }
    
    public static List<String> getPlots()
    {
        return plots;
    }
    
    public static Movie searchMovieByTitle(String title)
    {
        for (Movie m : movies)
        {
            if (m.title.equals(title))
                return m;
        }
        
        return null;
    }
    
    public static List<SimilarityResult> getSimilarMovies(Movie target, WeightConfig weights) 
    {
        List<SimilarityResult> result = new ArrayList(movies.length);
        
        // Calcula a similaridade do filme 'target' com todos
        // os filmes da base.
        for (int i = 0; i < movies.length; ++i)
        {
            SimilarityResult sim = new SimilarityResult();
            sim.similarity = movieSimilarity(target, movies[i], genreSimilarityMatrix, weights);
            sim.movie = movies[i];
            result.add(sim);
        }
       
        // Ordena por grau de similaridade
        Collections.sort(result, new Comparator<SimilarityResult>() {
            @Override
            public int compare(SimilarityResult a, SimilarityResult b) {
                return Float.compare(a.similarity, b.similarity);
            }
        });
        
        return result;
    }
    
    private static Genre[] splitGenres(String genres)
    {
        String[] names = genres.replace("-", "_").toUpperCase().split("\\|");
        Genre[] result = new Genre[names.length];
        
        for (int i = 0; i < names.length; ++i)
            result[i] = Genre.valueOf(names[i]);
        
        return result;
    }
    
    private static Movie[] loadMovies(String csvFilePath)
    {
        final int TITLE_INDEX     = 0;
        final int GENRES_INDEX    = 1;
        final int DIRECTOR_INDEX  = 2;
        final int ACTOR_INDEX     = 3;
        final int PLOT_INDEX      = 4;
        final int YEAR_INDEX      = 5;
        final int COUNTRY_INDEX   = 6;
        
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) 
        {
            while (br.readLine() != null) lineCount++;
        }
        catch (IOException ex) 
        {
            System.err.println(ex.getMessage());
        }
        
        Movie[] movieList = new Movie[lineCount-1];
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) 
        {
            int index = -1;
            String line;
            while ((line = br.readLine()) != null )
            {
                if (index == -1)
                {
                    index = 0;
                    continue;
                }
                
                String movieLine = line.replace(";;", "; ;") + " ";
                String[] atributes = movieLine.split(";");
                
                Movie m = new Movie();
                m.title     = atributes[TITLE_INDEX].replaceAll("\u00A0", "");
                m.genres    = splitGenres(atributes[GENRES_INDEX]);
                m.director  = atributes[DIRECTOR_INDEX];
                m.actor     = atributes[ACTOR_INDEX];
                m.plots     = atributes[PLOT_INDEX].split("\\|");
                m.year      = atributes[YEAR_INDEX];
                m.country   = atributes[COUNTRY_INDEX];
                
                movieList[index++] = m;
            }
        } 
        catch (IOException ex) 
        {
            System.err.println(ex.getMessage());
        }
        
        return movieList;
    }
    
    private static float[][] loadGenresSimilarityMatrix(String pathToCsv)
    {
        float genres[][] = new float[19][19];
        try (BufferedReader br = new BufferedReader(new FileReader(pathToCsv))) 
        {
            int row = -1;
            String line;
            while ((line = br.readLine()) != null )
            {
                // Ignora a primeira linha com os nomes das colunas
                if (row == -1) {
                    row = 0;
                    continue;
                }
                
                String genreLine = line.replace(";;", ";0;").replace(",", ".");
                String[] values = genreLine.split(";");
                
                genres[row][0]  = Float.parseFloat(values[1]);
                genres[row][1]  = Float.parseFloat(values[2]);
                genres[row][2]  = Float.parseFloat(values[3]);
                genres[row][3]  = Float.parseFloat(values[4]);
                genres[row][4]  = Float.parseFloat(values[5]);
                genres[row][5]  = Float.parseFloat(values[6]);
                genres[row][6]  = Float.parseFloat(values[7]);
                genres[row][7]  = Float.parseFloat(values[8]);
                genres[row][8]  = Float.parseFloat(values[9]);
                genres[row][9]  = Float.parseFloat(values[10]);
                genres[row][10] = Float.parseFloat(values[11]);
                genres[row][11] = Float.parseFloat(values[12]);
                genres[row][12] = Float.parseFloat(values[13]);
                genres[row][13] = Float.parseFloat(values[14]);
                genres[row][14] = Float.parseFloat(values[15]);
                genres[row][15] = Float.parseFloat(values[16]);
                genres[row][16] = Float.parseFloat(values[17]);
                genres[row][17] = Float.parseFloat(values[18]);
                genres[row][18] = Float.parseFloat(values[19]);
                
                row++;
            }
        } 
        catch (IOException ex) 
        {
            System.err.println(ex.getMessage());
        }
        
        return genres;
    }
    
    private static float genreSimilarity(Genre[] genresA, Genre[] genresB, float[][] similarityMatrix)
    {
        float result = 0;
        
        // Para cada genero do filme A, calcula a similaridade
        // com todos os generos do filme B.
        for (int i = 0; i < genresA.length; ++i)
        {
            Genre genreA = genresA[i];
            
            for (int j = 0; j < genresB.length; ++j)
            {
                Genre genreB = genresB[j];
                
                float similarity = similarityMatrix[genreA.ordinal()][genreB.ordinal()];
                
                if (similarity > result)
                    result = similarity;
            }
        }
        return result;
    }
    
    private static float titleSimilarity(String titleA, String titleB)
    {
        return titleA.equals(titleB) ? 1.0f : 0.0f;
    }
    
    private static float directorSimilarity(String directorA, String directorB)
    {
        return directorA.equals(directorB) ? 1.0f : 0.0f;
    }
    
    private static float actorSimilarity(String actorA, String actorB)
    {
        return actorA.equals(actorB) ? 1.0f : 0.0f;
    }
    
    private static float plotSimilarity(String[] plotsA, String[] plotsB)
    {
        float result = 0.0f;
        
        for (int i = 0; i < plotsA.length; ++i)
        {
            String plotA = plotsA[i];
            for (int j = 0; j < plotsB.length; ++j)
            {
                String plotB = plotsB[j];
                if (plotA.equals(plotB))
                    result += 1.0f;
            }
        }
        
        if (plotsA.length > 0)
            result = result / plotsA.length;
        
        return result;
    }
    
    private static float movieSimilarity(Movie target, Movie other, float[][] genreSimilarityMatrix, WeightConfig w)
    {
        float titleSimilaritySum      = w.title * titleSimilarity(target.title, other.title);
        float genreSimilaritySum      = w.genre * genreSimilarity(target.genres, other.genres, genreSimilarityMatrix);
        float directorSimilaritySum   = w.director * directorSimilarity(target.director, other.director);
        float actorSimilaritySum      = w.actor * actorSimilarity(target.actor, other.actor);
        float plotSimilaritySum       = w.plot * plotSimilarity(target.plots, other.plots);
        
        return (titleSimilaritySum+
               genreSimilaritySum+
               directorSimilaritySum+
               actorSimilaritySum+
               plotSimilaritySum) / (w.title + w.genre + w.director + w.actor + w.plot);
    }
}
