(ns euler-clj.2
  (:require [euler-clj.common :as common]))

(defn solve []
  (->> common/fibbonacci
       (take-while #(< % 4000000))
       (filter odd?)
       (apply +)))
