package com.spider;

import com.spider.goal.business.DataSpiderBusiness;

/**
 * Created by sogaaIT003 on 2017/9/13.
 */
public class MainStart {

    public static void main(String[] args) {
        DataSpiderBusiness dataSpiderBusiness = new DataSpiderBusiness();
        dataSpiderBusiness.grabDataBase("2017", 1, 4);
    }
}
