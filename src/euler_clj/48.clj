(ns euler-clj.48)

(defn solve [n]
  (rem (apply +' (for [a (range 1 n)]
                   (apply *' (repeat a a))))
       10000000000))
