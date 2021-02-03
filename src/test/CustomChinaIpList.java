package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author 窦康泰
 * @date 2021/02/03
 */
public class CustomChinaIpList {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\DKT\\Desktop\\Proxy\\china_ip_list\\china_ip_list.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\DKT\\Desktop\\Proxy\\china_ip_list\\custom_china_ip_list.txt"));
        String line = bufferedReader.readLine();
        while (line != null) {
            bufferedWriter.write(line + ",\n");
            line = bufferedReader.readLine();
        }
        bufferedWriter.close();
    }
}
