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
package com.mobaijun.common.enums.comm;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: AnnotationClassEnums<br>
 * enum description: 注解枚举
 *
 * @author MoBaiJun 2022/12/5 9:11
 */
@Getter
@RequiredArgsConstructor
public enum AnnotationClassType {

    /**
     * ShortName with @Api Swagger2
     */
    Api("Api", "io.swagger.annotations.Api"),

    /**
     * ApiOperation
     */
    ApiOperation("ApiOperation", "io.swagger.annotations.ApiOperation"),

    /**
     * PostMapping
     */
    PostMapping("PostMapping", "org.springframework.web.bind.annotation.PostMapping"),

    /**
     * PutMapping
     */
    PutMapping("PutMapping", "org.springframework.web.bind.annotation.PutMapping"),

    /**
     * DeleteMapping
     */
    DeleteMapping("DeleteMapping", "org.springframework.web.bind.annotation.DeleteMapping"),

    /**
     * GetMapping
     */
    GetMapping("GetMapping", "org.springframework.web.bind.annotation.GetMapping"),

    /**
     * PatchMapping
     */
    PatchMapping("PatchMapping", "org.springframework.web.bind.annotation.PatchMapping"),

    /**
     * RestController
     */
    RestController("RestController", "org.springframework.web.bind.annotation.RestController"),

    /**
     * Controller
     */
    Controller("Controller", "org.springframework.stereotype.Controller");

    /**
     * ShortName
     */
    private final String shortName;

    /**
     * full package with Annotation
     */
    private final String fullPath;

    /**
     * 处理资源
     *
     * @param resources 资源路径
     * @return 枚举列表
     */
    public static List<String> resolveResources(List<String> resources) {
        if (!resources.isEmpty()) {
            List<String> target = new ArrayList<>(10);
            AnnotationClassType[] annotationClassEnums = AnnotationClassType.values();
            for (String source : resources) {
                AnnotationClassType result = null;
                // 判断是否包含在枚举类中
                for (AnnotationClassType annotationClass : annotationClassEnums) {
                    if (annotationClass.getShortName().equalsIgnoreCase(source)) {
                        // 如果相等
                        result = annotationClass;
                        break;
                    }
                }
                if (result != null) {
                    target.add(result.getFullPath());
                } else {
                    // 不存在，直接添加原来的
                    target.add(source);
                }
            }
            return target;
        }
        return null;
    }
}