package chuanqi.zhang.upload;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 此类用于演示关于流的读写方法
 */
public class StreamUtils {
    /**
     * 功能：将InputStream转换成String
     *
     * @param is
     * @return
     * @throws Exception
     */

    public static String streamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) { //当读取到 null时，就表示结束
            builder.append(line + "\r\n");
        }
        return builder.toString();

    }

}
