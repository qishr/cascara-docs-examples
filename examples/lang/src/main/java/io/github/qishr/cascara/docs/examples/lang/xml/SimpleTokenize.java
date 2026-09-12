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

package io.github.qishr.cascara.docs.examples.lang.xml;

import java.io.InputStream;
import java.util.List;

import io.github.qishr.cascara.common.annotation.Example;
import io.github.qishr.cascara.lang.xml.processor.XmlTokenizer;
import io.github.qishr.cascara.lang.xml.token.XmlToken;

@Example
public class SimpleTokenize {
    public static void main(String args[]) {
        InputStream is = SimpleTokenize.class.getResourceAsStream("subject.xml");
        XmlTokenizer tokenizer = new XmlTokenizer();
        List<XmlToken> tokens = tokenizer.tokenize(is);
        for (XmlToken token : tokens) {
            System.out.println(token.getType() + " " + token.getLexeme());
        }
    }
}
