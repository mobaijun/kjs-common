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
package com.mobaijun.common.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: BucketSort<br>
 * class description: 桶排序
 * <p>
 * 桶排序是一种线性时间复杂度的排序算法，它的原理是将要排序的数据分到多个有序的桶中，每个桶内部再通过其他排序算法进行排序，最后将各个桶中的数据有序地合并起来。
 * </p>
 *
 * @author MoBaiJun 2023/2/20 8:23
 */
public final class BucketSort {

    /**
     * 1.对于要排序的数组，首先确定桶的数量。可以根据数组中的最大值和最小值，以及桶的数量来确定桶的大小，即 bucketNum = (maxVal - minVal) / n + 1，其中 n 表示数组的长度。<br/>
     * 2.初始化桶，将数组中的元素分配到各个桶中。<br/>
     * 3.对每个桶中的元素进行排序，这里使用了 Collections.sort() 方法进行排序。<br/>
     * 4.将各个桶中的元素有序地合并到原始数组中。<br/>
     * 注意事项：
     * <p>
     * 1.如果要排序的数据不是整数类型，那么就需要考虑桶的排序方式了。<br/>
     * 2.如果要排序的数据分布不均匀，那么桶的数量也需要进行调整。<br/>
     * 此外，桶排序还可以进行优化，例如使用计数排序对每个桶内部的数据进行排序。
     * <img src="https://images2017.cnblogs.com/blog/849589/201710/849589-20171015232107090-1920702011.png"/>
     *
     * @param arr 待排序的数组
     */
    public static void bucketSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        // 确定桶的数量
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, arr[i]);
            minVal = Math.min(minVal, arr[i]);
        }
        int bucketNum = (maxVal - minVal) / n + 1;

        // 初始化桶
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }

        // 将元素分配到桶中
        for (int i = 0; i < n; i++) {
            int bucketIndex = (arr[i] - minVal) / bucketNum;
            buckets.get(bucketIndex).add(arr[i]);
        }

        // 对每个桶中的元素进行排序
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 将各个桶中的元素有序合并
        int i = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[i++] = num;
            }
        }
    }
}
