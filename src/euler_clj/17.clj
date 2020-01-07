(ns euler-clj.17)

(defn num->word [n]
  (cond
    (= n 0) ""
    (= n 1) "one"
    (= n 2) "two"
    (= n 3) "three"
    (= n 4) "four"
    (= n 5) "five"
    (= n 6) "six"
    (= n 7) "seven"
    (= n 8) "eight"
    (= n 9) "nine"
    (= n 10) "ten"
    (= n 11) "eleven"
    (= n 12) "twelve"
    (= n 13) "thirteen"
    (= n 14) "fourteen"
    (= n 15) "fifteen"
    (= n 16) "sixteen"
    (= n 17) "seventeen"
    (= n 18) "eighteen"
    (= n 19) "nineteen"
    (and (>= n 20) (< n 30)) (str "twenty" (num->word (rem n 10)))
    (and (>= n 30) (< n 40)) (str "thirty" (num->word (rem n 10)))
    (and (>= n 40) (< n 50)) (str "forty" (num->word (rem n 10)))
    (and (>= n 50) (< n 60)) (str "fifty" (num->word (rem n 10)))
    (and (>= n 60) (< n 70)) (str "sixty" (num->word (rem n 10)))
    (and (>= n 70) (< n 80)) (str "seventy" (num->word (rem n 10)))
    (and (>= n 80) (< n 90)) (str "eighty" (num->word (rem n 10)))
    (and (>= n 90) (< n 100)) (str "ninety" (num->word (rem n 10)))
    (= n 100) "onehundred"
    (= n 200) "twohundred"
    (= n 300) "threehundred"
    (= n 400) "fourhundred"
    (= n 500) "fivehundred"
    (= n 600) "sixhundred"
    (= n 700) "sevenhundred"
    (= n 800) "eighthundred"
    (= n 900) "ninehundred"
    (and (> n 100) (< n 200)) (str "onehundredand" (num->word (rem n 100)))
    (and (> n 200) (< n 300)) (str "twohundredand" (num->word (rem n 100)))
    (and (> n 300) (< n 400)) (str "threehundredand" (num->word (rem n 100)))
    (and (> n 400) (< n 500)) (str "fourhundredand" (num->word (rem n 100)))
    (and (> n 500) (< n 600)) (str "fivehundredand" (num->word (rem n 100)))
    (and (> n 600) (< n 700)) (str "sixhundredand" (num->word (rem n 100)))
    (and (> n 700) (< n 800)) (str "sevenhundredand" (num->word (rem n 100)))
    (and (> n 800) (< n 900)) (str "eighthundredand" (num->word (rem n 100)))
    (and (> n 900) (< n 1000)) (str "ninehundredand" (num->word (rem n 100)))
    1000 "onethousand"
    ))

(defn solve [n]
  (->> (for [i (range (inc n))]
         (count (num->word i)))
       (apply +)))
