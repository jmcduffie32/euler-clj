(ns euler-clj.52
  (:require [euler-clj.common :as c]))

(defn multiples-have-same-digits? [n]
  (= (sort (str n))
     (sort (str (* 2 n)))
     (sort (str (* 3 n)))
     (sort (str (* 4 n)))
     (sort (str (* 5 n)))
     (sort (str (* 6 n)))))


(defn solve []
  (->> (iterate inc 1)
       (filter multiples-have-same-digits?)
       (first)))
