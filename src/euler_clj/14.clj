(ns euler-clj.14
  (:require [euler-clj.common :as c]))

(defn solve [n]
  (first (apply (partial max-key second)
                (for [i (range (inc (int (/ n 2))) n 2)]
                  [i (count (take-while (partial not= 1) (c/collatz i)))]))))
