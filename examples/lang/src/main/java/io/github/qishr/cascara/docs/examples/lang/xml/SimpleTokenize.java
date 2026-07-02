package io.github.qishr.cascara.docs.examples.lang.xml;

import java.io.InputStream;
import java.util.List;

import io.github.qishr.cascara.common.lang.annotation.Example;
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
