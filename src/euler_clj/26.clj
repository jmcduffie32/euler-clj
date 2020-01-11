(ns euler-clj.26
  (:require [euler-clj.common :as c]))

(defn solve [n]
  (->> (range 2 n)
       (map (fn [val] {:val val :cycle-length (c/multiplicative-order 10 val)}))
       (apply (partial max-key :cycle-length))))
