(ns demo.components.sign-up
  (:require [demo.env :as env]))

(defn root {:lazy-loadable "sign-up"} []
  [:div
   [:h1 "Sign Up"]
   [:p "imagine a form ..."]
   [:button {:on-click #(swap! env/app-state assoc :signed-in true :page :account-overview)} "Sign me up!"]
   ])
