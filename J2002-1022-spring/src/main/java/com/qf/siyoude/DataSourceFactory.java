package com.qf.siyoude;

public class DataSourceFactory {
    public static DataSource createStaticDataSource() {
        System.out.println("DataSourceFactory静态工厂生产");
        return new MyDataSource();
    }

    public DataSource createDataSource() {
        System.out.println("DataSourceFactory成员方法生产");
        return new MyDataSource();
    }
}

    class MyDataSource implements DataSource {
    @Override
    public void method() {
        System.out.println("MyDataSource method方法被调用了");
    }

}
