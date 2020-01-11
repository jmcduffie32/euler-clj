(ns euler-clj.21
  (:require [euler-clj.common :as c]))

(defn solve [n]
  (->> (range n)
       (filter c/is-amicable?)
       (apply +)
       ))
