(ns euler-clj.33)

(defn solve []
  (->> (for [a (range 10 100)
             b (range 10 100)]
         {:numerator a :denominator b :fraction (/ a b)})
       (filter #(< (:fraction %) 1))
       (filter #(not= (:numerator %) (numerator (:fraction %))))
       (filter #(and (< (numerator (:fraction %)) 10)
                     (< (denominator (:fraction %)) 10)))
       (filter #(and (clojure.string/includes? (str (:numerator %)) (str (numerator (:fraction %))))
                     (clojure.string/includes? (str (:denominator %)) (str (denominator (:fraction %))))))
       (filter #(< 10 (/ (:numerator %) (numerator (:fraction %)))))
       (filter #(= 1 (count (clojure.set/intersection (into #{} (str (:numerator %)))
                                                      (into #{} (str (:denominator %)))))))))
;; crazy way of doing this
;; after getting to this point I just looked at the 9 remaining results
;; and was able to pull out the ones that fit the criteria in the problem

