package com.noip;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/webapi")
public class MyApplication extends Application {

    public MyApplication() {
        System.out.println("hello");
    }
}
