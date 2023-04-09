package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.AdItem;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "a_ad_item")
public interface AdItemDao extends BaseDao<AdItem, Long> {

    void deleteBySpaceId(Long spaceId);

}
