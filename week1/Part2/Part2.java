import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: tragro
 * @className: Part2
 * @description:
 * @author: sqi
 * @date: 2022-01-02 09:41
 * @version: 1.0
 **/
public class Part2 extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?> clazz = new Part2().findClass("Hello");
            Object o = clazz.newInstance();
            Method hello = clazz.getDeclaredMethod("hello");
            hello.invoke(o);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        String filePath = "Hello.xlass";
        byte[] bytes = readClass(filePath);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    public static byte[] readClass(String filePath) {
        byte[] bytes = new byte[0];
        try (InputStream is = new FileInputStream(filePath)) {
            int iAvail = is.available();
            bytes = new byte[iAvail];
            int read = is.read(bytes);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bytes;
    }
}