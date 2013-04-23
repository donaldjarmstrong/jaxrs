package com.noip;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;

@Resource
@ManagedBean
public class MyService {
    void serviceCall() {
        System.out.print("Service calls");
    }
}
