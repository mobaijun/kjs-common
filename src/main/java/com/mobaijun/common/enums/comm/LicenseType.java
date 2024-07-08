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

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Description: [开源许可证]
 * Author: [mobaijun]
 * Date: [2024/2/1 8:53]
 * IntelliJ IDEA Version: [IntelliJ IDEA 2023.1.4]
 */
@Getter
@AllArgsConstructor
public enum LicenseType {

    /**
     * Apache 2.0
     */
    APACHE_2("https://www.apache.org/licenses/LICENSE-2.0", "/*\n" +
            " * Copyright (C) 2022 [%s]\n" +
            " *\n" +
            " * Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
            " * you may not use this file except in compliance with the License.\n" +
            " * You may obtain a copy of the License at\n" +
            " *\n" +
            " *         https://www.apache.org/licenses/LICENSE-2.0\n" +
            " *\n" +
            " * Unless required by applicable law or agreed to in writing, software\n" +
            " * distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
            " * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
            " * See the License for the specific language governing permissions and\n" +
            " * limitations under the License.\n" +
            " */"),

    /**
     * MIT
     */
    MIT("https://opensource.org/license/mit/", "/*\n" +
            " * Copyright (C) 2022 [%s]\n" +
            " *\n" +
            " * Permission is hereby granted, free of charge, to any person obtaining a copy\n" +
            " * of this software and associated documentation files (the \"Software\"), to deal\n" +
            " * in the Software without restriction, including without limitation the rights\n" +
            " * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n" +
            " * copies of the Software, and to permit persons to whom the Software is\n" +
            " * furnished to do so, subject to the following conditions:\n" +
            " *\n" +
            " * The above copyright notice and this permission notice shall be included in\n" +
            " * all copies or substantial portions of the Software.\n" +
            " *\n" +
            " * THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n" +
            " * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n" +
            " * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n" +
            " * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n" +
            " * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n" +
            " * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN\n" +
            " * THE SOFTWARE.\n" +
            " */"),

    /**
     * BSD 3-Clause
     * String.format(BSD_3_CLAUSE, "2023 www.mobaijun.com", "BSD 3-Clause 2.0");
     */
    BSD_3_CLAUSE("https://opensource.org/license/bsd-3-clause/", "/*\n" +
            " * Copyright (C) [%s]\n" +
            " *\n" +
            " * Licensed under the %s License, Version %s (the \"License\");\n" +
            " * you may not use this file except in compliance with the License.\n" +
            " * You may obtain a copy of the License at\n" +
            " *\n" +
            " *         https://opensource.org/licenses/BSD-3-Clause\n" +
            " *\n" +
            " * Unless required by applicable law or agreed to in writing, software\n" +
            " * distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
            " * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
            " * See the License for the specific language governing permissions and\n" +
            " * limitations under the License.\n" +
            " */");


    /**
     * 协议链接
     */
    private final String url;

    /**
     * 协议内容
     */
    private final String value;
}
