(ns demo.util
  (:require
    ["react" :as react]
    [reagent.core :as r]
    [shadow.esm :as esm]))

(def cache #js {})

(defn lazy [loadable]
  (or (unchecked-get cache loadable)
      (let [lazy
            (react/lazy
              (fn []
                (-> (esm/load-by-name loadable)
                    (.then (fn [loaded]
                             ;; React.lazy expects to load a ES6 module with a React Component as default export

                             ;; this would be more correct in production settings
                             ;; #js {:default (r/reactify-component (loaded))}

                             ;; we need wrap the loaded component one extra level so live-reload actually works
                             ;; since React will keep a reference to the initially loaded fn and won't update it
                             #js {:default (r/reactify-component
                                             (fn [props]
                                               ;; loaded is a fn used to get the current version of whatever was loaded
                                               ;; it uses and extra wrapper so that the reference can be replaced
                                               ;; via hot-reload or the REPL
                                               (let [current (loaded)]
                                                 (current props))))}
                             )))))]

        ;; placing things in the cache so we always return the same lazy instance
        ;; allows using this directly in [:> (lazy "thing") ...] instead of having a top level (def ...)
        (unchecked-set cache loadable lazy)
        lazy)))

