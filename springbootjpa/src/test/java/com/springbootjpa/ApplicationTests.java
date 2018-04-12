package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private MovieService movieService;

    @Test
    public void save() {
        Movie movie = new Movie();
        movie.setName("变形金刚");
        movie.setPrice(100d);
        movie.setActionTime(new Date());

        movieService.save(movie);
    }



    @Test
    public void findById() {

        Optional<Movie> optionalMovie = movieService.findById(2);
        if(optionalMovie.isPresent()){
            System.out.println(optionalMovie.get());
        }
    }

    @Test
    public void deleteById() {
        movieService.deleteById(4);
        System.out.println("delete");
    }

    @Test
    public void findByName() {
        List<Movie> list = movieService.findByName2("号");
        for(Movie m:list){
            System.out.println(m);
        }
    }

    @Test
    public void findByNameLike() {
        List<Movie> list = movieService.findByNameLike("%头%");
        for(Movie m:list){
            System.out.println(m);
        }
    }

    @Test
    public void findByNameNotLike() {
        List<Movie> list = movieService.findByNameNotLike("%头%");
        for(Movie m:list){
            System.out.println(m);
        }
    }

    @Test
    public void findByNameNotLikeAndPrice(){
        List<Movie> list = movieService.findByNameNotLikeAndPrice("%头%",60d);
        for(Movie m:list){
            System.out.println(m);
        }
    }

    @Test
    public void findByActionTimeBetween(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = sdf.parse("2018-04-09 00:00:00");
            endDate = sdf.parse("2018-04-10 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Movie> list = movieService.findByActionTimeBetween(beginDate,endDate);
        for(Movie m:list){
            System.out.println(m);
        }
    }

    @Test
    public void findByNameActionTime() {
        String name = "%头%";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = null;
        Date endDate = null;

        try {
            beginDate = sdf.parse("2018-04-09 00:00:00");
            endDate = sdf.parse("2018-04-10 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Movie> list = movieService.findByNameLikeAndActionTimeBetween(name,beginDate,endDate);
        for(Movie m:list){
            System.out.println(m);
        }

    }

    @Test
    public void findAll() {
        // 排序方式  排序属性
        Sort sort = new Sort(Sort.Direction.DESC,"actionTime");
        List<Movie> list = movieService.findAll(sort);
        for(Movie m:list){
            System.out.println(m);
        }
    }

    @Test
    public void page() {
        // 页码从 0 开始
        Integer pageNumber = 0;
        Integer pageSize = 2;
        Sort sort = new Sort(Sort.Direction.DESC,"price");
        // 实例化一个 Pageable 对象
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<Movie> moviePage = movieService.findAll(pageable);
        System.out.println("总页数"+moviePage.getTotalPages());
        // 获得里面的内容
        List<Movie> list = moviePage.getContent();
        for(Movie m:list){
            System.out.println(m);
        }
    }
}
