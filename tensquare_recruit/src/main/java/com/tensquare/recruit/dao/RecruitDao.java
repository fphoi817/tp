package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {

    // 查询状态为2 并以创建日期降序排序, 查询前4条
    List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    // 查询状态不为0, 并且以创建日期降序排序, 查询12条
    List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
