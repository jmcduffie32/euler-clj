(ns euler-clj.31)

(defn count-change [money [head & tail :as coins]]
  (if (= money 0)
    1
    (if (or (< money 0) (empty? coins))
      0
      (+ (count-change (- money head) coins) (count-change money tail)))))

(defn solve []
  (count-change 200 [200 100 50 20 10 5 2 1]))
