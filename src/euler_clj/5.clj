(ns euler-clj.5
  (:require [euler-clj.common :as common]))

(defn brute-solve []
  "Elapsed time: 13241.2115 msecs"
  (->> (iterate inc 1)
       (drop-while #(or (not= 0 (rem % 2))
                        (not= 0 (rem % 3))
                        (not= 0 (rem % 4))
                        (not= 0 (rem % 5))
                        (not= 0 (rem % 6))
                        (not= 0 (rem % 7))
                        (not= 0 (rem % 8))
                        (not= 0 (rem % 9))
                        (not= 0 (rem % 10))
                        (not= 0 (rem % 11))
                        (not= 0 (rem % 12))
                        (not= 0 (rem % 13))
                        (not= 0 (rem % 14))
                        (not= 0 (rem % 15))
                        (not= 0 (rem % 16))
                        (not= 0 (rem % 17))
                        (not= 0 (rem % 18))
                        (not= 0 (rem % 19))
                        (not= 0 (rem % 20))))
       first))

(defn solve [num]
  "Elapsed time: 0.0921 msecs"
  (->> (range 2 num)
       (filter common/prime?)
       (map (fn [n] (Math/pow n (Math/floor (/ (Math/log num) (Math/log n))))))
       (apply *)
       ))
