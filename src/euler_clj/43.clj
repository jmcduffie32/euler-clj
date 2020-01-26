(ns euler-clj.43
  (:require [euler-clj.common :as c]))


(defn sub-string-divisible? [n start end divisor]
  (= 0
     (rem
      (Integer.
       (subs (str n)
             start
             (inc end)
             ))
      divisor)))

(defn solve []
  (->> (c/digit-permutations 1234567890)
       (filter #(and
                 (sub-string-divisible? % 1 3 2)
                 (sub-string-divisible? % 2 4 3)
                 (sub-string-divisible? % 3 5 5)
                 (sub-string-divisible? % 4 6 7)
                 (sub-string-divisible? % 5 7 11)
                 (sub-string-divisible? % 6 8 13)
                 (sub-string-divisible? % 7 9 17)
                 ))
       (apply +)))
