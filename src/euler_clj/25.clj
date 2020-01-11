(ns euler-clj.25
  (:require [euler-clj.common :as c]))

(def fib-counts
  (for [i (iterate inc 0)
        :let [n (nth c/fibbonacci i)]]
    {:index i :digit-count (count (str n))}))

;; increment the index by two to account for zero offset and starting
;; fibonacci at [1 2]
(defn solve []
  (+ 2 (:index (first (drop-while #(< (:digit-count %) 1000) fib-counts)))))

