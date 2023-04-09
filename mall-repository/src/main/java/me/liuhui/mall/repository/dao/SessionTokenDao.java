package me.liuhui.mall.repository.dao;

import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.SessionToken;
import me.liuhui.mall.repository.model.annotation.MapperMapping;
import me.liuhui.mall.repository.model.dao.DateCount;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@MapperMapping(table = "u_session_token")
public interface SessionTokenDao extends BaseDao<SessionToken,Long> {
	SessionToken selectBySessionToken(String v) ;

	List<DateCount> countToken(@Param("minCreateTime") Date minCreateTime, @Param("maxCreateTime") Date maxCreateTime);
}
