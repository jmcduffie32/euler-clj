(ns euler-clj.9
  (:require [euler-clj.common :as common]))



(defn solve [n]
  (->> (for [c (range 1 n)
             b (range 1 c)
             a (range 1 b)]
         [a b c])
       (filter #(and (common/pythagorean-triple? %) (= n (apply + %))))
       first
       (apply *)))
