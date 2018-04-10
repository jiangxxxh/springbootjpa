package com.springbootjpa.service.impl;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import com.springbootjpa.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
