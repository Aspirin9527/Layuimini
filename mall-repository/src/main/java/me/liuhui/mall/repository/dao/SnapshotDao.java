package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Snapshot;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "p_snapshot")
public interface SnapshotDao extends BaseDao<Snapshot,Long> {
	
}
