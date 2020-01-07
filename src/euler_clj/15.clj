(ns euler-clj.15
  (:require [euler-clj.common :as c]))

(defn solve [x y]
  (/ (c/factorial (+ x y)) (*' (c/factorial x) (c/factorial y))))
