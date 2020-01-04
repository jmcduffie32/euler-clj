(ns euler-clj.3
  (:require [euler-clj.common :as common]))

(defn solve [num]
  (->> (common/get-factors num)
       (filter common/prime?)
       last))
