package com.movieflix.movieApi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieflix.movieApi.dto.MovieDto;
import com.movieflix.movieApi.dto.MoviePageResponse;
import com.movieflix.movieApi.exceptions.EmptyFileException;
import com.movieflix.movieApi.service.MovieService;
import com.movieflix.movieApi.utils.AppConstants;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add-movie")
    public ResponseEntity<MovieDto> addMovieHandler(@RequestPart MultipartFile file,
                                                    @RequestPart String movieDto) throws IOException {
        if(file.isEmpty()){
            throw new EmptyFileException("File is empty! Please send another file!");
        }

    MovieDto dto = convertToMovieDto(movieDto);
    return new ResponseEntity<>(movieService.addMovie(dto, file), HttpStatus.CREATED);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDto> getMovieHandler(@PathVariable Integer movieId){
        return ResponseEntity.ok(movieService.getMovie(movieId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> getAllMovieHandler(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PutMapping("/update/{movieId}")
    public ResponseEntity<MovieDto> updateMovieHandler(@PathVariable Integer movieId,
                                                       @RequestPart MultipartFile file,
                                                       @RequestPart String movieDtoObj) throws IOException {
        if(file.isEmpty()) file = null;
        MovieDto movieDto = convertToMovieDto(movieDtoObj);
        return ResponseEntity.ok(movieService.updateMovie(movieId, movieDto,file));
    }

    @DeleteMapping("/delete/{movieId}")
        public ResponseEntity<String> deleteMovieHandler(@PathVariable Integer movieId) throws IOException{
            return ResponseEntity.ok(movieService.deleteMovie(movieId));
        }



    @GetMapping("/allMoviesPage")
        public ResponseEntity<MoviePageResponse> getMoviesWithPagination(
                @RequestParam(defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                @RequestParam(defaultValue =  AppConstants.PAGE_SIZE, required = false) Integer pageSize
    ){
        return ResponseEntity.ok(movieService.getAllMoviesWithPagination(pageNumber,pageSize));
    }

    @GetMapping("/allMoviesPageSort")
    public ResponseEntity<MoviePageResponse> getMoviesWithPaginationSort(
            @RequestParam(defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(defaultValue =  AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(defaultValue =  AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(defaultValue =  AppConstants.SORT_DIR, required = false) String dir
    ){
        return ResponseEntity.ok(movieService.getAllMoviesWithPaginationAndSorting(pageNumber,pageSize, sortBy, dir));
    }



    //since form data takes text or file only we create a private method which will map our string to object
    private  MovieDto convertToMovieDto(String movieDtoObj) throws JsonProcessingException {

        //ObjectMapper from jackson
        ObjectMapper objectMapper = new ObjectMapper();
        MovieDto movieDto = objectMapper.readValue(movieDtoObj, MovieDto.class);
        return movieDto;

    }



}
