package org.example.halo.dynamic;
import io.quarkus.arc.Arc;
import io.quarkus.arc.processor.BeanRegistrar;
import org.jboss.jandex.Main;

public class RemoteClassRegistrar implements BeanRegistrar {
    @Override
    public void register(RegistrationContext context) {
        ClassLoader customClassLoader = new LocalClassLoader(Main.class.getClassLoader(), "./classes");
        try {
            Class<?> remoteClass = customClassLoader.loadClass("com.example.RemoteService");
            Arc.container().instance(remoteClass).get(); // Register the class
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
