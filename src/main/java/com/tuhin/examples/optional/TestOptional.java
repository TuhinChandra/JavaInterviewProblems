package com.tuhin.examples.optional;

import java.util.Optional;

public class TestOptional {
    public static void main(final String[] args) {
        final ClassA instanceOfA = new ClassA();
        final ClassB instanceOfB = new ClassB();
        final ClassC instanceOfC = new ClassC();
        instanceOfA.setMemberB(instanceOfB);
        instanceOfB.setMemberC(instanceOfC);
//        instanceOfC.setValue("Tuhin");
        System.out.println(Optional.ofNullable(instanceOfA).map(ClassA::getMemberB).
                map(ClassB::getMemberC).
                map(ClassC::getValue).orElse(null));
    }
}
