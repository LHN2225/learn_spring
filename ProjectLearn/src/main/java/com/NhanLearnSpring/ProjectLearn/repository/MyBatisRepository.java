package com.NhanLearnSpring.ProjectLearn.repository;

import com.NhanLearnSpring.ProjectLearn.dto.CountryDto;
import com.NhanLearnSpring.ProjectLearn.dto.CountryNameDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MyBatisRepository {

    @Select("select name from countries where id = #{id}")
    @Results({
            @Result(property= "name", column= "name")
    })
    public CountryNameDto getNameCountryByID(int id);

    @Select("select * from countries")
    @Results({
            @Result(property= "id", column= "id"),
            @Result(property= "name", column= "name")
    })
    public List<CountryDto> getAllCountry();


    @Insert("insert into countries values (#{id}, #{name})")
    public int addCountry(CountryDto country);

    @Update("update countries set name = #{name} where id = #{id}")
    public int updateCountry(CountryDto country);

    @Delete("delete from countries where id = #{id}")
    public int delCountry(int id);
}
