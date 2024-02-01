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
package com.mobaijun.common.number;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * enum name: SizeUnit<br>
 * enum description: <br>
 * Representation of basic size units，just like TimeUnit.<br>
 * Usage example:<br>
 * assertTrue(SizeUnit.BYTES.toMegaBytes(1024 * 1024) == 1.0);<br/>
 * assertTrue(SizeUnit.GIGABYTES.toBytes(1) == 1024.0 * 1024.0 * 1024.0);<br>
 *
 * @author MoBaiJun 2022/12/9 8:48
 */
public enum SizeUnit {

    /**
     * Smallest memory unit.
     */
    BYTES,

    /**
     * "One thousand" (1024) bytes.
     */
    KILOBYTES,

    /**
     * "One million" (1024x1024) bytes.
     */
    MEGABYTES,

    /**
     * "One billion" (1024x1024x1024) bytes.
     */
    GIGABYTES;

    /**
     * Number of bytes in a kilobyte.
     */
    private final double BYTES_PER_KILOBYTE = 1024.0;

    /**
     * Number of kilobytes in a megabyte.
     */
    private final double KILOBYTES_PER_MEGABYTE = 1024.0;

    /**
     * Number of megabytes per gigabyte.
     */
    private final double MEGABYTES_PER_GIGABYTE = 1024.0;

    /**
     * Returns the number of bytes corresponding to the provided input for a particular unit of memory.
     *
     * @param input Number of units of memory.
     * @return Number of bytes corresponding to the provided number of particular memory units.
     */
    public double toBytes(final long input) {
        return switch (this) {
            case BYTES -> input;
            case KILOBYTES -> input * BYTES_PER_KILOBYTE;
            case MEGABYTES -> input * BYTES_PER_KILOBYTE * KILOBYTES_PER_MEGABYTE;
            case GIGABYTES -> input * BYTES_PER_KILOBYTE * KILOBYTES_PER_MEGABYTE * MEGABYTES_PER_GIGABYTE;
        };
    }

    /**
     * Returns the number of kilobytes corresponding to the provided input for a particular unit of memory.
     *
     * @param input Number of units of memory.
     * @return Number of kilobytes corresponding to the provided number of particular memory units.
     */
    public double toKiloBytes(final long input) {
        return switch (this) {
            case BYTES -> input / BYTES_PER_KILOBYTE;
            case KILOBYTES -> input;
            case MEGABYTES -> input * KILOBYTES_PER_MEGABYTE;
            case GIGABYTES -> input * KILOBYTES_PER_MEGABYTE * MEGABYTES_PER_GIGABYTE;
        };
    }

    /**
     * Returns the number of megabytes corresponding to the provided input for a particular unit of memory.
     *
     * @param input Number of units of memory.
     * @return Number of megabytes corresponding to the provided number of particular memory units.
     */
    public double toMegaBytes(final long input) {
        return switch (this) {
            case BYTES -> input / BYTES_PER_KILOBYTE / KILOBYTES_PER_MEGABYTE;
            case KILOBYTES -> input / KILOBYTES_PER_MEGABYTE;
            case MEGABYTES -> input;
            case GIGABYTES -> input * MEGABYTES_PER_GIGABYTE;
        };
    }

    /**
     * Returns the number of gigabytes corresponding to the provided input for a particular unit of memory.
     *
     * @param input Number of units of memory.
     * @return Number of gigabytes corresponding to the provided number of particular memory units.
     */
    public double toGigaBytes(final long input) {
        return switch (this) {
            case BYTES -> input / BYTES_PER_KILOBYTE / KILOBYTES_PER_MEGABYTE / MEGABYTES_PER_GIGABYTE;
            case KILOBYTES -> input / KILOBYTES_PER_MEGABYTE / MEGABYTES_PER_GIGABYTE;
            case MEGABYTES -> input / MEGABYTES_PER_GIGABYTE;
            case GIGABYTES -> input;
        };
    }
}