(ns euler-clj.39)

(defn pythagorean-triples [p]
  (into #{} (->> (for [a (range 1 (quot p 2))
                       b (range 1 (- p a))
                       :let [c (- p (+ a b))]
                       ]
                   [a b c])
                 (filter (fn [[a b c]] (and (= (+ (* a a) (* b b)) (* c c))
                                            (= p (+ a b c)))))
                 (map sort))))

(defn solve [limit]
  (->> (range 2 limit 2)
       (map (fn [n] {:n n
                     :count (count (pythagorean-triples n))}))
       (apply (partial max-key :count))))
