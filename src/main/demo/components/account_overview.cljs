(ns demo.components.account-overview
  (:require [demo.env :as env]))

(defn root []
  [:div
   [:h1 "Account Overview"]

   [:button {:on-click #(swap! env/app-state assoc :signed-in false :page :welcome)} "Sign me out ..."]])
