(ns build
  (:require
    [shadow.cljs.devtools.api :as shadow]
    [clojure.java.io :as io]))

(defn js-release []
  (shadow/release! :app))

(defn all []
  (js-release)

  :done)