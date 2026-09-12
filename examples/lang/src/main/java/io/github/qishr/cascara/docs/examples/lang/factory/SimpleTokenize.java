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

package io.github.qishr.cascara.docs.examples.lang.factory;

import java.io.InputStream;
import java.util.List;

import io.github.qishr.cascara.common.annotation.Example;
import io.github.qishr.cascara.common.lang.util.ProcessorFactory;
import io.github.qishr.cascara.common.lang.processor.Tokenizer;
import io.github.qishr.cascara.common.lang.token.Token;

@Example
public class SimpleTokenize {
    public static void main(String args[]) {
        InputStream is = SimpleAstParse.class.getResourceAsStream("subject.yaml");
        Tokenizer<?> tokenizer = new ProcessorFactory().createTokenizer("text/yaml");
        List<? extends Token> tokens = tokenizer.tokenize(is);
        for (Token token : tokens) {
            System.out.println(token.getType() + " " + token.getLexeme());
        }
    }
}
