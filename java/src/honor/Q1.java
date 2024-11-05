package src.honor;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>(); // 存储所有的字符
        Set<String> set = new LinkedHashSet<>();  // 存储去重之后的合法字符串
        List<String> res = new ArrayList<>();  // 存储不合法的字符串，可能存在重复的
        while(sc.hasNext()){
            String str = sc.next();
            list.add(str);
        }
        for (String str : list) {
            // 判断是否合法
            boolean orNot = isOrNot(str);
            if (orNot) set.add(str);
            else res.add(str);
        }
        // 第一行输出合法的字符
        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
        // 第二行输出所有的非法字符
        StringBuilder stringBuilder = new StringBuilder();
        for (String re : res) {
            stringBuilder.append(re);
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }
    public static boolean isOrNot(String str){
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
