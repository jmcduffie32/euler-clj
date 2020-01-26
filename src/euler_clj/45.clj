(ns euler-clj.45
  (:require [euler-clj.common :as c]))

(defn solve []
  (->> c/hexagon-nums
       (filter #(and (c/pentagon-num? %)
                     (c/triangle-num? %)))
       (drop-while #(<= % 40755))
       first))


