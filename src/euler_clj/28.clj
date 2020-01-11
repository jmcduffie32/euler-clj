(ns euler-clj.28
  (:require [euler-clj.common :as c]))
(defn square-diagonals
  [n]
  (->> (range  (inc n))
       (filter odd?)
       (map #(* % %))))

(defn solve [dimension]
  (->> (let [diags (square-diagonals dimension)]
        (for [i (range (count diags))
              :let [n (nth diags i)]]
          (if (= n 1)
            [1]
            (into [] (map (fn [x] (- n (* i 2 x))) [0 1 2 3])))))
      flatten
      (apply +)))
