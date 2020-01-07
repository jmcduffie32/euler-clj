(ns euler-clj.16)

(defn solve [base exp]
  (apply + (map #(Character/digit % 10)
                (str (.pow (BigInteger. (str base)) exp)))))
