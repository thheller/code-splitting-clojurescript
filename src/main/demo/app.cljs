(ns demo.app
  (:require
    ["react" :as react]
    [reagent.core :as r]
    [reagent.dom :as rd]
    [demo.env :as env]
    [demo.util :refer (lazy)]))

(defonce root-el (js/document.getElementById "root"))

(defn welcome []
  [:h1 "Welcome to my Shop!"])

(defn nav []
  (let [{:keys [signed-in] :as state} @env/app-state]
    [:ul
     [:li [:a {:href "#" :on-click #(swap! env/app-state assoc :page :welcome)} "Home"]]
     [:li [:a {:href "#" :on-click #(swap! env/app-state assoc :page :product-listing)} "Product Listing"]]
     (if signed-in
       [:li [:a {:href "#" :on-click #(swap! env/app-state assoc :page :account-overview)} "My Account"]]
       [:<>
        [:li [:a {:href "#" :on-click #(swap! env/app-state assoc :page :sign-in)} "Sign In"]]
        [:li [:a {:href "#" :on-click #(swap! env/app-state assoc :page :sign-up)} "Sign Up"]]
        ])]))

(defn root []
  (let [{:keys [page] :as state} @env/app-state]

    [:div
     [:h1 "Shop Example"]

     [nav {}]

     [:> react/Suspense {:fallback (r/as-element [:div "Loading ..."])}
      (case page
        :product-listing
        [:> (lazy "product-listing") {}]

        :product-detail
        [:> (lazy "product-detail") {}]

        :sign-in
        [:> (lazy "sign-in") {}]

        :sign-up
        [:> (lazy "sign-up") {}]

        :account-overview
        [:> (lazy "account-overview") {}]

        :welcome
        [welcome {}]

        [:div "Unknown page?"]
        )]]))

(defn ^:dev/after-load start []
  (rd/render [root] root-el))

(defn init []
  (start))