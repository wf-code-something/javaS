package com.day.day.up.main.design.struct.adpater;

/**
 * @author admin
 */
public class AdapterTest {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method1();
        adapter.method2();

        System.out.println("--------------");
        ObjectAdapter objectAdapter = new ObjectAdapter(new SubAdaptee());
        objectAdapter.method1();
        objectAdapter.method2();
        objectAdapter.method3();
    }
}
