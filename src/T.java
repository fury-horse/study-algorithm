import java.util.concurrent.CountDownLatch;

/**
* @desc    测试类
* @version 1.0
* @author  Liang Jun
* @date    2020年05月26日 09:30:00
**/
public class T {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);

        latch.await();
        latch.countDown();

        new ThreadLocal<String>().set("");
    }
}