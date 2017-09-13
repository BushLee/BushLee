package com.spider.goal.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sogaaIT003 on 2017/9/13.
 */
public class UrlBuilder {
    private static String baseUrl = "http://data.champdas.com/match/scheduleDetail-14-year-";

    private static String[] teamStatic = {
            "http://data.champdas.com/getMatchStaticListAjax.html?matchId=injectMatchId&half=injectHalf",           //整体数据
            "http://data.champdas.com/getMatchAttackAjax.html?matchId=injectMatchId&half=injectHalf",               //进攻数据
            "http://data.champdas.com/getMatchDefencesRateAjax.html?matchId=injectMatchId&half=injectHalf",         //防守数据
            "http://data.champdas.com/match/getLineChart.html?matchId=injectMatchId"                                //折线图数据
    };

    private static String playerStatic = "http://data.champdas.com/getMatchPersonAjax.html?matchId=injectMatchId";  //球员数据统计

    public static String[] getBaseUrls(String year, int startRound, int endRound) {
        List<String> urls = new ArrayList<>();
        while (endRound - startRound >= 0) {
            String url = baseUrl + startRound + ".html";
            urls.add(url.replace("year", year));
            startRound++;
        }
        return urls.toArray(new String[urls.size()]);
    }



}
