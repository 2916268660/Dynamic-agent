package com.proxy.JDK;

import com.oracle.jrockit.jfr.Producer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//模式一个顾客
public class Customer {

    public static void main(String[] args) {
        Produce produce = new Produce();
        //创建代理对象
        PhoneProducer jdkproxy =(PhoneProducer) Proxy.newProxyInstance(
                produce.getClass().getClassLoader(),
                produce.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        //增强代码，即模仿一个手机售卖店
                        if("salePhone".equals(method.getName())){
                            Float money = (Float)args[0]*0.8f;
                            result = method.invoke(produce,money);
                            System.out.println("售卖店得到了"+((Float)args[0]-money)+"元");
                        }
                        return result;
                    }
                });


        jdkproxy.salePhone(1200f);
    }
}
