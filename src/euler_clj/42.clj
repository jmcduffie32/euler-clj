(ns euler-clj.42
  (:require [euler-clj.common :as c]))

(defn word-value [word]
  (apply + (map c/get-alphabetical-value word)))

(def triangle-numbers (->> c/triangle-nums
                           (take-while #(<= % 192))
                           (into #{})))

(def words (-> (slurp "p042_words.txt")
               (clojure.string/replace #"\"" "")
               (clojure.string/split #",")))

(defn solve []
  (->> words
       (map word-value)
       (filter #(some #{%} triangle-numbers))
       count))
