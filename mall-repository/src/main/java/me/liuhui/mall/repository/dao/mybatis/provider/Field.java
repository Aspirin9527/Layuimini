package me.liuhui.mall.repository.dao.mybatis.provider;

import me.liuhui.mall.repository.model.annotation.LogicDelete;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * Created on 2019/6/13 10:53
 * <p>
 * Description: [反射字段描述]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@Data
public class Field {
    private String name;
    private String column;
    private Method getMethod;
    private LogicDelete logicDelete;
}
