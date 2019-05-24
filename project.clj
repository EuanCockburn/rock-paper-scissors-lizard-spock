(defproject rock-paper-scissors-lizard-spock "0.1.0-SNAPSHOT"
  :description "The game of rock-paper-scissors-lizard-spock"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.craigandera/dynne "0.4.1"]]
  :main ^:skip-aot rock-paper-scissors-lizard-spock.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
