package com.proxy.JDK;

//手机厂商
public class Produce implements PhoneProducer {

    @Override
    public void salePhone(float money) {
        System.out.println("销售出一台手机，厂家得到了"+money+"元");
    }

}
