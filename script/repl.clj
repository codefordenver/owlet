; This script runs a Figwheel REPL within the Cursive environment. See
; https://github.com/bhauman/lein-figwheel/wiki/Running-figwheel-in-a-Cursive-Clojure-REPL

(use 'figwheel-sidecar.repl-api)

(start-figwheel!) ;; <-- fetches configuration
(cljs-repl)

