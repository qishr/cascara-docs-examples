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

module cascara.docs.examples.schema {
    requires transitive cascara.common;
    requires cascara.common.io;
    requires cascara.lang.json;
    requires cascara.lang.xml;
    requires cascara.lang.yaml;
    requires cascara.schema;

    // Allow IOUtils to read the resources
    opens io.github.qishr.cascara.docs.examples.schema to cascara.common.io;
}