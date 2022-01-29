package com.yanzx.lib.demo;

public class SubClass {
    public void paramThis(){
        paramThis2(this);
    }

    public void paramThis2(Object obj){
    }

    public static void paramThis3(Object obj2){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void paramThis5(){
    }

    static void paramThis4(){
        SubClass.paramThis3(SubClass.class);
        SubClass.paramThis3(null);
        paramThis5();
    }

    public static class SubClassClass2 extends SubClass {
        public void paramThis2(Object obj){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
