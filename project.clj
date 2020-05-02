(defproject alekcz/fire "0.2.4"
  :description "Firebase from Clojure. Basically Charmander 2.0"
  :url "https://github.com/alekcz/fire"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [ [org.clojure/clojure "1.10.2-alpha1"]
                  [alekcz/googlecredentials "3.0.1"]
                  [clj-http "3.10.1"]
                  [cheshire "5.10.0"]
                  [org.clojure/core.async "1.1.587"]]
  :plugins [[lein-cloverage "1.1.2"] 
            [lein-shell "0.5.0"]]
  :aot :all
  :main fire.core
  :uberjar-name "fire.jar"            
  :repl-options {:init-ns fire.core}
  :profiles { :dev {:dependencies [  [com.climate/claypoole "1.1.4"]
                                     [metosin/malli "0.0.1-20200404.091302-14"]]}}
  :aliases
  {"native"
    ["shell"
      "native-image" 
      "--enable-url-protocols=http,https"
      "--report-unsupported-elements-at-runtime"
      "--no-fallback"
      "--initialize-at-build-time"
      "--allow-incomplete-classpath"
      "--enable-all-security-services"
      "--no-server"
      "-jar" "./target/${:name}.jar"
      "-H:Name=./target/${:name}"]
      
  "run-native" ["shell" "./target/${:name}"]})
