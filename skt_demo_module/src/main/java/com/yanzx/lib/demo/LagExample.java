package com.yanzx.lib.demo;

/**
 * Created on 2019/12/21 in com.test.demo.
 */
@Deprecated
public class LagExample {
    public LagExample(){
    }
    
    public LagExample(int i){
        funLag();
    }
    
    public void funLag(){
        try {
            Thread.sleep(20L);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }
        return;
    }

    public void lagAndThrow(int i) {
        lagAndThrow2(i);
    }

    public void lagAndThrow2(int i) {
        lagAndThrow3(i);
    }

    public void lagAndThrow3(int i) {
        lagAndThrow4(i);
    }

    public void lagAndThrow4(int j) {
        for(int i=0; i<j; ++i){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }
        throw new RuntimeException();
    }

    public void throwTest(int i) {
        throwTest2(i);
    }

    public void throwTest2(int i) {
        throwTest3(i);
    }

    public void throwTest3(int i) {
        throwTest4(i);
    }

    public void throwTest4(int j) {
        for(int i=0; i<j; ++i){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }
        throw new RuntimeException();
    }

    public void lagTest1(int lll) {
        lagTest2(lll);
    }
    public void lagTest2(int lll) {
        lagTest3(lll);
        lagTest3(lll);
    }
    public void lagTest3(int lll) {
        lagTest4(lll);
    }

    public void lagTest4(int lll) {
        for(int i=0; i<lll; ++i){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }
}
