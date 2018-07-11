package com.uu.java8.chap3;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecuteAround {

    @Test
    public void main() throws IOException {

        // method we want to refactor to make more flexible
        String result = this.processFileLimited();
        System.out.println(result);

        System.out.println("---");

        String oneLine = this.processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = this.processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);

    }

    public String processFileLimited() throws IOException {
        InputStream is = this.getInputStream("/chap3/data.txt");

        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(is))) {
            return br.readLine();
        }
    }

    public String processFile(BufferedReaderProcessor p) throws IOException {
        InputStream is = this.getInputStream("/chap3/data.txt");
        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(is))) {
            return p.process(br);
        }
    }

    public interface BufferedReaderProcessor {
        public String process(BufferedReader b) throws IOException;

    }


    public InputStream getInputStream(String relativeFilePath) throws IOException {
        InputStream is = this.getClass().getResourceAsStream(relativeFilePath);
        return is;
    }

    @Test
    public void getInputStream1() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("/chap3/data.txt");
        System.out.println(is != null);
    }

}
