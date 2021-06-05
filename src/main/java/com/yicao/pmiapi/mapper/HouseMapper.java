package com.yicao.pmiapi.mapper;

import com.yicao.pmiapi.pojo.House;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yicao
 * @since 2021-04-29
 */
public interface HouseMapper extends BaseMapper<House> {

    String getAddressById(Integer id);

    List<House> getListByFamilyId(@Param("family_id") Integer familyId);
}
