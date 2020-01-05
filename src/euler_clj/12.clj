(ns euler-clj.12
  (:require [euler-clj.common :as c]))

(defn has-under-500-divisors? [n]
  (> 500 (count (c/get-factors n))))

(defn solve []
  (->> c/triangle-nums
       (drop-while has-under-500-divisors?)
       first))
