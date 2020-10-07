package learn.huffmancode;

import java.io.*;
import java.util.*;

/**
 * 哈夫曼编码：将字符串数据中每个字符出现的次数作为权值创建哈夫曼树
 *
 * @author 窦康泰
 * @date 2020/10/04
 */
public class HuffmanCode {

    /**
     * Huffman表
     */
    public static Map<Byte, String> huffmanCodes = new HashMap<>();

    /**
     * 用于记录每八位截断的二进制字符串最后一组的长度，
     * 目的在于出现000101时，在进行decode时补全前面的0，防止得到101的结果
     */
    public static Integer lastLen;

    public static void main(String[] args) {
//        String content = "i like like like java do you like a java";
        String content = "i like";
        byte[] contentBytes = content.getBytes();
        byte[] huffmanCodeBytes = huffmanZip(contentBytes);

        byte[] decode = decode(huffmanCodeBytes);
        System.out.println(new String(decode));
    }

//    public static void main(String[] args) {
//        zipFile("C:\\Users\\DKT\\Desktop\\setu.jpg", "F:\\setuFile\\setu.huffman");
//        unZipFile("F:\\setuFile\\setu.huffman", "F:\\setuFile\\decodeSetuFile\\setu.jpg");
//    }

    /**
     * 解压缩文件
     * 通过对象输入流将huffmanZip字节数组、huffmanCodes哈夫曼表、lastLen二进制字符串最后一组长度
     * 三个对象获取到，
     * 借助decode方法获取解压缩后的字节数组decode，
     * 再通过文件输出流将获取到的decode字节数组输出，即得到解压缩文件
     * @param srcFile
     * @param dstFile
     */
    public static void unZipFile(String srcFile, String dstFile) {
        ObjectInputStream objectInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(srcFile));
            byte[] huffmanZip = (byte[]) objectInputStream.readObject();
            huffmanCodes = (Map<Byte, String>) objectInputStream.readObject();
            lastLen = (Integer) objectInputStream.readObject();
            byte[] decode = decode(huffmanZip);
            fileOutputStream = new FileOutputStream(dstFile);
            fileOutputStream.write(decode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩文件
     * 通过文件输入流将文件读入bytes数组中，
     * 再通过huffmanZip方法将bytes压缩，
     * 然后将压缩后的huffmanZip（压缩后的字节数组）、huffmanCodes（哈夫曼表）、lastLen（二进制最后一组长度）
     * 借助objectOutputStream写出到指定文件
     * @param srcFile
     * @param dstFile
     */
    public static void zipFile(String srcFile, String dstFile) {
        FileInputStream fileInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            byte[] huffmanZip = huffmanZip(bytes);
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(dstFile));
            objectOutputStream.writeObject(huffmanZip);
            objectOutputStream.writeObject(huffmanCodes);
            objectOutputStream.writeObject(lastLen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将压缩过的byte[]进行解压缩
     * 首先借助byteToBitString获取最初的二进制字符串，
     * 将huffmanCodes哈夫曼表反转，
     * 通过与reverseMap反转的哈夫曼表对比，获取原始的字节数组，并返回
     * @param huffmanCodeBytes
     * @return
     */
    public static byte[] decode(byte[] huffmanCodeBytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < huffmanCodeBytes.length; i++) {
            if (i == huffmanCodeBytes.length - 1) {
                sb.append(byteToBitString(huffmanCodeBytes[i], false));
            } else {
                sb.append(byteToBitString(huffmanCodeBytes[i], true));
            }
        }
        Map<String, Byte> reverseMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < sb.length(); ) {
            String key = sb.substring(i, i + count);
            Byte b = reverseMap.get(key);
            if (b != null) {
                list.add(b);
                i += count;
                count = 1;
            } else {
                count++;
            }
        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    /**
     * 传入一个byte转化成二进制对应的string，
     * 注意是否需要补位，
     * 需要补位：temp |= 256;256即100000000，按位与进行补位，最后注意截取最后8位；
     * 不需要补位：如果是负数，则需要截取后8位，不是负数，根据lastLen判断是否需要在前面补0，
     * 若需要则补，否则返回结果
     * @param b
     * @param flag
     * @return
     */
    public static String byteToBitString(byte b, boolean flag) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String binaryString = Integer.toBinaryString(temp);
        if (flag) {
            return binaryString.substring(binaryString.length() - 8);
        } else {
            if (b < 0) {
                return binaryString.substring(binaryString.length() - 8);
            } else {
                int num = lastLen - binaryString.length();
                StringBuilder tempSb = new StringBuilder();
                for (int i = 0; i < num; i++) {
                    tempSb.append("0");
                }
                return tempSb.toString() + binaryString;
            }
        }
    }

    /**
     * 传入一个待压缩的byte[]，返回一个压缩过的byte[]
     *
     * @param contentBytes
     * @return
     */
    public static byte[] huffmanZip(byte[] contentBytes) {
        // 统计每个字节出现的次数，封装进list中
        List<Node> nodes = getNodesList(contentBytes);
        // 根据list中count建立huffman树
        Node root = createHuffmanTree(nodes);
        // 根据建立的huffman树，建立huffmanCodes表
        getCode(root);
        // 返回压缩后的byte数组
        return zip(contentBytes);
    }

    /**
     * 压缩传入的contentBytes数据
     * 步骤：借助huffmanCodes（Huffman表）将传入的content生成一个由0,1组成的huffmanCodeString，
     * 在将huffmanCodeString按照每8位转成1个byte存进huffmanCodeBytes数组中，并返回
     *
     * @param contentBytes
     * @return
     */
    public static byte[] zip(byte[] contentBytes) {
        StringBuilder huffmanCodeString = new StringBuilder();
        for (byte contentByte : contentBytes) {
            huffmanCodeString.append(huffmanCodes.get(contentByte));
        }
        int len;
        if (huffmanCodeString.length() % 8 == 0) {
            len = huffmanCodeString.length() / 8;
        } else {
            lastLen = huffmanCodeString.length() % 8;
            len = huffmanCodeString.length() / 8 + 1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < huffmanCodeString.length(); i += 8) {
            String substring;
            if (i + 8 >= huffmanCodeString.length()) {
                substring = huffmanCodeString.substring(i);
            } else {
                substring = huffmanCodeString.substring(i, i + 8);
            }
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(substring, 2);
        }
        return huffmanCodeBytes;
    }

    public static void getCode(Node root) {
        if (root != null) {
            getCode(root.left, "0", new StringBuilder());
            getCode(root.right, "1", new StringBuilder());
        }
    }

    /**
     * 生成Huffman表
     *
     * @param node
     * @param type
     * @param sb
     */
    public static void getCode(Node node, String type, StringBuilder sb) {
        if (node == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(type);
        if (node.value == null) {
            getCode(node.left, "0", stringBuilder);
            getCode(node.right, "1", stringBuilder);
        } else {
            huffmanCodes.put(node.value, stringBuilder.toString());
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 创建Huffman树
     *
     * @param nodes
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node newNode = new Node(left.count + right.count);
            nodes.remove(left);
            nodes.remove(right);
            newNode.left = left;
            newNode.right = right;
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    /**
     * 借助HashMap统计contentBytes中数据出现的次数，并将其封装进list中
     *
     * @param contentBytes
     * @return
     */
    public static List<Node> getNodesList(byte[] contentBytes) {
        Map<Byte, Integer> map = new HashMap<>();
        for (byte key : contentBytes) {
            Integer value = map.get(key);
            if (value != null) {
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        List<Node> list = new ArrayList<>();
        Set<Map.Entry<Byte, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Byte, Integer> entry : entrySet) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        return list;
    }

}

class Node implements Comparable<Node> {
    public Byte value;
    public Integer count;
    public Node left;
    public Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", count=" + count +
                '}';
    }

    public Node(Integer count) {
        this.count = count;
    }

    public Node(Byte value, Integer count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        return this.count - o.count;
    }
}
