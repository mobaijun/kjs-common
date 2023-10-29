/*
 * Copyright (C) 2022 [www.mobaijun.com]
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
package com.mobaijun.common.constant;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: PathConstant<br>
 * class description: 路径常量<br>
 *
 * @author MoBaiJun 2022/12/9 15:40
 */
public final class PathConstant {

    /**
     * 根路径
     */
    public static final String ROOT_PATH = "/";

    /**
     * 文件路径前缀
     */
    public static final String FILE_PATH_PREFIX = "filelist:";

    /**
     * 目标class文件路径后缀
     */
    public static final String TARGET_CLASSES_PATH_SUFFIX = MavenConstant.TARGET_CLASSES_PATH_SUFFIX;

    /**
     * java源文件默认存放路径
     */
    public static final String SRC_MAIN_JAVA_PATH = MavenConstant.SRC_MAIN_JAVA_PATH;

    /**
     * 资源文件存放路径
     */
    public static final String SRC_MAIN_RESOURCES_PATH = MavenConstant.SRC_MAIN_RESOURCES_PATH;
}