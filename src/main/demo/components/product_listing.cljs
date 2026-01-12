(ns demo.components.product-listing
  (:require
    [demo.env :as env]))

(defn root {:lazy-loadable "product-listing"} []
  [:div
   [:h1 "Product Listing"]

   [:ul
    (for [{:keys [id title] :as product}
          [{:id 1 :title "Foo"}
           {:id 2 :title "Bar"}]]

      [:li {:key id} [:a {:href "#" :on-click #(swap! env/app-state assoc :page :product-detail :product product)} title]]
      )]])
