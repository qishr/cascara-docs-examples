package io.github.qishr.cascara.docs.examples.yaml;

import java.io.InputStream;
import java.util.List;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.lang.yaml.processor.YamlTokenizer;
import io.github.qishr.cascara.lang.yaml.token.YamlToken;

@Example
public class SimpleTokenize {
    public static void main(String args[]) {
        InputStream is = SimplePushParse.class.getResourceAsStream("subject.yaml");
        YamlTokenizer tokenizer = new YamlTokenizer();
        List<YamlToken> tokens = tokenizer.tokenize(is);
        for (YamlToken token : tokens) {
            System.out.println(token.getType() + " " + token.getLexeme());
        }
    }
}
