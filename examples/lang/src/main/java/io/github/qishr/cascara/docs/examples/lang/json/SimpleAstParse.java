package io.github.qishr.cascara.docs.examples.lang.json;

import java.io.InputStream;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.lang.json.ast.JsonMapNode;
import io.github.qishr.cascara.lang.json.ast.JsonNode;
import io.github.qishr.cascara.lang.json.processor.JsonAstParser;

@Example
public class SimpleAstParse {
    public static void main(String args[]) {
        InputStream is = SimpleAstParse.class.getResourceAsStream("subject.json");
        JsonAstParser parser = new JsonAstParser();
        JsonNode root = parser.parse(is);
        if (root instanceof JsonMapNode map) {
            System.out.println(map.getString("name"));
            System.out.println(map.getString("age"));
        }
    }
}
