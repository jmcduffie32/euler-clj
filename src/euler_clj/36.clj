(ns euler-clj.36
  (:require [euler-clj.common :as c]))

(defn solve [limit]
  (->> (range limit)
       (filter (fn [n]
                 (and (c/palindrome? (Integer/toString n 10))
                      (c/palindrome? (Integer/toString n 2)))))
       (apply +)))
