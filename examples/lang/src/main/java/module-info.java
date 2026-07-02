module cascara.docs.examples.lang {
    requires transitive cascara.common;
    requires cascara.lang.json;
    requires cascara.lang.xml;
    requires cascara.lang.yaml;

    exports io.github.qishr.cascara.docs.examples.lang.factory;
    exports io.github.qishr.cascara.docs.examples.lang.json;
    exports io.github.qishr.cascara.docs.examples.lang.xml;
    exports io.github.qishr.cascara.docs.examples.lang.yaml;

    opens io.github.qishr.cascara.docs.examples.lang.json to cascara.common;
    opens io.github.qishr.cascara.docs.examples.lang.yaml to cascara.common;
}