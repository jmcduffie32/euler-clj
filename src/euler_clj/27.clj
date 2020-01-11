(ns euler-clj.27
  (:require [euler-clj.common :as c]))

(defn consecutive-primes [f]
  (take-while c/prime? (map f (iterate inc 0))))

(defn solve []
  (->> (for [a (concat (range -999 0) (range 0 999))
             b (take-while #(<= % 1000) c/primes)]
         {:a a
          :b b
          :consecutive-primes-count (count
                                     (consecutive-primes
                                      (fn [n] (+ (* n n) (* a n) b))))})
       (apply (partial max-key :consecutive-primes-count))
       ((fn [m] (* (:a m) (:b m))))))

