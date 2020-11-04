package operatingsystemalgorithm.entrance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2020/10/28
 */
public class Key {
    public static void main(String[] args) {
        generateKey();
    }

    public static void generateKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入key的有效时间（秒）：");
        int va = scanner.nextInt();
        System.out.print("请输入key的过期时间（天）：");
        double ex = scanner.nextDouble();
        String key = Main.getKey(va, ex);
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File("key.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(key);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
