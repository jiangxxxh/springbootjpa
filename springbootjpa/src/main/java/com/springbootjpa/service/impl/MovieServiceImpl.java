package com.springbootjpa.service.impl;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import com.springbootjpa.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 业务逻辑接口的实现类
 *
 * @author SONG
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {
  @Autowired
  private MovieRepository movieRepository;

  /**
   * 新增(无 id) | 修改(有 id)
   *
   * @param movie
   */
  @Override
  public void save(Movie movie) {
    movieRepository.save(movie);
  }

  /**
   * 根据 id 删除
   *
   * @param id
   */
  @Override
  public void deleteById(Integer id) {
    movieRepository.deleteById(id);
  }

  /**
   * 查询所有
   *
   * @return
   */
  @Override
  public List<Movie> findAll() {
    return movieRepository.findAll();
  }

  /**
   * 根据 id 查询
   *
   * @param id
   * @return
   */
  @Override
  public Optional<Movie> findById(Integer id) {
    return movieRepository.findById(id);
  }

  @Override
  public List<Movie> findByName(String name){
    return movieRepository.findByName(name);
  }

  /**
   * 根据电影名查询
   * @param name
   * @return
   */
  @Override
  public List<Movie> findByName2(String name) {
    return movieRepository.findByName2(name);
  }

  @Override
  public List<Movie> findByNameLike(String name) {
    return movieRepository.findByNameLike(name);
  }

  @Override
  public List<Movie> findByNameNotLike(String name) {
    return movieRepository.findByNameNotLike(name);
  }

  @Override
  public List<Movie> findByNameNotLikeAndPrice(String name, Double price) {
    return movieRepository.findByNameNotLikeAndPrice(name,price);
  }

  @Override
  public List<Movie> findByActionTimeBetween(Date beginDate, Date endDate) {
    return movieRepository.findByActionTimeBetween(beginDate, endDate);
  }

  @Override
  public List<Movie> findByNameLikeAndActionTimeBetween(String name, Date beginDate, Date endDate) {
    return movieRepository.findByNameLikeAndActionTimeBetween(name, beginDate, endDate);
  }

  @Override
  public Page<Movie> findAll(Pageable var) {
    return movieRepository.findAll(var);
  }


  @Override
  public List<Movie> findAll(Sort sort) {
    return movieRepository.findAll(sort);
  }


}
