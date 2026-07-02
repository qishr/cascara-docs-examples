package io.github.qishr.cascara.docs.examples.lang.yaml;

import java.io.InputStream;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.lang.yaml.ast.YamlMapNode;
import io.github.qishr.cascara.lang.yaml.ast.YamlNode;
import io.github.qishr.cascara.lang.yaml.processor.YamlAstParser;

@Example
public class SimpleAstParse {
    public static void main(String args[]) {
        InputStream is = SimpleAstParse.class.getResourceAsStream("subject.yaml");
        YamlAstParser parser = new YamlAstParser();
        YamlNode yaml = parser.parse(is);
        if (yaml instanceof YamlMapNode map) {
            System.out.println(map.getString("name"));
            System.out.println(map.getString("age"));
        }
    }
}
