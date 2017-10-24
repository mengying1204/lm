package com.bupt.common.utils;

import java.util.Date;
import java.util.Random;

/**
 * Created by mengying on 2017/9/26.
 */
public class NumberUtills {

    public static String getNumber() {
        String seqID = "";
        seqID+= getNO();
        seqID += String.valueOf(RandomI(0, 9));
        seqID += String.valueOf(RandomI(0, 9));
        return seqID;
    }

    public static int RandomI(int m, int n) {
        double j = Math.round(Math.random() * (n - m));
        return (int) (j + m);
    }

    public static String getNO() {
        Long date = new Date().getTime();
        String time = date.toString();
        return time;
    }

    public static String state(){
        Random random=new Random();
        double ran=random.nextDouble();
        if(ran<0.7){
            return 0+"";
        }else if(ran<0.95){
            return 1+"";
        }else return 2+"";
    }





}
