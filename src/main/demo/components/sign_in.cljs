(ns demo.components.sign-in
  (:require [demo.env :as env]))

(defn root []
  [:div
   [:h1 "Sign In"]
   [:p "imagine a form ..."]
   [:button {:on-click #(swap! env/app-state assoc :signed-in true :page :account-overview)} "Sign me in already!"]])
