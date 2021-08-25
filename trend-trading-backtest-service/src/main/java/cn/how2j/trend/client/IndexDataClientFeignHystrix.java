package cn.how2j.trend.client;

import java.util.List;

import org.springframework.stereotype.Component;

import cn.how2j.trend.pojo.IndexData;
import cn.hutool.core.collection.CollectionUtil;

@Component
public class IndexDataClientFeignHystrix implements IndexDataClient {

    @Override
    public List<IndexData> getIndexData(String code) {
        IndexData indexData = new IndexData();
        indexData.setClosePoint(0);
        indexData.setDate("0000-00-00");
        return CollectionUtil.toList(indexData);
    }

}