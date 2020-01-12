(ns euler-clj.29)

(defn solve [a b]
  (->> (for [a (range 2 (inc a))
             b (range 2 (inc b))]
         (bigint (Math/pow a b)))
       (into #{})
       count))
