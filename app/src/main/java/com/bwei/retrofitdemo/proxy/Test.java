package com.bwei.retrofitdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.reflect.Proxy.newProxyInstance;

/**
 * Created by muhanxi on 17/6/15.
 */

public class Test {


    public static void main(String [] args) {


       final Lianjie lianjie = new Fangdong();


        /**
         *
         * getClassLoader 类加载器
         * new Class[]{Lianjie.class} 固定的
         *InvocationHandler
         */
        Lianjie object = (Lianjie) Proxy.newProxyInstance(Lianjie.class.getClassLoader(), new Class[]{Lianjie.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                System.out.println("method = " + method);

                System.out.println("args = " + args[0]);

               Object object =   method.invoke(lianjie,args);

                return object;
            }
        });

        object.kanfang(10);

//        object.zufang(5);



    }


}
