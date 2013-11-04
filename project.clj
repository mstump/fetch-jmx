(defproject fetch_jmx "0.1.0"
  :description "fetch JMX stats of remote process"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/core.async "0.1.242.0-44b1e3-alpha"]
                 [org.clojure/data.json "0.2.3"]
                 [org.clojure/java.jmx "0.2.0"]
                 [org.clojure/tools.cli "0.2.4"]]
  :jvm-opts ["-Xmx1g" "-server"]
  :main fetch_jmx
  :aot :all)
