package netty.codec2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 窦康泰
 * @date 2021/05/09
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage myMessage) throws Exception {
        System.out.println(myMessage);
    }
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
//        System.out.println(s.trim());
//    }
}
