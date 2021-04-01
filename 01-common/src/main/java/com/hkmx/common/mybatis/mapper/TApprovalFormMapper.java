package com.hkmx.common.mybatis.mapper;

import com.hkmx.common.mybatis.model.TApprovalForm;
import com.hkmx.common.mybatis.model.TApprovalFormExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TApprovalFormMapper {
    int countByExample(TApprovalFormExample example);

    int deleteByExample(TApprovalFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TApprovalForm record);

    int insertSelective(TApprovalForm record);

    List<TApprovalForm> selectByExample(TApprovalFormExample example);

    TApprovalForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TApprovalForm record, @Param("example") TApprovalFormExample example);

    int updateByExample(@Param("record") TApprovalForm record, @Param("example") TApprovalFormExample example);

    int updateByPrimaryKeySelective(TApprovalForm record);

    int updateByPrimaryKey(TApprovalForm record);
}