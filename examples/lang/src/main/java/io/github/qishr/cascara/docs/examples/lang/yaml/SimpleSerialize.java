// License & Terms
//
// This file is part of **Cascara Examples**.
//
// **Cascara Examples** are free software: you can redistribute
// them and/or modify them without restriction under the terms of
// the MIT License.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// MIT License for more details.

package io.github.qishr.cascara.docs.examples.lang.yaml;

import io.github.qishr.cascara.common.annotation.Example;
import io.github.qishr.cascara.docs.examples.lang.subject.Person;
import io.github.qishr.cascara.lang.yaml.processor.YamlSerializer;

@Example
public class SimpleSerialize {
    public static void main(String args[]) {
        Person person = new Person("Dave", 31);
        YamlSerializer serializer = new YamlSerializer();
        String yamlString = serializer.toString(person);
        System.out.println("Serialized YAML:\n" + yamlString);
    }
}
