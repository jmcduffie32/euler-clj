(ns euler-clj.20
  (:require [euler-clj.common :as c]))

(defn solve [n]
  (-> (c/factorial n)
      str
      (clojure.string/split #"")
      (->> (map #(Integer. %))
           (apply +))
      ))
