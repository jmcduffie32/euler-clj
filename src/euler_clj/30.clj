(ns euler-clj.30
  (:require [euler-clj.common :as c]))

(defn sum-of-fifths [digits]
  (apply + (map #(int (Math/pow % 5)) digits)))

(defn solve [limit]
  (->> (iterate inc 10)
       (filter (fn [n] (= n (sum-of-fifths (c/num->digits n)))))
       (take limit)
       (apply +)))

