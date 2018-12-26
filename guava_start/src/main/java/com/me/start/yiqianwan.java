package com.me.start;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: shimingming
 * @create: 2018-11-27
 * @description:
 **/
public class yiqianwan {

    @Test
    public void hashMapTest() {
        long star = System.currentTimeMillis();
        Integer size=10000000;
        Set<Integer> hashset = new HashSet<>(size);
        for (int i = 0; i < size; i++) {
            hashset.add(i);
        }
        Assert.assertTrue(hashset.contains(1));
        Assert.assertTrue(hashset.contains(2));
        Assert.assertTrue(hashset.contains(3));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }

    @Test
    public void guavaTest() {
        long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01);
        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }
        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));
        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }
}
