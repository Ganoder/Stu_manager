package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.DevelopmentPlanning;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DevelopmentPlanningMapper {
    List<DevelopmentPlanning> findAllDevelopment();
}
