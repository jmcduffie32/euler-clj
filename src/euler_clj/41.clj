(ns euler-clj.41
  (:require [euler-clj.common :as c]))

(defn solve []
  (->> (range 7654321 1 -2)
       (filter #(and (c/n-digit-pandigital? %) (c/prime? %)))
       first))
