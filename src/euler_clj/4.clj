(ns euler-clj.4
  (:require [euler-clj.common :as common]))

(defn solve []
  (->> (for [x (range 999 100 -1)
             y (range 999 100 -1)]
         (* x y))
       (sort >)
       (drop-while #(not (common/palindrome-num? %)))
       (first)))
