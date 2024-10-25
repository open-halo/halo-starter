package org.example.halo.external.dynamic;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LocalClassLoader extends ClassLoader {
    private final String remoteBaseUrl;

    public LocalClassLoader(ClassLoader parent, String remoteBaseUrl) {
        super(parent);
        this.remoteBaseUrl = remoteBaseUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = name.replace('.', '/') + ".class";
        String classContent = FileUtil.readUtf8String(path);
        if (StrUtil.isBlank(classContent)) {
            throw new ClassNotFoundException("Failed to load class file from local path: " + path);
        }
        try {
            byte[] classData = classContent.getBytes();
            return defineClass(name, classData, 0, classData.length);
        } catch (Exception e) {
            throw new ClassNotFoundException("Failed to load class " + name, e);
        }
    }
}
