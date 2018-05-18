package com.bianlifeng.dangteng;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Arrays;
import java.util.Set;

/**
 * @author: dangteng
 * @date: 2018/5/18 16:59
 * @description: 利用guava新增集合类型记录字符串在数组中出现的次数
 */
public class Ex_2 {
    public static void main(String[] args) {
        String [] strings = {"wer","dffd","ddsa","dfd","dreg","de","dr","ce","ghrt","cf","gt","ser","tg","ghrt","cf","gt"};
        Multiset<String>  multiset = HashMultiset.create();
        multiset.addAll(Arrays.asList(strings));
        Set<String> wordSet = multiset.elementSet();
        for (String s : wordSet) {
            System.out.println(s+"\t"+"count:"+"\t"+multiset.count(s));
        }
    }
}
