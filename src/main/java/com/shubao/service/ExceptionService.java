package com.shubao.service;

import com.shubao.exception.MyException;

import java.io.FileNotFoundException;

public interface ExceptionService {

    void show1();

    void show2();

    void show3() throws FileNotFoundException;

    void show4();

    void show5() throws MyException;
}
