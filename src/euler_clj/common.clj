(ns euler-clj.common)

(def fibbonacci (map first (iterate (fn [[a b]] [b (+' a b)]) [1 2])))

(def triangle-nums (map first (iterate (fn [[a b]] [(+ a (inc b)) (inc b)]) [1 1])))

(defn pythagorean-triple? [[a b c]]
  (= (* c c) (+ (* a a) (* b b))))

(defn prime? [num]
  (->> (range 2 (+ 0.5 (Math/sqrt num)))
       (filter #(= (rem num %) 0))
       empty?))

(def primes (filter prime? (iterate inc 1)))

(defn get-factors [num]
  (->> (range 2 (Math/sqrt num))
       (filter #(= (rem num %) 0))
       (mapcat (fn [val] [val (/ num val)]))))

(defn palindrome? [str]
  (= str (clojure.string/join (reverse str))))

(defn palindrome-num? [num]
  (palindrome? (str num)))

;; https://stackoverflow.com/questions/960980/fast-prime-number-generation-in-clojure
(defn gen-primes "Generates an infinite, lazy sequence of prime numbers"
  []
  (letfn [(reinsert [table x prime]
            (update-in table [(+ prime x)] conj prime))
          (primes-step [table d]
            (if-let [factors (get table d)]
              (recur (reduce #(reinsert %1 d %2) (dissoc table d) factors)
                     (inc d))
              (lazy-seq (cons d (primes-step (assoc table (* d d) (list d))
                                             (inc d))))))]
    (primes-step {} 2)))

(defn transpose [m]
  (apply mapv vector m))

(defn factorial
  ([n] (factorial n 1))
  ([n prod]
   (if (= n 1) (*' n prod) (recur (dec n) (*' n prod)))))

(defn collatz [n] (iterate (fn [a] (if (even? a) (/ a 2) (+ 1 (* 3 a)))) n))
