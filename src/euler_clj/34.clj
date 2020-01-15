(ns euler-clj.34
  (:require [euler-clj.common :as c]))

(defn solve [num-to-take]
  (->> (iterate inc 3)
       (filter #(= % (apply + (map c/factorial (c/num->digits %)))))
       (take num-to-take)
       (apply +)))

;; only 2 values
;; (solve 2)
