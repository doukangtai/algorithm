package netty.codec2;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 窦康泰
 * @date 2021/05/09
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            ch.writeAndFlush("[客户端]" +channel.remoteAddress()+ " 加入聊天" + sdf.format(new Date()) + "\n");
        });
        channel.writeAndFlush("[自己] " + channel.remoteAddress() + " 加入聊天" + sdf.format(new Date()) + "\n");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            ch.writeAndFlush("[客户端] " + channel.remoteAddress() + " 离开聊天\n");
        });
        System.out.println("channelGroup size : " + channelGroup.size());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 上线了~");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "离线了~");
    }

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
//        Channel channel = ctx.channel();
//        channelGroup.forEach(ch -> {
//            if (channel != ch) {
//                ch.writeAndFlush("[客户]" +channel.remoteAddress()+ "发送了消息：" + s + "\n");
//            } else {
//                ch.writeAndFlush("[自己]发送了消息：" + s + "\n");
//            }
//        });
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage myMessage) throws Exception {
        MyDataInfo.MyMessage.DataType dataType = myMessage.getDataType();
        if (dataType == MyDataInfo.MyMessage.DataType.StudentType) {
            System.out.println("消息：student.id = " + myMessage.getStudent().getId() + " student.name = " + myMessage.getStudent().getName());
        } else if (dataType == MyDataInfo.MyMessage.DataType.WorkerType) {
            System.out.println("消息：worker.age = " + myMessage.getWorker().getAge() + " worker.name = " + myMessage.getWorker().getName());
        } else {
            System.out.println("未知类型~~~");
        }
    }
}
