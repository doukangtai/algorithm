package netty.protocoltcp;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/05/15
 */
public class MessageProtocol {
    private int len;
    private byte[] data;

    public MessageProtocol() {
    }

    public MessageProtocol(int len, byte[] data) {
        this.len = len;
        this.data = data;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MessageProtocol{" +
                "len=" + len +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
