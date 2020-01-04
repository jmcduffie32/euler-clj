(ns euler-clj.1)

(defn solve []
  (->> (range 1000)
       (filter #(or (= (rem % 3) 0) (= (rem % 5) 0)))
       (apply +)
       ))
