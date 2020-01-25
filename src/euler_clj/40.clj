(ns euler-clj.40
  (:require [euler-clj.common :as c]))

(defn generate-digits [target]
  (loop [digits ""
         n 1]
    (if (<= (count digits) target)
      (recur (str digits n) (inc n))
      digits)))

(defn solve [n]
  (let [digits (generate-digits n)]
    (->> [0 9 99 999 9999 99999 999999]
         (map #(Character/digit (nth digits %) 10))
         (apply *))))
;; "Elapsed time: 23317.8872 msecs"

