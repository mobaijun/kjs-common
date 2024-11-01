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
     * 创建一个初始长度为指定值的 ArrayDeque (JDK 无 ArrayQueue)。
     * <p>
     * 数组满时会成倍扩容，默认为 16。
     */
    public static <E> ArrayDeque<E> createArrayDequeWithInitialSize(int initialSize) {
        return new ArrayDeque<>(initialSize);
    }

    /**
     * 创建一个 LinkedList 实现的双端队列。
     */
    public static <E> LinkedList<E> createLinkedDeque() {
        return new LinkedList<>();
    }

    /**
     * 创建无阻塞情况下性能最优的并发队列。
     */
    public static <E> ConcurrentLinkedQueue<E> createConcurrentQueue() {
        return new ConcurrentLinkedQueue<>();
    }

    /**
     * 创建无阻塞情况下性能最优的并发双端队列。
     */
    public static <E> Deque<E> createConcurrentDeque() {
        return new ConcurrentLinkedDeque<>();
    }

    /**
     * 创建长度不受限的阻塞队列。
     * <p>
     * 生产者不会因为队列满而阻塞，但消费者会因为队列空而阻塞。
     */
    public static <E> LinkedBlockingQueue<E> createUnboundedBlockingQueue() {
        return new LinkedBlockingQueue<>();
    }

    /**
     * 创建长度不受限的阻塞双端队列。
     * <p>
     * 生产者不会因为队列满而阻塞，但消费者会因为队列空而阻塞。
     */
    public static <E> LinkedBlockingDeque<E> createUnboundedBlockingDeque() {
        return new LinkedBlockingDeque<>();
    }

    /**
     * 创建长度受限的并发阻塞队列，节约内存但共用一把锁（无双端实现）。
     */
    public static <E> ArrayBlockingQueue<E> createArrayBlockingQueue(int capacity) {
        return new ArrayBlockingQueue<>(capacity);
    }

    /**
     * 创建长度受限的并发阻塞队列，头队尾各有一把锁，使用更多内存。
     */
    public static <E> LinkedBlockingQueue<E> createLinkedBlockingQueue(int capacity) {
        return new LinkedBlockingQueue<>(capacity);
    }

    /**
     * 创建长度受限的并发阻塞双端队列，头队尾各有一把锁，使用更多内存。
     */
    public static <E> LinkedBlockingDeque<E> createBlockingDeque(int capacity) {
        return new LinkedBlockingDeque<>(capacity);
    }
}