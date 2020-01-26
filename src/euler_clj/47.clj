(ns euler-clj.47
  (:require [euler-clj.common :as c]))

(defn solve []
  (->> (for [a (iterate inc 1)
             :let [b (inc a)
                   c (inc b)
                   d (inc c)]]
         {:ints [a b c d] :factors (concat (c/get-prime-factors a)
                                           (c/get-prime-factors b)
                                           (c/get-prime-factors c)
                                           (c/get-prime-factors d))})
       (drop-while #(< (count (:factors %)) 16))
       first))
