(ns euler-clj.50
  (:require [euler-clj.common :as c]))

(defn consecutive-prime-sums [window-len limit]
  (for [n (iterate inc 0)
        :let [primes (take window-len (drop n c/primes))
              sum (apply + primes)]
        :while (< sum limit)
        :when (c/prime? sum)]
    sum))

(defn solve [limit]
  (->> (for [n (range 22 600)]
         {:length n :sum (last (consecutive-prime-sums n limit))})
       (filter #(:sum %))
       last))

