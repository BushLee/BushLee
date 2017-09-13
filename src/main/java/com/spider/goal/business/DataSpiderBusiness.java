package com.spider.goal.business;

import com.spider.goal.processor.BaseSchedureProcessor;
import us.codecraft.webmagic.Spider;

import java.util.List;
import java.util.Map;

/**
 * Created by sogaaIT003 on 2017/9/13.
 */
public class DataSpiderBusiness {
    public void grabDataBase(String year, int startRound, int endRound) {
        List<Map<String, String>> matchKes = grabBaseSchedureData(UrlBuilder.getBaseUrls(year, startRound, endRound));
        System.out.println(matchKes);
    }

    private List<Map<String, String>> grabBaseSchedureData(String... urls) {
        BaseSchedureProcessor baseSchedureProcessor = new BaseSchedureProcessor();
        Spider.create(baseSchedureProcessor)
                .addUrl(urls)
                .thread(1)
                .run();
        return baseSchedureProcessor.getResultList();
    }

}
