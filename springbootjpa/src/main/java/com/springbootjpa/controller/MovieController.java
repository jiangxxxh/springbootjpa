package com.springbootjpa.controller;

import com.springbootjpa.domain.CustomType;
import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     *  查询所有
     * @return
     */
    @RequestMapping(value = "/movies",method = RequestMethod.GET)
    public ResponseEntity<?> getMovies(){
        CustomType customType = new CustomType(400,"查询无数据");
        List<Movie> movies = movieService.findAll();
        if(movies.isEmpty()){
            return new ResponseEntity<>(customType,HttpStatus.OK);
        }
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    /**
     *  根据ID 查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/movies/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getMovie(@PathVariable("id")Integer id){
        CustomType customType = new CustomType(400,"查询无此ID");
        Optional<Movie> movie = movieService.findById(id);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

    /**
     *  新增 | 修改
     * @param movie
     * @return
     */
    @RequestMapping(value = "/movies",method = RequestMethod.POST)
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        CustomType customType = new CustomType(200,"保存成功");
        try {
            movieService.save(movie);
        }catch (Exception e){
            customType.setCode(400);
            customType.setMessage("保存失败");
            e.printStackTrace();
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

    @RequestMapping(value = "/movies/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMovie(@PathVariable("id")Integer id){
        CustomType customType = new CustomType(200,"删除成功");
        try {
            movieService.deleteById(id);
        }catch (Exception e){
            customType.setCode(400);
            customType.setMessage("删除失败");
            e.printStackTrace();
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }


}
