(ns euler-clj.7
  (:require [euler-clj.common :as common]))

(defn solve [n]
  (nth common/primes n))
