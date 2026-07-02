package io.github.qishr.cascara.docs.examples.lang.factory;

import java.io.InputStream;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.common.lang.ast.AstNode;
import io.github.qishr.cascara.common.lang.ast.MapAstNode;
import io.github.qishr.cascara.common.lang.processor.AstParser;
import io.github.qishr.cascara.common.lang.processor.ProcessorFactory;

@Example
public class SimpleAstParse {
    public static void main(String args[]) {
        SimpleAstParse example = new SimpleAstParse();
        example.parse("subject.yaml", "application/yaml");
        example.parse("subject.json", "application/json");
    }

    private void parse(String fileName, String contentType) {
        InputStream is = SimpleAstParse.class.getResourceAsStream(fileName);
        AstParser<?,?> parser = new ProcessorFactory().createAstParser(contentType);
        AstNode root = parser.parse(is);
        if (root instanceof MapAstNode map) {
            System.out.println(map.getString("name"));
            System.out.println(map.getString("age"));
        }
    }
}
