package io.github.qishr.cascara.docs.examples.lang.json;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.docs.examples.lang.subject.Person;
import io.github.qishr.cascara.lang.json.processor.JsonSerializer;

@Example
public class SimpleSerialize {
    public static void main(String args[]) {
        Person person = new Person("Dave", 31);
        JsonSerializer serializer = new JsonSerializer();
        String text = serializer.toText(person);
        System.out.println("Serialized JSON:\n" + text);
    }
}
