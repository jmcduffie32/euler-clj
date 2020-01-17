(ns euler-clj.38
  (:require [euler-clj.common :as c]))

(defn is-pandigital-sub [n]
  (let [str-n (str n)]
    (and (re-matches #"[1-9]+" str-n)
         (= (count (into #{} str-n)) (count str-n)))))

(def pandigital-subs (filter is-pandigital-sub (iterate inc 1)))

(defn solve []
  (->> pandigital-subs
       (take-while #(< % 10000))
       (map #(c/concatenated-product % 2))
       (filter c/pandigital-number?)
       (apply max)))
