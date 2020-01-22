(defn avgMark
    
    [Map]

    (def wordsWithA (reduce into []
            (filter 
            #(= "a" (subs (first %) (- (count (first %)) 1))) Map) 
        )
    )
  
    (def markSum (loop [sum 0 i 1]
        (if (>= i (count wordsWithA))
            sum
            (recur (+ sum (nth wordsWithA i)) (+ i 2))
            )
        )
    )       
  
  (print "Average grade for the given map: ")
  
  (print (float (/ markSum (/ (count wordsWithA) 2))))
  
)

(avgMark {"Raimonds" 2 "Petrovs" 6 "Maris" 8 "Natalija" 5 "Peteris" 10 "Marta" 2 "Sandra" 1 "Krišjanis" 9})          ; (5+2+1)/3 = 2.6666...