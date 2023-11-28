package com.itmo.project.lesson24.homework;

import java.io.*;

public class Homework {
    public static void outputDecorator(byte[] bytesWithData) {
        class AppOutputDecorator extends FilterOutputStream {
            private final byte key;
            public AppOutputDecorator(OutputStream out, byte key) {
                super(out);
                this.key = key;
            }

            @Override
            public void write(int b) throws IOException {
                b ^= key;
                super.write(b);
            }
        }


    }
    public static void inputDecorator(byte[] bytesWithData) {
        class AppInputDecorator extends FilterInputStream {
            private final byte key;
            public AppInputDecorator(InputStream in, byte key) {
                super(in);
                this.key = key;
            }
            @Override
            public int read () throws IOException{
                int data = super.read();
                if (data != -1) {
                    data ^= key;
                }
                return data;
            }

        }
    }
}
