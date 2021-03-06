package imooc.design.pattern.creational.factorymethod;

/**
 * @author 窦康泰
 * @date 2021/07/10
 */
public abstract class VideoFactory {
    public abstract Video getVideo();

//    public Video getVideo(Class clazz) {
//        Video video = null;
//        try {
//            video = (Video) clazz.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return video;
//    }
//
//    public Video getVideo(String type) {
//        if ("java".equalsIgnoreCase(type)) {
//            return new JavaVideo();
//        } else if ("python".equalsIgnoreCase(type)) {
//            return new PythonVideo();
//        }
//        return null;
//    }
}
