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

package io.github.qishr.cascara.docs.examples.spl;

import io.github.qishr.cascara.common.annotation.Example;
import io.github.qishr.cascara.common.service.SPL;
import io.github.qishr.cascara.common.util.ContentType;
import io.github.qishr.cascara.common.util.ContentTypeResolver;

@Example
public class NeoSingleton {
    public static void main(String args[]) {
        ContentTypeResolver contentTypes = SPL.load(ContentTypeResolver.class);
        ContentType contentType = contentTypes.resolve(".yaml");
        System.out.println("YAML Content Type: " + contentType);
    }
}
