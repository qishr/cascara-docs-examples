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

package io.github.qishr.cascara.docs.examples.lang.json;

import java.util.List;

import io.github.qishr.cascara.common.annotation.Example;
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
