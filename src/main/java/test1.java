import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class test1 {

    public static void main(String[] args) throws IOException {
        String name = "C:\\Users\\leowang\\git\\blf\\bianlifeng_exercise\\src\\main\\java\\test.docx"; //目标文件
        String name2 = "C:\\Users\\leowang\\git\\blf\\bianlifeng_exercise\\src\\main\\java\\test.txt"; //输出文件
        int num = 0;      //数字数    
        int letter = 0;    //字母数
        int word= 0;  //汉字数
        int symbol = 0; //符号
        try{
            File file=new File(name);

            FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            String doc1 = extractor.getText();
            System.out.println(doc1);
            fis.close();

            num += countNumber(doc1);
            letter += countLetter(doc1);
            word += countChinese(doc1);
            symbol += countSymbol(doc1);

            PrintWriter out1=new PrintWriter(new BufferedWriter(new FileWriter(name2)));
            int arr[] = {num,letter,word,symbol};
            Map map = new HashMap();
            map.put(num,"数字数：");
            map.put(letter,"字母数：");
            map.put(word,"汉字数：");
            map.put(symbol,"字符数：");
            Arrays.sort(arr);
            for(int i = 3;i>=0;i--){
                out1.println(map.get(arr[i])+" "+arr[i]);
            }

            out1.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 统计数字数 
     * @param str
     * @return
     */
    public static int countNumber(String str) {
        int count = 0;
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }

    /**
     * 统计字母数 
     * @param str
     * @return
     */
    public static int countLetter(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }

    /**
     * 统计汉字数 
     * @param str
     * @return
     */
    public static int countChinese(String str) {
        int count = 0;
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }

    /**
     * 统计字符数
     * @param str
     * @return
     */
    public static int countSymbol(String str) {
        int count = 0;
        Pattern p = Pattern.compile("\\pP");
        Matcher m = p.matcher(str);
        while(m.find()){
            count++;
        }
        return count;
    }


}  