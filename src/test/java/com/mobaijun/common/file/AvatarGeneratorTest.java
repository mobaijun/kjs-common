package com.mobaijun.common.file;

import com.mobaijun.common.tool.Console;
import junit.framework.TestCase;

public class AvatarGeneratorTest extends TestCase {

    public void testGenerateImg() {
        Console.print(AvatarGenerator.generateImg("墨白君"));
    }

    public void testGenerateOptimizedAvatar() {
        Console.print(AvatarGenerator.generateOptimizedAvatar("墨白君"));
    }
}