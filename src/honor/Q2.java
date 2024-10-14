package src.honor;

    import java.util.*;

/**
 * 1 one 2 two 3 three 4 four 5 five 6 six 7 seven 8 eight 9 nine
 * 134699
 * nenohuironnineteefersix
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "eight");
        map.put(8, "eight");
        map.put(9, "nine");

        while (sc.hasNext()) {
            String str = sc.next().toLowerCase();
            // 拼接结果
            List<Integer> res  = new ArrayList<>();
            // 将字符串转换为集合
            List<Character> list = new ArrayList<>();
            for (char c : str.toCharArray()) {
                list.add(c);
            }
            // 当 list 不为空的时候
            while (!list.isEmpty()) {
                for (int i = 0; i < 10; i++) {
                    String number = map.get(i);
                    boolean orNotContain = isOrNotContain(number, list);
                    if (!orNotContain) continue;
                    else {
                        // 如果集合中存在这个英文数字
                        // 依次将该英文数字的第一个出现的字符删除
                        for (char c : number.toCharArray()) {
                            int indexOf = list.indexOf(c);
                            list.remove(indexOf);
                        }
                    }
                    // 拼接该数字
                    res.add(i);
                }
            }
            // 排序
            Collections.sort(res);
            StringBuilder sb = new StringBuilder();
            for (Integer re : res) {
                sb.append(re);
            }
            System.out.println(sb);
        }
    }

    public static boolean isOrNotContain(String number, List<Character> list) {
        for (char c : number.toCharArray()) {
            if (list.contains(c)) continue;
            else return false;
        }
        return true;
    }
}
