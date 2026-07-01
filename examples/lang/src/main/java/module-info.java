module cascara.docs.examples {
    requires transitive cascara.common;
    requires cascara.lang.json;
    requires cascara.lang.xml;
    requires cascara.lang.yaml;

    exports io.github.qishr.cascara.docs.examples.factory;
    exports io.github.qishr.cascara.docs.examples.json;
    exports io.github.qishr.cascara.docs.examples.xml;
    exports io.github.qishr.cascara.docs.examples.yaml;

    opens io.github.qishr.cascara.docs.examples.json to cascara.common;
    opens io.github.qishr.cascara.docs.examples.yaml to cascara.common;
}