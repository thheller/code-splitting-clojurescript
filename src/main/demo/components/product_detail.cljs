(ns demo.components.product-detail
  (:require [demo.env :as env]))

(defn root []
  [:div
   [:h1 "Product Detail"]
   [:div (pr-str (:product @env/app-state))]])
