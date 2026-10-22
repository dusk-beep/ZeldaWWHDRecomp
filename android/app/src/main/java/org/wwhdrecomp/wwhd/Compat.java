package org.wwhdrecomp.wwhd;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;

public final class Compat {
    private Compat() {}

    public static byte[] readAllBytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int n;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

    public static byte[] readAllBytes(File file) throws IOException {
        try (InputStream in = new FileInputStream(file)) {
            return readAllBytes(in);
        }
    }
}
