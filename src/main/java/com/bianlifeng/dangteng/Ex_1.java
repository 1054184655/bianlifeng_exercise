package com.bianlifeng.dangteng;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.*;
import java.util.*;

/**
 * @author: dangteng
 * @date: 2018/5/11
 * @description:
 */
public class Ex_1 {
    private int hzCount = 0;// 汉字数量
    private int szCount = 0;// 数字数量
    private int zmCount = 0;// 字母数量
    private int fhCount = 0;// 标点符号数量

    public static void main(String[] args) {
        Ex_1 ex_1 = new Ex_1();
        File inputFile = new File(Ex_1.class.getResource("/test.txt").getFile());
        File outputFile = new File("result.txt");
        try (PrintStream printStream = new PrintStream(new FileOutputStream(outputFile))) {
            List<String> list = Files.readLines(inputFile, Charsets.UTF_8);
            Map<Integer, String> map = new HashMap<>();
            list.forEach(data -> {
                char[] chars = data.toCharArray();
                for (char aChar : chars) {
                    ex_1.isHz(aChar);
                    ex_1.isSz(aChar);
                    ex_1.isZm(aChar);
                    ex_1.isFh(aChar);
                }
            });
            map.put(ex_1.hzCount, "汉字个数");
            map.put(ex_1.szCount, "数字个数");
            map.put(ex_1.zmCount, "字母个数");
            map.put(ex_1.fhCount, "符号个数");
            for (Map.Entry<Integer, String> entry : ex_1.sortMapByKey(map).entrySet()) {
                printStream.write(String.format("%s : %s\n", entry.getValue(), entry.getKey()).getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Map<Integer, String> sortMapByKey(Map<Integer, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer, String> sortMap = new TreeMap<>(Comparator.reverseOrder());
        sortMap.putAll(map);
        return sortMap;
    }

    private void isHz(char c) {
        if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+"))
            hzCount++;
    }

    private void isSz(char c) {
        if (Character.isDigit(c))
            szCount++;
    }

    private void isZm(char c) {
        if (Character.isLetter(c))
            zmCount++;
    }

    private void isFh(char c) {
        if (Character.toString(c).matches("[\\p{P}]"))
            fhCount++;
    }
}
