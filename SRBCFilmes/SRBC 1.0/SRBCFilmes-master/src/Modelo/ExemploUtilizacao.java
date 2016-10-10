package Modelo;


import java.util.List;

// Classe de exemplo, mostrando como utilizar a lógica na view
public class ExemploUtilizacao 
{
    public static void main(String[] args) 
    {
        // Inicia o SRBC (carrega os CSVs)
        SRBC.Init();
        
        // Para sugerir dados ao usuário na tela conforme
        // ele for digitando, pode-se utilizar as seguintes
        // funções:
//        
//        System.out.println("Titulos: ===================================");
//        for (String title : SRBC.getTitles())
//        {
//            System.out.println(title);
//        }
//        
//        System.out.println("Atores: ===================================");
//        for (String actor : SRBC.getActors())
//        {
//            System.out.println(actor);
//        }
//        
//        System.out.println("Diretores: ===================================");
//        for (String director : SRBC.getDirectors())
//        {
//            System.out.println(director);
//        }
//        
//        System.out.println("Plots: ===================================");
//        for (String plot : SRBC.getPlots())
//        {
//            System.out.println(plot);
//        }
        
        // Pode-se usar a função 'searchMovieByTitle' para buscar 
        // um filme pelo nome e preencher os campos da tela com 
        // os dados do filme.
        Movie filmeDoUsuario = SRBC.searchMovieByTitle("Harry Potter and the Chamber of Secrets");
        if (filmeDoUsuario != null)
        {
            // Configura os pesos de cada atributo
            WeightConfig pesos = new WeightConfig();
            pesos.title = 0.4f;
            pesos.genre = 1.0f;
            pesos.director = 0.8f;
            pesos.actor = 0.9f;
            pesos.plot = 0.6f;
            
            // Busca a lista ordenada de todos os filmes semelhantes.
            List<SimilarityResult> filmesSemelhantes = SRBC.getSimilarMovies(filmeDoUsuario, pesos);
            for (SimilarityResult sr : filmesSemelhantes)
            {
                Movie filme = sr.movie;
                float similaridade = sr.similarity;
                
                System.out.println((int)(similaridade*100.0f)+"% => "+filme.title);
            }
        }
        else
        {
            System.err.println("Filme não encontrado. Verifique o nome");
        }
    }
}
