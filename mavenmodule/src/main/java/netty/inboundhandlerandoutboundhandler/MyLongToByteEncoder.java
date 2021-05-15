package netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author 窦康泰
 * @date 2021/05/12
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf byteBuf) throws Exception {
        System.out.println("MyLongToByteEncoder -> encode --- 被调用");
        System.out.println("msg = " + msg);
        byteBuf.writeLong(msg);
    }
}
