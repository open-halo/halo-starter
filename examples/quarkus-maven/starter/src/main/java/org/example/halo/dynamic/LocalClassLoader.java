package org.example.halo.dynamic;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

public class LocalClassLoader extends ClassLoader {
    private final String baseLocalClassFilePath;

    public LocalClassLoader(ClassLoader parent, String baseLocalClassFilePath) {
        super(parent);
        this.baseLocalClassFilePath = baseLocalClassFilePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = name.replace('.', '/') + ".class";
        String classContent = FileUtil.readUtf8String(baseLocalClassFilePath + path);
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
