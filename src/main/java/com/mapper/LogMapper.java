package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.LogInfo;

public interface LogMapper {
	List<LogInfo> selAll();

	List<LogInfo> selByAccOutAccIn1(String accOut, String accIn);

	List<LogInfo> selByAccOutAccIn2(String accOut, String accIn);

	// mybatis 就把参数转换成map了，其中@Param("key") 后面的参数为内容
	List<LogInfo> selByAccOutAccIn3(@Param("accOut") String accOut, @Param("accIn") String accIn);

}
