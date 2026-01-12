(ns demo.env
  (:require [reagent.core :as r]))

(defonce app-state
  (r/atom {:signed-in false
           :product-id nil
           :page :welcome}))


