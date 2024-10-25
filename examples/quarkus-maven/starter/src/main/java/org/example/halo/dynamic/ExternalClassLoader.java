package org.example.halo.dynamic;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExternalClassLoader extends ClassLoader {
    private final String remoteBaseUrl;

    public ExternalClassLoader(ClassLoader parent, String remoteBaseUrl) {
        super(parent);
        this.remoteBaseUrl = remoteBaseUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = name.replace('.', '/') + ".class";
        try {
            URL url = new URL(remoteBaseUrl + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            byte[] classData = is.readAllBytes();
            is.close();
            return defineClass(name, classData, 0, classData.length);
        } catch (Exception e) {
            throw new ClassNotFoundException("Failed to load class " + name, e);
        }
    }
}
