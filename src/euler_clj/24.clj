(ns euler-clj.24
  (:require [clojure.math.combinatorics :as combo]))

(defn solve [n]
  (->> (range n)
       (combo/permutations)
       (map #(BigInteger. (clojure.string/join %)))
       (sort)))
