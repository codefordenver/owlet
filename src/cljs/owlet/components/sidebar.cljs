(ns owlet.components.sidebar
  (:require [owlet.components.login :refer [login-component]]
            [re-frame.core :as rf]
            [re-com.core :as re-com :refer-macros [handler-fn]]
            [re-com.popover]
            [reagent.core :as reagent]))

(defn sidebar-component []
  (let [showing-branch? (reagent/atom false)
        showing-about? (reagent/atom false)]
    [:div#sidebar
     [:div#owlet-logo-div
      [:a#owlet-image {:href "#"}
        [:img#owlet-owl {:src "../img/owlet-owl.png"}]]]
     [:div.menu
      [:div.login
       [login-component]]
      [:a.navigation {:href "#/branches"}
       [re-com/popover-anchor-wrapper
         :showing? showing-branch?
         :position :below-right
         :anchor [:div.branch-icon
                  {:on-mouse-over (handler-fn (reset! showing-branch? true))
                   :on-mouse-out  (handler-fn (reset! showing-branch? false))}]
         :popover [re-com/popover-content-wrapper
                   :close-button? false
                   :popover-color "black"
                   :body "Go to activities"]]]
      [:a.navigation {:href "#/about"}
       [re-com/popover-anchor-wrapper
         :showing? showing-about?
         :position :below-right
         :anchor [:div.about-icon
                  {:on-mouse-over (handler-fn (reset! showing-about? true))
                   :on-mouse-out  (handler-fn (reset! showing-about? false))}]
         :popover [re-com/popover-content-wrapper
                   :close-button? false
                   :popover-color "black"
                   :body "Go to about"]]]]]))
