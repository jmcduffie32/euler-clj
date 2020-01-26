(ns euler-clj.46
  (:require [euler-clj.common :as c]))

(def odd-composites (filter #(not (c/prime? %)) (iterate (partial + 2) 9)))

(defn pass-conjecture [c]
  (some #(== (rem (Math/sqrt (/ (- c %) 2)) 1) 0) (take-while #(< % c) c/primes)))

(defn solve []
  (->> odd-composites
       (drop-while pass-conjecture)
       first))
