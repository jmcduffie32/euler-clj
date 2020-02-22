(ns euler-clj.common
  (:require [clojure.math.combinatorics :as combo]))

(def fibbonacci (map first (iterate (fn [[a b]] [b (+' a b)]) [1 2])))

(def triangle-nums (map first (iterate (fn [[a b]] [(+ a (inc b)) (inc b)]) [1 1])))

(def pentagon-nums (drop 1
                         (map first
                              (iterate
                               (fn [[a b]]
                                 [(/ (* b (- (* 3 b) 1)) 2) (inc b)])
                               [1 1]))))

(def hexagon-nums (drop 1
                         (map first
                              (iterate
                               (fn [[a b]]
                                 [(* b (- (* 2 b) 1)) (inc b)])
                               [1 1]))))

(defn pythagorean-triple? [[a b c]]
  (= (* c c) (+ (* a a) (* b b))))

(defn prime? [num]
  (if (>= 1 num)
    false
    (->> (range 2 (+ 0.5 (Math/sqrt num)))
         (filter #(= (rem num %) 0))
         empty?)))

(def primes (filter prime? (iterate inc 1)))

(defn get-factors [num]
  (let [root-ceil (Math/ceil (Math/sqrt num))]
    (->> (range 2 root-ceil)
         (filter #(= (rem num %) 0))
         (mapcat (fn [val]
                   (if (= num (* val val))
                     [val]
                     [val (/ num val)])))
         (concat (if (= root-ceil (Math/sqrt num)) [(int root-ceil)] [])))))

(defn get-prime-factors [n]
  (filter prime? (get-factors n)))

(defn palindrome? [str]
  (= str (clojure.string/reverse str)))

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
   (if (or (= n 1) (= n 0)) (*' 1 prod) (recur (dec n) (*' n prod)))))

(defn collatz [n] (iterate (fn [a] (if (even? a) (/ a 2) (+ 1 (* 3 a)))) n))

(defn get-proper-divisors [n]
  (concat [1] (into [] (get-factors n))))

(defn is-amicable? [a]
  (let [b (apply + (get-proper-divisors a))
        b-sum (apply + (get-proper-divisors b))]
    (and (not= a b)
         (= a b-sum))))

(defn get-alphabetical-value [character]
  (- (int character) 64))

(defn is-perfect? [n]
  (= n (apply + (get-proper-divisors n))))

(defn is-deficient? [n]
  (> n (apply + (get-proper-divisors n))))

(defn is-abundant? [n]
  (if (or (= n 1) (= n 0))
    false
    (< n (apply + (get-proper-divisors n)))))

(defn relatively-prime? [m n]
  (empty? (clojure.set/intersection
           (into #{} (concat [m] (get-factors m)))
           (into #{} (concat [n] (get-factors n))))))

(defn multiplicative-order [a n]
  (if ((comp not relatively-prime?) a n)
    -1
    (loop [result 1
           k 1]
      (let [new-result (mod (* result a) n)]
        (if (= new-result 1)
          k
          (recur new-result (inc k)))))))

(defn num->digits [n]
  (map #(Integer. %) (clojure.string/split (str n) #"")))

(defn concatenated-product [n m]
  (BigInteger. (clojure.string/join (map #(* % n) (range 1 (inc m))))))


(defn pandigital-number? [n]
  (= (sort (str n)) '(\1 \2 \3 \4 \5 \6 \7 \8 \9)))

(defn n-digit-pandigital? [n]
  (let [str-n (str n)]
    (= (sort str-n) (take (count str-n ) [\1 \2 \3 \4 \5 \6 \7 \8 \9]))))

(defn digit-permutations [n]
  (->> (str n)
       (combo/permutations)
       (filter #(not= (first %) \0))
       (map #(BigInteger. (clojure.string/join %)))))

(defn triangle-num? [n]
  (let [result (/ (+ -1 (Math/sqrt (+ 1 (* 8 n)))) 2)]
    (== (int result) result)))

(defn pentagon-num? [n]
  (let [result (/ (+ 1 (Math/sqrt (+ 1 (* 24 n)))) 6)]
    (== (int result) result)))

(defn hexagon-num? [n]
  (let [result (/ (+ 1 (Math/sqrt (+ 1 (* 8 n)))) 4)]
    (== (int result) result)))

(defn co-prime [n m]
  ())

(defn totient [n]
  (->> (range 1 n)
       (filter #(relatively-prime? n %))
       count))
