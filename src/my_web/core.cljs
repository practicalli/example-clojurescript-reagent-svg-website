(ns my-web.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(println "This text is printed from src/my-web/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


(defn hello-world []
  [:div {:class "container"}
   [:h1 {:class "jumbotron"}
    (:text @app-state)]
   [:p "I really love figwheel"]

   [:div {:class "row"}
    [:div {:class "col-md-3"}
     [:p "ACME Infrastructure Locations"]
     ]
    [:svg
     [:circle {:r 50, :cx 75, :cy 75, :fill "green"}]]]])

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
