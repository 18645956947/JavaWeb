package com.mmall.common;


//测试泛型类
public class Apple {
    public int a;
    public String b;
    public Apple(int a, String b){
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString(){
        return a+" "+b;
    }
    public boolean aa(){
        return true;
    }


}
