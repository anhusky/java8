package com.uu.java8.chap5;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 描述：
 *
 * @author liupenghao
 * @create 2018-07-23 下午7:05
 **/
public class Test5 {

    @Test
    public void testLines() throws IOException {
        URL url = this.getClass().getResource("/chap5/data.txt");
        Stream<String> lines = Files.lines(Paths.get(url.getFile()), Charset.defaultCharset());
        long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        System.out.println(uniqueWords);
    }
}
