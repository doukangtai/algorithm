package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/14
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("0000"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return res;
        }
        help(res, s, new StringBuilder(), 0);
        return res;
    }

    private void help(List<String> res, String s, StringBuilder sb, int count) {
        if (count == 4 || s.length() == 0) {
            if (count == 4 && s.length() == 0) {
                res.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i <= 2 && i < s.length(); i++) {
            if (i != 0 && s.charAt(0) == '0') {
                return;
            }
            String tempStr = s.substring(0, i + 1);
            int num = Integer.parseInt(tempStr);
            if (num < 0 || num > 255) {
                return;
            } else {
                String ts = num + "";
                if (count != 0) {
                    ts = "." + ts;
                }
                sb.append(ts);
                help(res, s.substring(i + 1), sb, count + 1);
                sb.delete(sb.length() - ts.length(), sb.length());
            }
        }
    }
}
