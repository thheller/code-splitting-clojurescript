(ns demo.util)

(defmacro lazy-component [the-sym]
  `(demo.util/lazy-component* (shadow.lazy/loadable ~the-sym)))
