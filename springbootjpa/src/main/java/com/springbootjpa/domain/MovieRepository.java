package com.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * 持久层: 由 jpa 管理
 *
 * @author SONG
 */
public interface MovieRepository extends JpaRepository<Movie, Integer> {
  // 包含了一般的增删改查

    List<Movie> findByName(String name);

    // hql : Hibernater Query language : Hibernate 查询语言 - 类名 + 属性名
    // value = "select m from Movie m where m.name=:name"
    @Query(value = "from Movie m where m.name=:name")
    List<Movie> findByName2(@Param("name") String name);

    // 模糊查询
    List<Movie> findByNameLike(String name);

    // 模糊查询 不包含
    List<Movie> findByNameNotLike(String name);

    // 条件查询不包含 name 并且等于 price 的数据
    List<Movie> findByNameNotLikeAndPrice(String name,Double price);

    List<Movie> findByActionTimeBetween(Date beginDate,Date endDate);

    List<Movie> findByNameLikeAndActionTimeBetween(String name,Date beginDate,Date endDate);
}
