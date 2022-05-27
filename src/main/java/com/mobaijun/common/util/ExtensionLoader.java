package com.mobaijun.common.util;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: ExtensionLoader
 * class description： 扩展加载器
 *
 * @author MoBaiJun 2022/5/27 11:38
 */
public class ExtensionLoader<C> {

    /**
     * [Example: Loading a Java Class at Runtime](<a href="https://stackabuse.com/example-loading-a-java-class-at-runtime/">...</a>)
     *
     * @param directory   file path
     * @param classpath   class path
     * @param parentClass runtime class
     * @return class
     * @throws ClassNotFoundException Exception
     */
    public C loadClass(String directory, String classpath, Class<C> parentClass) throws ClassNotFoundException {
        File pluginsDir = new File(System.getProperty("user.dir") + directory);
        for (File jar : Objects.requireNonNull(pluginsDir.listFiles())) {
            try {
                ClassLoader loader = URLClassLoader.newInstance(
                        new URL[]{jar.toURL()},
                        getClass().getClassLoader()
                );
                Class<?> clazz = Class.forName(classpath, true, loader);
                Class<? extends C> newClass = clazz.asSubclass(parentClass);
                // Apparently its bad to use Class.newInstance, so we use
                // newClass.getConstructor() instead
                Constructor<? extends C> constructor = newClass.getConstructor();
                return constructor.newInstance();

            } catch (ClassNotFoundException e) {
                // There might be multiple JARs in the directory,
                // so keep looking
            } catch (MalformedURLException | NoSuchMethodException | InvocationTargetException |
                     IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        throw new ClassNotFoundException("Class " + classpath
                + " wasn't found in directory " + System.getProperty("user.dir") + directory);
    }
}
