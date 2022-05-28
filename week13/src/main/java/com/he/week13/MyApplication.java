package com.he.week13;

import android.app.Application;

/**
 * Created by 86186 on 2022/5/23.
 */

public class MyApplication extends Application {
    private String userName;
    private String orgName;


    @Override
    public void onCreate() {
        super.onCreate();
        setUserName("annoymous");
        setOrgName("nukonwn");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
