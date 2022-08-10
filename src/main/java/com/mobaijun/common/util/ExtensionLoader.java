/*
 * Copyright (C) 2022 www.mobaijun.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
                // Apparently It's bad to use Class.newInstance, so we use
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