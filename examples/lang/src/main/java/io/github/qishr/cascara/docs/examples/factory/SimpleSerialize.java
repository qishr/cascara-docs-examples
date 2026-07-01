package io.github.qishr.cascara.docs.examples.factory;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.common.lang.processor.ProcessorFactory;
import io.github.qishr.cascara.common.lang.processor.Serializer;
import io.github.qishr.cascara.docs.examples.subject.Person;

@Example
public class SimpleSerialize {
    public static void main(String args[]) {
        Person person = new Person("Dave", 31);
        Serializer<?> serializer = new ProcessorFactory().createSerializer("text/yaml");
        String text = serializer.toText(person);
        System.out.println("Serialized JSON:\n" + text);
    }
}
