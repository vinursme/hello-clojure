(defproject hello-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  ;; 主函数入口
  :main ^:skip-aot hello-clojure.main

  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
