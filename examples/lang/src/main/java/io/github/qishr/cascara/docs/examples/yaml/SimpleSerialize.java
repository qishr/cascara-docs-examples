package io.github.qishr.cascara.docs.examples.yaml;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.docs.examples.subject.Person;
import io.github.qishr.cascara.lang.yaml.processor.YamlSerializer;

@Example
public class SimpleSerialize {
    public static void main(String args[]) {
        Person person = new Person("Dave", 31);
        YamlSerializer serializer = new YamlSerializer();
        String yamlString = serializer.toText(person);
        System.out.println("Serialized YAML:\n" + yamlString);
    }
}
