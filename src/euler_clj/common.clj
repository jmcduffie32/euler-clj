(ns euler-clj.common)

(def fibbonacci (map first (iterate (fn [[a b]] [b (+' a b)]) [1 2])))

(defn prime? [num]
  (->> (range 2 (+ 0.5 (Math/sqrt num)))
       (filter #(= (rem num %) 0))
       empty?))

(def primes (filter prime? (iterate inc 1)))

(defn get-factors [num]
  (->> (range 2 (Math/sqrt num))
       (filter #(= (rem num %) 0))
       (mapcat (fn [val] [val (/ num val)]))))

(defn palindrome? [str]
  (= str (clojure.string/join (reverse str))))

(defn palindrome-num? [num]
  (palindrome? (str num)))
