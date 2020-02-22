(ns euler-clj.49
  (:require [euler-clj.common :as c]
            [clojure.math.combinatorics :as combo]))

(def four-digit-primes
  (->> c/primes
       (drop-while #(< % 1000))
       (take-while #(< % 10000))))

(def permutations-map
  (->>(loop [primes four-digit-primes
             digits {}]
        (if (empty? primes)
          digits
          (recur (drop 1 primes)
                 (update digits
                         (filter c/prime? (c/digit-permutations (first primes)))
                         (fn [v] (if (nil? v) 0 (inc v)))))))))

(defn find-multiples [n-seq]
  (flatten (filter #(> (count %) 1)
                   (for [n n-seq]
                     (filter #(zero? (rem % n)) n-seq)))))

(defn solve []
  (->> permutations-map
       keys
       (map (fn [[head & rest :as digits]]
              (let [differences (for [n rest]
                                  (- n head))]
                {:digits digits
                 :differences differences
                 :multiples (find-multiples differences)})))
       (filter #(= (count (:multiples %)) 2))
       (filter (fn [{:keys [multiples]}]
                 (= (* 2 (first multiples)) (second multiples))))
       ;; (filter #(not (empty? (find-multiples (:differences %)))))
       ;; (filter #(some #{1487} (:digits %)))
       ))
