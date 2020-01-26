(ns euler-clj.44
  (:require [euler-clj.common :as c]))

;; 3n^2 - n -2p = 0
;; (1 +- sqrt(1 + 24p))/6 = n
(defn pentagon-num? [n]
  (let [result (/ (+ 1 (Math/sqrt (+ 1 (* 24 n)))) 6)]
    (== (int result) result)))

(defn solve [n]
  (let [pentagon-nums (take n c/pentagon-nums)]
    (filter #(not (nil? %)) (for [a pentagon-nums
                                  b pentagon-nums
                                  :let [sum (+ a b)
                                        diff (Math/abs (- a b))]]
                              ;; {:diff diff :a a :b b}
                              (if (and (not= a b)
                                       (pentagon-num? sum)
                                       (pentagon-num? diff))
                                {:diff diff :a a :b b})
                              ))))
