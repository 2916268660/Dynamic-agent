package com.proxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxy implements InvocationHandler {

    private Object target;
    //通过构造函数传入目标对象
    public JDKProxy (Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        //增强代码，即模仿一个手机售卖店
        if("salePhone".equals(method.getName())){
            Float money = (Float)args[0]*0.8f;
            result = method.invoke(target,money);
            System.out.println("售卖店得到了"+((Float)args[0]-money)+"元");
        }
        return result;
    }
}
