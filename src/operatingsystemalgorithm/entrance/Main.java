package operatingsystemalgorithm.entrance;

import operatingsystemalgorithm.themefour.clock.Clock;
import operatingsystemalgorithm.themefour.lru.LeastRecentlyUsed;
import operatingsystemalgorithm.themefour.opt.OptimalReplacementAlgorithm;
import operatingsystemalgorithm.themeone.processsynchronizationmodel.ProcessSynchronizationModel;
import operatingsystemalgorithm.themethree.bankeralgorithm.BankerAlgorithm;
import operatingsystemalgorithm.themetwo.roundrobin.RoundRobinAlgorithm;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 窦康泰
 * @date 2020/10/25
 */
public class Main {

    public static String filePath = "readme.txt";
    public static String s1 = "严禁用于考试，否则后果自负";
    public static String s2 = "请不要修改任何文件内容，不信你可以试一试";
    public static String s3 = "仅支持输入英文字符，中文字符不支持";

    public static void main(String[] args) {
        start();
    }

    public static void getAnswer() {
        while (true) {
            System.out.println("1.专题一进程同步模型");
            System.out.println("2.专题二时间片轮转调度算法");
            System.out.println("3.专题三银行家算法");
            System.out.println("41.专题四Optimal页面置换算法");
            System.out.println("42.专题四LRU页面置换算法");
            System.out.println("43.专题四Clock页面置换算法");
            System.out.print("输入序号选择要使用的算法:");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    ProcessSynchronizationModel.start();
                    System.out.println();
                    break;
                case 2:
                    RoundRobinAlgorithm.start();
                    System.out.println();
                    break;
                case 3:
                    BankerAlgorithm.start();
                    System.out.println();
                    break;
                case 41:
                    OptimalReplacementAlgorithm.start();
                    System.out.println();
                    break;
                case 42:
                    LeastRecentlyUsed.start();
                    System.out.println();
                    break;
                case 43:
                    Clock.start();
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
    }

    public static void start() {
        List<String> msg = getMsgFromFile();
        boolean isModifyHead = isModifyHead(msg);
        if (isModifyHead) {
            System.out.println("乖！不要乱改。");
            return;
        } else {
            if (msg.size() > 3) {
                // 验证
                boolean keyIsExpire = judgeKeyIsExpire(msg.get(3));
                boolean isValidityPcId = getEncodePcId().equals(msg.get(4));
                if (keyIsExpire) {
                    System.out.println("key过期了");
                    return;
                }
                if (!isValidityPcId) {
                    System.out.println("禁止复制传播的");
                    return;
                }
            } else {
                // 激活
                System.out.print("请输入激活码：");
                Scanner scanner = new Scanner(System.in);
                String key = scanner.nextLine();
                boolean keyIsValidity = judgeKeyIsValidity(key);
                if (keyIsValidity) {
                    System.out.println("激活码无效。。。");
                    return;
                } else {
                    boolean keyIsExpire = judgeKeyIsExpire(key);
                    if (keyIsExpire) {
                        System.out.println("激活码过期");
                        return;
                    } else {
                        writeToFile(key);
                        writeToFile(getEncodePcId());
                        System.out.println("激活码到期时间：" + getFormatExpireTime(key));
                    }
                }
            }
        }
        getAnswer();
    }

    public static String getFormatExpireTime(String key) {
        String expireTimeStr = decodeStr(key).split(" ")[1];
        long expireTime = Long.parseLong(expireTimeStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(expireTime);
        return sdf.format(date);
    }

    public static String getEncodePcId() {
        String cpuSerial = getCPUSerial();
        String boardSN = getMotherboardSN();
        String hardDiskSN = getHardDiskSN("C");
        String oriStr = cpuSerial + " " + boardSN + " " + hardDiskSN;
        return encodeStr(oriStr);
    }

    public static boolean isModifyHead(List<String> msg) {
        if (!s1.equals(msg.get(0)) || !s2.equals(msg.get(1)) || !s3.equals(msg.get(2))) {
            return true;
        }
        return false;
    }

    public static List<String> getMsgFromFile() {
        List<String> msg = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                msg.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return msg;
    }

    public static void writeToFile(String key) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File(filePath), true));
            bufferedWriter.write("\r\n" + key);
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

    public static boolean judgeKeyIsExpire(String key) {
        String oriStr = decodeStr(key);
        String expireTime = oriStr.split(" ")[1];
        long et = Long.parseLong(expireTime);
        long ctm = System.currentTimeMillis();
        return ctm > et;
    }

    public static boolean judgeKeyIsValidity(String key) {
        String oriStr = decodeStr(key);
        String validityTime = oriStr.split(" ")[0];
        long vt = Long.parseLong(validityTime);
        long ctm = System.currentTimeMillis();
        return ctm > vt;
    }

    public static String getKey(int keyValidityOfSec, int osaExpireOfDay) {
        long ctm = System.currentTimeMillis();
        String keyValidityStr = ctm + keyValidityOfSec * 1000 + "";
        String osaExpireStr = ctm + osaExpireOfDay * 24 * 60 * 60 * 1000 + "";
        String oriKey = keyValidityStr + " " + osaExpireStr;
        String encodeStr = encodeStr(oriKey);
        return encodeStr;
    }

    public static String encodeStr(String s) {
        return new String(Base64.getEncoder().encode(encodeAndDecodeByteArr(s.getBytes())));
    }

    public static String decodeStr(String s) {
        return new String(encodeAndDecodeByteArr(Base64.getDecoder().decode(s.getBytes())));
    }

    public static byte[] encodeAndDecodeByteArr(byte[] bytes) {
        byte[] bs = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            bs[i] = bytes[i];
            byte salt = (byte) (i * i + 35);
            if (i % 2 == 0) {
                bs[i] -= salt;
                bs[i] ^= salt;
                bs[i] += salt;
            } else {
                bs[i] += salt;
                bs[i] ^= salt;
                bs[i] -= salt;
            }
        }
        return bs;
    }

    public static String getCPUSerial() {
        String result = "";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(
                    new String[]{"wmic", "cpu", "get", "ProcessorId"});
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String property = sc.next();
            result = sc.next();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.trim();
    }

    public static String getMotherboardSN() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_BaseBoard\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.trim();
    }

    public static String getHardDiskSN(String drive) {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    + "Set colDrives = objFSO.Drives\n"
                    + "Set objDrive = colDrives.item(\""
                    + drive
                    + "\")\n"
                    + "Wscript.Echo objDrive.SerialNumber"; // see note
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.trim();
    }
}
