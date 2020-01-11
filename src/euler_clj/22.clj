(ns euler-clj.22
  (:require [euler-clj.common :as c]))

(defn solve []
  (as-> (slurp "names.txt") $
    (clojure.string/trim-newline $)
    (subs $ 1 (dec (count $)))
    (clojure.string/split $ #"\",\"")
    (sort $)
    (for [i (range (count $))
          :let [name (nth $ i)]]
      (*' (apply +' (map c/get-alphabetical-value (seq name)))
          (inc i)))
    (apply + $)))
