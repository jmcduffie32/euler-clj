(ns euler-clj.10
  (:require [euler-clj.common :as common]))

(defn less-than-or-equal-to-2000000 []
  (partial >= 2000000))

(defn solve [n]
  (->> (common/gen-primes)
       (take-while (partial >= n) )
       (apply +)))

;; "Elapsed time: 3829.3284 msecs" with gen-primes (seive)
;; "Elapsed time: 12669.3736 msecs" with primes (division-test)
