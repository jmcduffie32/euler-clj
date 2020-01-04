(ns euler-clj.common)

(def fibbonacci (map first (iterate (fn [[a b]] [b (+' a b)]) [1 2])))

(defn prime? [num]
  (->> (range 2 (Math/sqrt num))
       (filter #(= (rem num %) 0))
       empty?))

(defn get-factors [num]
  (->> (range 2 (Math/sqrt num))
       (filter #(= (rem num %) 0))))
