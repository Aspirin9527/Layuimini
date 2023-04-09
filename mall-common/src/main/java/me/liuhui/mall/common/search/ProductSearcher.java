package me.liuhui.mall.common.search;

import me.liuhui.mall.common.search.document.ProductDoc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/10/30 11:56
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
public class ProductSearcher  extends BaseSearcher<ProductDoc,Long> {

    @Override
    public Map<String, Float> getDefaultSearchFields() {
        Map<String,Float> map = new HashMap<>(2);
        map.put("name",10.0f);
        map.put("categoryNames",1.0f);
        return map;
    }
}
