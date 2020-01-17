(ns euler-clj.37
  (:require [euler-clj.common :as c]))
(defn get-truncated-values [n]
  (let [str-n (str n)
        str-length (count str-n)
        left-truncate (for [i (range str-length)]
                        (Integer. (subs str-n i str-length)))
        right-truncate (for [i (range 1 str-length)]
                         (Integer. (subs str-n 0 (- str-length i))))]
    (concat left-truncate right-truncate)))

(defn solve []
  (->> c/primes
       (map #(into [] (c/num->digits %)))
       (filter (fn [digits]
                 (and (every? odd? (subvec digits 1 (count digits)))
                      (some #{(first digits)} '(2 3 5 7))
                      (some #{(last digits)} '(2 3 5 7)))))
       (map (fn [digits] (Integer. (clojure.string/join digits))))
       (filter (fn [n]
                 (every? c/prime? (get-truncated-values n))))
       (drop 4)
       (take 11)
       (apply +)))

;; has to start and end with (2 3 5 7)
;; numbers in the middle must be odd
