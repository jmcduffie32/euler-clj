(ns euler-clj.35
  (:require [euler-clj.common :as c]
            [clojure.math.combinatorics :as combo]))

(defn get-digit-combinations [n]
  (let [digits (c/num->digits n)
        digit-count (count digits)
        digit-cycle (into [] (take (* 2 digit-count) (cycle digits)))]
    (for [i (range digit-count)]
      (Integer. (apply str (subvec digit-cycle i (+ i digit-count)))))))

(defn solve [limit]
  (->> c/primes
       (take-while #(< % limit))
       (filter (fn [n] (every? c/prime? (get-digit-combinations n))))
       count))
