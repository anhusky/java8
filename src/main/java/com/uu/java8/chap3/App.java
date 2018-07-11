package com.uu.java8.chap3;

import org.junit.jupiter.api.Test;

/**
 * Hello world!
 *
 */

public class App
{
    @Test
    public  void testInt(  )
    {
        Integer portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        //portNumber = 31337;

        new Thread(r).run();
        //System.out.println( "Hello World!" );
    }

    class A {
        public String name;
    }

    @Test
    public void testClass(){
        A a = new A();
        a.name="你好啊 ";
        Runnable r = () ->  {
            //a.name = "------";
            System.out.println(a.name);
        };
        a.name = "不好啊 ";
        new Thread(r).run();
    }
}
