package io.github.qishr.cascara.docs.examples.json;

import java.util.List;

import io.github.qishr.cascara.common.lang.annotation.Example;
import io.github.qishr.cascara.lang.json.processor.JsonTokenizer;
import io.github.qishr.cascara.lang.json.token.JsonToken;

@Example
public class SimpleTokenize {
    public static void main(String args[]) {
        String text = "person: {\n" +
                      "  name: Dave\n" +
                      "  age: 31\n" +
                      "}";

        JsonTokenizer tokenizer = new JsonTokenizer();
        List<JsonToken> tokens = tokenizer.tokenize(text);
        for (JsonToken token : tokens) {
            System.out.println(token.getType() + " " + token.getLexeme());
        }
    }
}
