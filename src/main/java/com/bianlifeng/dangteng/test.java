package com.bianlifeng.dangteng;

/**
 * @author: dangteng
 * @date: 2018/5/11 21:55
 * @description:
 */
public class test {
    public static void main(String[] args) {
        String test = ",家看了仨都好激动时刻但是客户交罚款多少积分健康的健身房倒萨卡积分开始的放倒萨卡积分卡的就是看到副教授独立空间";
        isChinese1(test);
    }

    // 根据Unicode编码完美的判断中文汉字和符号
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            System.out.println(1);
            return true;
        }
        return false;
    }

    // 完整的判断中文汉字和符号
    public static boolean isChinese1(String strName) {
        char[] ch = strName.toCharArray();
        System.out.println(ch.length);
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
            char c = ch[i];
            if (isChinese(c)) {
                System.out.println(2);

            }
        }
        return false;
    }
}
