(ns euler-clj.53
  (:require [euler-clj.common :as c]))

(def factorial (memoize c/factorial))


(defn solve [limit]
  (->> (for [n (range 1N 101N)
             r (range (inc n))]
         (/ (factorial n)
            (* (factorial r) (factorial (- n r)))))
       (filter #(> % limit))
       count))


