package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 业务逻辑接口
 *
 * @author SONG
 */
public interface MovieService {
  void save(Movie movie);

  void deleteById(Integer id);

  List<Movie> findAll();



  Optional<Movie> findById(Integer id);

  List<Movie> findByName(String name);

  List<Movie> findByName2(String name);

  List<Movie> findByNameLike(String name);

  List<Movie> findByNameNotLike(String name);

  List<Movie> findByNameNotLikeAndPrice(String name,Double price);

  List<Movie> findByActionTimeBetween(Date beginDate, Date endDate);

  List<Movie> findByNameLikeAndActionTimeBetween(String name,Date beginDate,Date endDate);

  // 分页+ 排序
  Page<Movie> findAll(Pageable var1);

  // 排序（排序方式、排序属性）
  List<Movie> findAll(Sort sort);

  // 待条件分页查询排序
  Page<Movie> findAll(Example<Movie> var1, Pageable var2);
}
