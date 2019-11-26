package com.hhhxiao.debug;

public class Logger {
    public static final int DEBUG = 0;
    public static final int INFO = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;

    private static int logLevel = Logger.DEBUG;

    public static void  setLogLevel(int level){
        logLevel = level;
    }

    public  static void d(Object o){
        if(logLevel <= DEBUG)
            System.out.println("DEBUG: " + o.toString());
    }

    public static void i(Object o){
        if(logLevel <= INFO)
            System.out.println("INFO: " + o.toString());
    }

    public  static void w(Object o){
        if(logLevel <= WARNING)
            System.out.println("WARNING: " + o.toString());
    }

    public static void e(Object o){
        if(logLevel <= ERROR)
            System.out.println("ERROR: " + o.toString());
    }

}
