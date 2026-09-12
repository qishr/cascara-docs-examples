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

module cascara.docs.examples.ui {
    requires transitive cascara.common;
    requires transitive cascara.common.io;
    requires cascara.lang.json;
    requires cascara.lang.xml;
    requires transitive cascara.lang.yaml;
    requires transitive cascara.schema;
    requires transitive cascara.ui;

    requires javafx.base;
    requires transitive javafx.controls;
    requires javafx.graphics;

    exports io.github.qishr.cascara.docs.examples.ui to cascara.ui, javafx.base, javafx.graphics;
    opens io.github.qishr.cascara.docs.examples.ui to cascara.ui, cascara.schema, javafx.base;
}
