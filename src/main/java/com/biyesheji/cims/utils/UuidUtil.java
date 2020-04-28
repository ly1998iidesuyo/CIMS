package com.biyesheji.cims.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UuidUtil {

    /**
     * 生成社区主键id
     * @return
     */
    public static String CimsSheqUid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomNumeric(4);
        String id = "sq" + format.format(now) + suffix;
        return id;
    }

    /**
     * 生成户籍主键id
     * @return
     */
    public static String CimsHujiUuid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomNumeric(4);
        String id = "hj" + format.format(now) + suffix;
        return id;
    }

    public static String CimsJuminbUuid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomNumeric(4);
        String id = "jmb" + format.format(now) + suffix;
        return id;
    }

    public static String CimsPinkunUuid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomNumeric(4);
        String id = "pk" + format.format(now) + suffix;
        return id;
    }

    public static String CimsPinkunjiluUuid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomNumeric(4);
        String id = "pkjl" + format.format(now) + suffix;
        return id;
    }
}
