(ns demo.components.sign-up
  (:require [demo.env :as env]))

(defn root [{:keys [x] :as props}]
  [:div
   [:h1 "Sign Up: " x]
   [:p "imagine a form ..."]
   [:button {:on-click #(swap! env/app-state assoc :signed-in true :page :account-overview)} "Sign me up!"]
   ])
