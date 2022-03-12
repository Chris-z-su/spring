package com.shubao.service.impl;

import com.shubao.exception.MyException;
import com.shubao.service.ExceptionService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Service("exceptionService")
public class ExceptionServiceImpl implements ExceptionService {

    @Override
    public void show1() {
        System.out.println("抛出类型转换异常....");
        Object str = "zhangsan";
        Integer num = (Integer)str;
    }

    @Override
    public void show2() {
        System.out.println("抛出除零异常....");
        int i = 1/0;
    }

    @Override
    public void show3() throws FileNotFoundException {
        System.out.println("文件找不到异常....");
        InputStream in = new FileInputStream("C:/xxx/xxx/xxx.txt");
    }

    @Override
    public void show4() {
        System.out.println("空指针异常.....");
        String str = null;
        str.length();
    }

    @Override
    public void show5() throws MyException {
        System.out.println("自定义异常....");
        throw new MyException();
    }
}
