/* (C) 2023 */
package com.bot;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Base64;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class BotApplication {

    public static void main(String[] args) throws UnsupportedEncodingException {
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") != -1)
            SpringApplication.run(BotApplication.class, args);
        else {

            SpringApplication application = new SpringApplication(BotApplication.class);
            application.addListeners(
                    new ApplicationPidFileWriter(Paths.get("").toAbsolutePath() + "/app.pid"));
            application.run();
        }
    }

    @Test
    public void test()
            throws InvocationTargetException, IllegalAccessException, UnsupportedEncodingException {
        //        byte[] bytes = "983045100026370000000000000000DU07BKG610100S01  98300000000000  M
        // 005000000000001000000210000000000000000000  000                00000983  00000
        // 12345678901234  00000000                                        000000000001
        // ".getBytes(StandardCharsets.UTF_8);
        //        Text2VoFormatter t = new Text2VoFormatter();
        //        textBuf = new TextBuf();
        //        fieldSort = new FieldSort();
        //        this.format(bytes, new G6100_I());
        System.out.println(
                Base64.getEncoder()
                        .encodeToString(
                                //
                                // "983045100026370000000000000000DU07BKG610100S01  98300000000000
                                // M 005000000000001000000210000000000000000000  000
                                // 00000983  00000      123456789012340000000000
                                //                    000000000001                          "
                                "983045100026888000000000000000DU07BKG62  00S    983000000000      010000000000000000000060000000000000000000BH000                00000983  0000011180100000000000000000033506509  00000000101000000000000000000010000000000000000000000000000000000000000000000                                                  00              000000001200001000000000000000000                                                             "
                                        .getBytes(StandardCharsets.UTF_8)));
    }
}
