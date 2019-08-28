package com.demo.springboot.mapper;

import com.demo.springboot.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName: ClazzMapper
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/31 15:53
 * @Version: 1.0
 */
@Mapper
public interface ClazzMapper {
    int addClazz(Clazz clazz);
    int deleteClazz(Clazz clazz);
    int updateClazz(Clazz clazz);
    List<Clazz> getClazzs(Clazz clazz);
}
