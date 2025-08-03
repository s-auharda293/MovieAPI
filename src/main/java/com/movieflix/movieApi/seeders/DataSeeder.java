package com.movieflix.movieApi.seeders;

import com.movieflix.movieApi.entities.Movie;
import com.movieflix.movieApi.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args){
        if(movieRepository.count()==0){
            List<Movie> movies = List.of(
                    new Movie(null, "The Shawshank Redemption", "Frank Darabont", "Castle Rock Entertainment",
                            Set.of("Tim Robbins", "Morgan Freeman"), 1994,
                            "https://upload.wikimedia.org/wikipedia/en/8/81/ShawshankRedemptionMoviePoster.jpg"),

                    new Movie(null, "The Godfather", "Francis Ford Coppola", "Paramount Pictures",
                            Set.of("Marlon Brando", "Al Pacino"), 1972,
                            "https://upload.wikimedia.org/wikipedia/en/1/1c/Godfather_ver1.jpg"),

                    new Movie(null, "The Dark Knight", "Christopher Nolan", "Warner Bros.",
                            Set.of("Christian Bale", "Heath Ledger"), 2008,
                            "https://upload.wikimedia.org/wikipedia/en/8/8a/Dark_Knight.jpg"),

                    new Movie(null, "Pulp Fiction", "Quentin Tarantino", "Miramax Films",
                            Set.of("John Travolta", "Uma Thurman"), 1994,
                            "https://upload.wikimedia.org/wikipedia/en/8/82/Pulp_Fiction_cover.jpg"),

                    new Movie(null, "Inception", "Christopher Nolan", "Warner Bros.",
                            Set.of("Leonardo DiCaprio", "Joseph Gordon-Levitt"), 2010,
                            "https://upload.wikimedia.org/wikipedia/en/7/7f/Inception_ver3.jpg"),

                    new Movie(null, "Forrest Gump", "Robert Zemeckis", "Paramount Pictures",
                            Set.of("Tom Hanks", "Robin Wright"), 1994,
                            "https://upload.wikimedia.org/wikipedia/en/6/67/Forrest_Gump_poster.jpg"),

                    new Movie(null, "Fight Club", "David Fincher", "20th Century Fox",
                            Set.of("Brad Pitt", "Edward Norton"), 1999,
                            "https://upload.wikimedia.org/wikipedia/en/f/fc/Fight_Club_poster.jpg"),

                    new Movie(null, "The Matrix", "Lana Wachowski, Lilly Wachowski", "Warner Bros.",
                            Set.of("Keanu Reeves", "Laurence Fishburne"), 1999,
                            "https://upload.wikimedia.org/wikipedia/en/c/c1/The_Matrix_Poster.jpg"),

                    new Movie(null, "Interstellar", "Christopher Nolan", "Paramount Pictures",
                            Set.of("Matthew McConaughey", "Anne Hathaway"), 2014,
                            "https://upload.wikimedia.org/wikipedia/en/b/bc/Interstellar_film_poster.jpg"),

                    new Movie(null, "Gladiator", "Ridley Scott", "DreamWorks Pictures",
                            Set.of("Russell Crowe", "Joaquin Phoenix"), 2000,
                            "https://upload.wikimedia.org/wikipedia/en/8/8d/Gladiator_ver1.jpg"),

                    new Movie(null, "Titanic", "James Cameron", "20th Century Fox",
                            Set.of("Leonardo DiCaprio", "Kate Winslet"), 1997,
                            "https://upload.wikimedia.org/wikipedia/en/2/22/Titanic_poster.jpg"),

                    new Movie(null, "The Lion King", "Roger Allers, Rob Minkoff", "Walt Disney Pictures",
                            Set.of("Matthew Broderick", "Jeremy Irons"), 1994,
                            "https://upload.wikimedia.org/wikipedia/en/3/3d/The_Lion_King_poster.jpg"),

                    new Movie(null, "The Social Network", "David Fincher", "Columbia Pictures",
                            Set.of("Jesse Eisenberg", "Andrew Garfield"), 2010,
                            "https://upload.wikimedia.org/wikipedia/en/7/7a/Social_network_film_poster.jpg"),

                    new Movie(null, "Joker", "Todd Phillips", "Warner Bros.",
                            Set.of("Joaquin Phoenix", "Robert De Niro"), 2019,
                            "https://upload.wikimedia.org/wikipedia/en/e/e1/Joker_%282019_film%29_poster.jpg"),

                    new Movie(null, "Whiplash", "Damien Chazelle", "Sony Pictures Classics",
                            Set.of("Miles Teller", "J.K. Simmons"), 2014,
                            "https://upload.wikimedia.org/wikipedia/en/0/01/Whiplash_poster.jpg"),

                    new Movie(null, "La La Land", "Damien Chazelle", "Summit Entertainment",
                            Set.of("Ryan Gosling", "Emma Stone"), 2016,
                            "https://upload.wikimedia.org/wikipedia/en/a/ab/La_La_Land_%28film%29.png"),

                    new Movie(null, "The Grand Budapest Hotel", "Wes Anderson", "Fox Searchlight Pictures",
                            Set.of("Ralph Fiennes", "Tony Revolori"), 2014,
                            "https://upload.wikimedia.org/wikipedia/en/a/a6/The_Grand_Budapest_Hotel_Poster.jpg"),

                    new Movie(null, "The Revenant", "Alejandro G. Iñárritu", "20th Century Fox",
                            Set.of("Leonardo DiCaprio", "Tom Hardy"), 2015,
                            "https://upload.wikimedia.org/wikipedia/en/b/b6/The_Revenant_2015_film_poster.jpg"),

                    new Movie(null, "Shutter Island", "Martin Scorsese", "Paramount Pictures",
                            Set.of("Leonardo DiCaprio", "Mark Ruffalo"), 2010,
                            "https://upload.wikimedia.org/wikipedia/en/7/76/Shutterislandposter.jpg"),

                    new Movie(null, "The Wolf of Wall Street", "Martin Scorsese", "Paramount Pictures",
                            Set.of("Leonardo DiCaprio", "Jonah Hill"), 2013,
                            "https://upload.wikimedia.org/wikipedia/en/1/1f/WallStreet2013poster.jpg")
            );

            movieRepository.saveAll(movies);
        }
    }
}
