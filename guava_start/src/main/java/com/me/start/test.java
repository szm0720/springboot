package com.me.start;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import lombok.extern.slf4j.Slf4j;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author: shimingming
 * @create: 2018-11-27
 * @description: 测试
 **/
@Slf4j
public class test {

    public static void main(String[] args) {

       /* Optional<Integer> possible = Optional.of(5);
        boolean present = possible.isPresent();// returns true
        Integer integer = possible.get();// returns 5

        log.info("{},{}",present,integer);*/

        /*Integer i=null;
        Integer j=5;
        System.out.println("j的值是：---" + j + "，当前方法=test.main()");

        checkArgument((i != null), "Expected i < j, but %s > %s", i, j);
*/
        boolean equal = Objects.equal("a", "a");// returns true

        boolean a = Objects.equal(null, "a");// returns false

        boolean a1 = Objects.equal("a", null);// returns false

        boolean equal1 = Objects.equal(null, null);// returns true

        // Returns "ClassName{x=1}"
//        Objects.toStringHelper(this).add("x", 1).toString();
        // Returns "MyObject{x=1}"
        String toString = Objects.toStringHelper("MyObject").add("x", 1).toString();


        System.out.println("");

    }
}
