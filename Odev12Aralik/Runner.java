package com.bilgeadam.Odev12Aralik;

import java.util.Random;

public class Runner {
    static Random random = new Random();
    public static void main(String[] args) {

        StudentFileProcesses s1 = new StudentFileProcesses();
        s1.dosyadanVeriOku();
        for (String names: s1.studentList) {
            System.out.println(names);
        }
        s1.secileceklerDosyasınaYazdır();
        String temp = "";

        s1.ogrenciSec();
        s1.nameListGuncelle();
    }
}
