(ns euler-clj.19)

(def weekdays (cycle [:mon :tue :wed :thur :fri :sat :sun]))

(defn select-days [indexes weekdays]
  (for [i indexes] (nth weekdays i)))

(def days-in-year
  [0
   31
   59
   90
   120
   151
   181
   212
   243
   273
   304
   334])

(def days-in-leap-year
  [0
   31
   60
   91
   121
   152
   182
   213
   244
   274
   305
   335])

(def initial-state {:weekdays (drop 365 weekdays)
                    :total 0})

(defn get-firsts
  [{:keys [weekdays total] :as state} year]
  (if (= 0 (rem year 4))
    (-> state
        (assoc :total (+ total
                         (count (filter
                                 (partial = :sun)
                                 (select-days days-in-leap-year weekdays)))))
        (assoc (keyword (str year)) (select-days days-in-leap-year weekdays))
        (assoc :weekdays (drop 366 weekdays)))
    (-> state
        (assoc :total (+ total
                         (count (filter
                                 (partial = :sun)
                                 (select-days days-in-year weekdays)))))
        (assoc (keyword (str year)) (select-days days-in-year weekdays))
        (assoc :weekdays (drop 365 weekdays)))))

(defn solve
  [start-year end-year]
   (->> (range start-year end-year)
        (reduce get-firsts initial-state)))
