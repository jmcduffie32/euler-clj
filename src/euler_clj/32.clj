(ns euler-clj.32)

(defn is-pandigital [s]
  (= (sort s) '(\1 \2 \3 \4 \5 \6 \7 \8 \9)))

(defn solve []
  (->> (for [a (range 2 100)
             b (range 2 (inc (/ 10000 a)))
            :let [c (* a b)]]
         {:combined (str a b c) :product c})
       (filter #(is-pandigital (:combined %)))
       (map :product)
       (into #{})
       (apply +)))
