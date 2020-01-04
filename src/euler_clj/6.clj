(ns euler-clj.6
  (:require [euler-clj.common :as common]))


(defn sum-of-squares [n]
  (->> (range (inc n))
       (map #(Math/pow % 2))
       (apply +)))

(defn square-of-sums [n]
  (Math/pow (->> (range (inc n))
                 (apply +))
            2))

(defn solve [n]
  (- (square-of-sums n) (sum-of-squares n)))
