package com.proxy.CGLIB;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//模式一个顾客
public class Customer {

    public static void main(String[] args) {
        //创建一个将要被代理的对象
        Produce produce = new Produce();
        //创建代理对象,
        Produce cglibProxy =(Produce) Enhancer.create(produce.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                //增强代码，即模仿一个手机售卖店
                if ("salePhone".equals(method.getName())) {
                    Float temp =(Float) args[0];   //将参数先赋值给一个临时变量
                    args[0] = (Float) args[0] * 0.8f;   //一台手机厂家可以得到多钱
                    result = methodProxy.invokeSuper(obj, args);
                    System.out.println("售卖店得到了" + (temp -(Float) args[0]) + "元");  //店家一台手机赚取多少钱
                }
                return result;
            }
        });
        cglibProxy.salePhone(3000f);  //一台手机以3k的价格卖出
    }
}
