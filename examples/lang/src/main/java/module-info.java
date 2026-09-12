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

module cascara.docs.examples.lang {
    requires transitive cascara.common;
    requires transitive cascara.lang.json;
    requires transitive cascara.lang.xml;
    requires transitive cascara.lang.yaml;

    exports io.github.qishr.cascara.docs.examples.lang.factory;
    exports io.github.qishr.cascara.docs.examples.lang.json;
    exports io.github.qishr.cascara.docs.examples.lang.xml;
    exports io.github.qishr.cascara.docs.examples.lang.yaml;

    opens io.github.qishr.cascara.docs.examples.lang.json to cascara.common;
    opens io.github.qishr.cascara.docs.examples.lang.yaml to cascara.common;
}