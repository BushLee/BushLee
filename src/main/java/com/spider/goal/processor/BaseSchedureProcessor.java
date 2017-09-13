package com.spider.goal.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sogaaIT003 on 2017/9/13.
 */
public class BaseSchedureProcessor implements PageProcessor {
    private List<Map<String, String>> resultList = new ArrayList<>();

    @Override
    public void process(Page page) {
        Selectable selectable = page.getHtml().xpath("//div[@class='score']");
        for (Selectable groupItem : selectable.nodes()) {
            String hostName = groupItem.xpath("//div[@class='left']/a/text()").toString();
            String guestName = groupItem.xpath("//div[@class='right']/a/text()").toString();
            String matchUrl = groupItem.xpath("//div[@class='mid']/a/@href").toString();
            String matchId = matchUrl.substring(matchUrl.lastIndexOf("-") + 1, matchUrl.lastIndexOf("."));
            Map<String, String> matchKey = new HashMap<>();
            matchKey.put("hostName", hostName);
            matchKey.put("guestName", guestName);
            matchKey.put("matchId", matchId);
            resultList.add(matchKey);
        }
    }

    @Override
    public Site getSite() {
        Site site = Site.me().setRetryTimes(3).setRetrySleepTime(3000);
        return site;
    }

    public List<Map<String, String>> getResultList() {
        return resultList;
    }
}
