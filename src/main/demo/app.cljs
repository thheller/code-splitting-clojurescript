(ns demo.app
  (:require
    ["react" :as react]
    [reagent.core :as r]
    [demo.env :as env]
    [demo.util :refer (lazy-component)]))

(defonce root-el (js/document.getElementById "root"))

(def product-detail (lazy-component demo.components.product-detail/root))
(def product-listing (lazy-component demo.components.product-listing/root))
(def sign-in (lazy-component demo.components.sign-in/root))
(def sign-up (lazy-component demo.components.sign-up/root))
(def account-overview (lazy-component demo.components.account-overview/root))

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
        [:> product-listing]

        :product-detail
        [:> product-detail {}]

        :sign-in
        [:> sign-in {}]

        :sign-up
        [:> sign-up {}]

        :account-overview
        [:> account-overview {}]

        :welcome
        [welcome {}]

        [:div "Unknown page?"]
        )]]))

(defn ^:dev/after-load start []
  (r/render [root] root-el))

(defn init []
  (start))