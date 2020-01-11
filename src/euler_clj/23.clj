(ns euler-clj.23
  (:require [euler-clj.common :as c]))
(def abundant-nums
  (->> (range 28123)
       (filter c/is-abundant?)))

(def abundant-sums
  (for [x abundant-nums
        y abundant-nums
        :let [sum (+ x y)]
        :when (< sum 28123)]
    sum))

(def non-abundant-sums
  (clojure.set/difference (into #{} (range 28123))
                          (into #{} abundant-sums)))

(defn solve []
  (apply + non-abundant-sums))

;; supposed to get: 4179871
