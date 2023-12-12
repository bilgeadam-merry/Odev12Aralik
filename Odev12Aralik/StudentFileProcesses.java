package com.bilgeadam.Odev12Aralik;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class StudentFileProcesses {
    File file = new File("/Users/meryem/Desktop/NameList.txt");
    static File file2 = new File("/Users/meryem/Desktop/Secilecekler.txt");
    static File file3 = new File("/Users/meryem/Desktop/NameList2.txt");

    List<String> studentList = new ArrayList<>();
    Random random = new Random();

    public void dosyadanVeriOku() {
        try {
            FileReader fileReader = new FileReader(file);
            String line;
            BufferedReader br = new BufferedReader(fileReader);
            while (true) {
                try {
                    if ((line = br.readLine()) == null) {
                        break;
                    }
                    studentList.add(line);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void secileceklerDosyasınaYazdır() {

        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file2, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < studentList.size(); i++) {
                bWriter.write(studentList.get(i));
                bWriter.newLine();
            }
            bWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ogrenciSec() {
        int index = random.nextInt(0, studentList.size());
        //System.out.println("Size: " + studentList.size());
        String secilenOgrenci = studentList.get(index);
        File file = new File("/Users/meryem/Desktop/Secilmisler.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(studentList.get(index));
            studentList.remove(index);
            bWriter.newLine();
            System.out.println("****");
            studentList.forEach(System.out::println);
/*
            File file2 = new File("/Users/ameryem/Desktop/Secilecekler.txt");
            fileWriter = new FileWriter(file2, true);
            BufferedWriter bWriter2 = new BufferedWriter(fileWriter);
*/
/*
            File file3 = new File("/Users/meryem/Desktop/NameList.txt");
            fileWriter = new FileWriter(file3, true);
            BufferedWriter bWriter3 = new BufferedWriter(fileWriter);

*/
            bWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void nameListGuncelle() {
        //file.delete();
        try {
            file3.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
/*
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
*/

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file3, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < studentList.size(); i++) {
                bWriter.write(studentList.get(i));
                bWriter.newLine();
            }
/*
            File file2 = new File("/Users/meryem/Desktop/Secilecekler.txt");
            fileWriter = new FileWriter(file2, true);
            BufferedWriter bWriter2 = new BufferedWriter(fileWriter);
*/
            bWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
