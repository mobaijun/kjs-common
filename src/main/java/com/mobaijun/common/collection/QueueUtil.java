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
package com.mobaijun.common.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * software：IntelliJ IDEA 2022.2.3<br>
 * class name: QueueUtil<br>
 * class description: Queue工具集.<br>
 * 各种Queue，Dequeue的创建<br>
 *
 * @author MoBaiJun 2022/12/8 17:57
 */
public class QueueUtil {

    /**
     * 创建ArrayDeque (JDK无ArrayQueue)
     * <p>
     * 需设置初始长度，默认为16，数组满时成倍扩容
     */
    public static <E> ArrayDeque<E> newArrayDeque(int initSize) {
        return new ArrayDeque<>(initSize);
    }

    /**
     * 创建LinkedDeque (LinkedList实现了Deque接口)
     */
    public static <E> LinkedList<E> newLinkedDeque() {
        return new LinkedList<>();
    }

    /**
     * 创建无阻塞情况下，性能最优的并发队列
     */
    public static <E> ConcurrentLinkedQueue<E> newConcurrentNonBlockingQueue() {
        return new ConcurrentLinkedQueue<>();
    }

    /**
     * 创建无阻塞情况下，性能最优的并发双端队列
     */
    public static <E> Deque<E> newConcurrentNonBlockingDeque() {
        return new ConcurrentLinkedDeque<>();
    }

    /**
     * 创建并发阻塞情况下，长度不受限的队列.
     * <p>
     * 长度不受限，即生产者不会因为满而阻塞，但消费者会因为空而阻塞.
     */
    public static <E> LinkedBlockingQueue<E> newBlockingUnlimitQueue() {
        return new LinkedBlockingQueue<E>();
    }

    /**
     * 创建并发阻塞情况下，长度不受限的双端队列.
     * <p>
     * 长度不受限，即生产者不会因为满而阻塞，但消费者会因为空而阻塞.
     */
    public static <E> LinkedBlockingDeque<E> newBlockingUnlimitDeque() {
        return new LinkedBlockingDeque<>();
    }

    /**
     * 创建并发阻塞情况下，长度受限，更节约内存，但共用一把锁的队列（无双端队列实现）.
     */
    public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int capacity) {
        return new ArrayBlockingQueue<>(capacity);
    }

    /**
     * 创建并发阻塞情况下，长度受限，头队尾两把锁, 但使用更多内存的队列.
     */
    public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(int capacity) {
        return new LinkedBlockingQueue<>(capacity);
    }

    /**
     * 创建并发阻塞情况下，长度受限，头队尾两把锁, 但使用更多内存的双端队列.
     */
    public static <E> LinkedBlockingDeque<E> newBlockingDeque(int capacity) {
        return new LinkedBlockingDeque<>(capacity);
    }
}