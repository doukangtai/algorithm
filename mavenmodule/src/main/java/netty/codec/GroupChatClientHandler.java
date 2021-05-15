package netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author 窦康泰
 * @date 2021/05/09
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler<StudentPOJO.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentPOJO.Student student) throws Exception {
        System.out.println(student);
    }
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
//        System.out.println(s.trim());
//    }
}
