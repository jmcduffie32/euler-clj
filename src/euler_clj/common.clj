(ns euler-clj.common)

(def fibbonacci (map first (iterate (fn [[a b]] [b (+' a b)]) [1 2])))

(def triangle-nums (map first (iterate (fn [[a b]] [(+ a (inc b)) (inc b)]) [1 1])))

(defn pythagorean-triple? [[a b c]]
  (= (* c c) (+ (* a a) (* b b))))

(defn prime? [num]
  (if (>= 0 num)
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

(defn are-relatively-prime? [m n]
  (empty? (clojure.set/intersection
           (into #{} (concat [m] (get-factors m)))
           (into #{} (concat [n] (get-factors n))))))

(defn multiplicative-order [a n]
  (if ((comp not are-relatively-prime?) a n)
    -1
    (loop [result 1
           k 1]
      (let [new-result (mod (* result a) n)]
        (if (= new-result 1)
          k
          (recur new-result (inc k)))))))
