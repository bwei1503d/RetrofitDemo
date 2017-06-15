package com.bwei.retrofitdemo.proxy;

/**
 * Created by muhanxi on 17/6/15.
 */

public class Fangdong implements Lianjie {



    @Override
    public void kanfang(int person) {


        System.out.println("Fangdong kanfang person = " + person);

    }

    @Override
    public String zufang(int person) {

        System.out.println("Fangdong zufang person = " + person);


        return "" + person;
    }
}
