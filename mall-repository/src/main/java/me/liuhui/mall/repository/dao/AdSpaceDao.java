package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.AdSpace;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "a_ad_space")
public interface AdSpaceDao extends BaseDao<AdSpace, Long> {
	AdSpace selectByNo(String v);

}
